package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class geoData {




    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getZipCode() {
        return ZipCode;
    }

    public void setZipCode(Integer zipCode) {
        ZipCode = zipCode;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public geoData(Integer latitude, Integer longitude, String type, Integer zipCode, LocalDate registrationDate) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        ZipCode = zipCode;
        this.registrationDate = registrationDate;
    }

    private Integer latitude;
    private Integer longitude;
    private String type;
    private Integer ZipCode;
    private LocalDate registrationDate;

    public static boolean getGeoData(String CPR) throws SQLException {

        ObservableList<geoData> list = FXCollections.observableArrayList();


        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement("Select * FROM cdb.geolocation Where CPR =" + CPR);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    Integer latitude = rs.getInt("latitude");
                    Integer longitude = rs.getInt("longitude");
                    String type = rs.getString("type");
                    Integer ZipCode = rs.getInt("ZipCode");
                    LocalDate registrationDate = rs.getDate("registrationDate").toLocalDate();

                    list.add(new geoData(latitude, longitude, type, ZipCode, registrationDate ));

                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return true;
    }
}

