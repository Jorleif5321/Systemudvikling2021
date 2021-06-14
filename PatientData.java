package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class PatientData {
    private String name;
    private Integer CPR;
    private Integer tNumber;
    private LocalDate birthDate;
    private String streetName;
    private Integer streetNumber;


    private Integer ZIPcode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCPR() {
        return CPR;
    }

    public void setCPR(Integer CPR) {
        this.CPR = CPR;
    }

    public Integer gettNumber() {
        return tNumber;
    }

    public void settNumber(Integer tNumber) {
        this.tNumber = tNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Integer getZIPcode() {
        return ZIPcode;
    }

    public void setZIPcode(Integer ZIPcode) {
        this.ZIPcode = ZIPcode;
    }

    public PatientData(String name, Integer CPR, LocalDate birthDate, Integer tNumber, String streetName, Integer streetNumber, Integer ZIPcode) {
        this.name = name;
        this.CPR = CPR;
        this.birthDate = birthDate;
        this.tNumber = tNumber;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.ZIPcode = ZIPcode;
    }
    public static boolean getTestData(String CPR) throws SQLException {

        ObservableList<PatientData> list = FXCollections.observableArrayList();


        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement("Select * FROM cdb.test Where CPR =" + CPR);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    String name = rs.getString("name");
                    Integer CPR2 = rs.getInt("CPR");
                    LocalDate birthDate = rs.getDate("birthDate").toLocalDate();
                    Integer tNumber = rs.getInt("tNumber");
                    String streetName = rs.getString("streetName");
                    Integer streetNumber = rs.getInt("streetNumber");
                    Integer ZIPcode = rs.getInt("ZIPcode");

                    list.add(new PatientData(name, CPR2, birthDate, tNumber, streetName, streetNumber, ZIPcode));

                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return true;
    }









}
