package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class testData {


    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public Integer getIdHP() {
        return idHP;
    }

    public void setIdHP(Integer idHP) {
        this.idHP = idHP;
    }


    public testData(Boolean result, String type, LocalDate testDate, Integer idHP) {
        this.result = result;
        this.type = type;
        this.testDate = testDate;
        this.idHP = idHP;
    }
    private Boolean result;
    private String type;
    private LocalDate testDate;
    private Integer idHP;

    public static boolean getTestData(String CPR) throws SQLException {

        ObservableList<testData> list = FXCollections.observableArrayList();


        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement("Select * FROM cdb.test Where CPR =" + CPR);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    Boolean result = rs.getBoolean("result");
                    String type = rs.getString("type");
                    LocalDate testDate = rs.getDate("testDate").toLocalDate();
                    Integer idHP = rs.getInt("idHP");

                    list.add(new testData(result, type, testDate, idHP));

                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return true;
    }
}
