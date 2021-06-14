
package sample;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlType(propOrder={"patients"})
public class Result {

    private List<Patient> patients;

    public Result() {
        this.patients = null;
    }

    public Result(List<Patient> patients){
        this.patients = patients;
    }

    @XmlElement(name = "patient")
    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public static List<Patient> getInfectiousPatients(String result1, String startDate,String endDate, String zipCode) throws JAXBException {


        List<Patient> patients = new ArrayList<Patient>();

        String sqlSelect = String.format("SELECT DISTINCT idTest, `name`, `result`, t.`type`, testDate, idHP, p.CPR, g.ZIPcode FROM cdb.test t  LEFT JOIN cdb.patient p ON t.CPR = p.CPR  LEFT JOIN cdb.geolocation g ON t.CPR = g.CPR  WHERE t.`result` =%s AND  t.testDate BETWEEN '%s 00:00:00' and '%s 23:59:00' AND g.ZIPcode = %s;", result1, startDate, endDate, zipCode);
        System.out.println(sqlSelect);
        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement(sqlSelect);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    String mutationType = rs.getString("type");
                    String name = rs.getString("name");
                    boolean result = rs.getBoolean("result");
                    int CPR = rs.getInt("CPR");
                    LocalDate testDate = rs.getDate("testDate").toLocalDate();
                    int personZipCode = rs.getInt("zipCode");

                    Patient person = new Patient(
                            name,
                            CPR,
                            result,
                            personZipCode,
                            mutationType,
                            testDate
                    );
                    patients.add(person);
                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return patients;
    }

    public static boolean generateXMLReport(List<Patient> infectiousPatients) throws JAXBException {

        System.out.println(infectiousPatients);
        Result result = new Result(infectiousPatients);


        JAXBContext jaxbContext = JAXBContext.newInstance(Result.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(result, System.out);
        return true;
    }



}
