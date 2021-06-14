package sample;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement
public class Patient {


    //create/modify patients
    //add/edit tests,
    // and add/edit results of the tests.

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    @XmlElement(name = "CPR")
    public Integer getCPR() {
        return CPR;
    }
    @XmlElement(name = "result")
    public Boolean getResult() {
        return result;
    }

    @XmlElement(name = "ZipCode")
    public Integer getZipCode() {
        return ZipCode;
    }

    @XmlElement(name = "mutationType")
    public String getMutationType() {
        return mutationType;
    }

    @XmlElement(name = "testDate")
    public String getTestDate() {
        return testDate.toString();
    }

    private String name;
    private Integer CPR;
    private Boolean result;
    private Integer ZipCode;
    private String mutationType;
    private LocalDate testDate;

    public Patient() {
        this.name = null;
        this.CPR = null;
        this.result = null;
        this.ZipCode = null;
        this.mutationType = null;
        this.testDate = null;
    }

    public Patient(String name, int CPR, boolean result, int ZipCode, String mutationType, LocalDate testDate) {
        this.name = name;
        this.CPR = CPR;
        this.result = result;
        this.ZipCode = ZipCode;
        this.mutationType = mutationType;
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", CPR=" + CPR +
                ", result=" + result +
                ", ZipCode=" + ZipCode +
                ", mutationType=" + mutationType +
                ", testDate=" + testDate +
                '}';
    }


        public static boolean setTestData (String result, String type, String sDate1, String idHP, String CPR ){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.parse(sDate1, formatter);
            Date birthdate = Date.valueOf(localDate);

            String insert = "INSERT INTO cdb.test ( result, type, testDate, idHP, CPR )" + " values ( ?, ?, ?, ?, ? )";


            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

                PreparedStatement preparedStmt = con.prepareStatement(insert);
                preparedStmt.setString(1, result);
                preparedStmt.setString(2, type);
                preparedStmt.setDate(3, birthdate);
                preparedStmt.setString(4, idHP);
                preparedStmt.setString(5, CPR);
                preparedStmt.execute();
                System.out.println("TestData set");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return false;
        }
        public static boolean setGeoLocationData (String latitude, String longitude, String type, String sDate1, String
        ZipCode, String CPR){

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.parse(sDate1, formatter);
            Date registrationDate = Date.valueOf(localDate);

            String insert = "INSERT INTO cdb.geolocation ( latitude, longitude, type, ZipCode, registrationDate, CPR)" + " values ( ?, ?, ?, ?, ?, ? )";


            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

                PreparedStatement preparedStmt = con.prepareStatement(insert);
                preparedStmt.setString(1, latitude);
                preparedStmt.setString(2, longitude);
                preparedStmt.setString(3, type);
                preparedStmt.setString(4, ZipCode);
                preparedStmt.setDate(5, registrationDate);
                preparedStmt.setString(6, CPR);
                preparedStmt.execute();
                System.out.println("Geo set");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return false;
        }
        public static boolean setSensorData (String temperature, String pulls, String CPR){
            String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
            String password = "Sveners3j5321!";
            String insert = "INSERT INTO cdb.sensor ( temperature, pulls, CPR)" + " values ( ?, ?, ? )";


            try (Connection con = DriverManager.getConnection(url, null, password)) {

                PreparedStatement preparedStmt = con.prepareStatement(insert);
                preparedStmt.setString(1, temperature);
                preparedStmt.setString(2, pulls);
                preparedStmt.setString(3, CPR);
                preparedStmt.execute();
                System.out.println("Sensor set");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            return false;

        }


    }

