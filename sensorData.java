package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class sensorData {
    private Integer temperature;
    private Integer pulls;

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getPulls() {
        return pulls;
    }

    public void setPulls(Integer pulls) {
        this.pulls = pulls;
    }


    public sensorData(Integer temperature, Integer pulls) {
        this.temperature = temperature;
        this.pulls = pulls;

    }
    public static boolean getSensorData(String CPR) throws SQLException {

        ObservableList<sensorData> list = FXCollections.observableArrayList();


        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement("Select * FROM cdb.sensor Where CPR =" + CPR);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    Integer temperature = rs.getInt("temperature");
                    Integer pulls = rs.getInt("pulls");

                    list.add(new sensorData(temperature, pulls));

                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return true;
    }
}
