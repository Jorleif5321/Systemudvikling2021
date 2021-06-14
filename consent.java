package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class consent {
    private Integer status;
    public consent(Integer status) {
        this.status = status;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public static ObservableList<consent> getStatusConsent(String CPR) throws SQLException {

        ObservableList<consent> list = FXCollections.observableArrayList();


        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){

            PreparedStatement ps = conn.prepareStatement("Select * FROM cdb.consent Where CPR =" + CPR);
            ResultSet rs = ps.executeQuery();{

                while (rs.next()) {

                    Integer status = rs.getInt("status");



                    list.add(new consent(status));

                }
            }

        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
    }
    public static boolean setConsent(Integer Status, Integer CPR) {
        String insert = "INSERT INTO cdb.consent ( status, CPR)" + " values ( ?, ? )";


        try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())){


            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setInt(1, Status);
            preparedStmt.setInt(2, CPR);
            preparedStmt.execute();
            System.out.println("Consent given");
        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        return true;
    }
    public static boolean statusConsent(String CPR) {
        String select = "Select * FROM cdb.consent Where CPR =" + CPR;
        try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd());
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select)) {

            while (rs.next()) {
                Integer status = rs.getInt(2);
                System.out.println("Youre Consent status (1= true 0=false): " + status);
            }
        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
    public static boolean updateConsent(String Status, String CPR) {
        String update = "UPDATE cdb.consent SET status = ? WHERE CPR =?";
        try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

            PreparedStatement preparedStmt = con.prepareStatement(update);
            preparedStmt.setString(1, Status);
            preparedStmt.setString(2, CPR);
            preparedStmt.execute();
            System.out.println("Status updatet");


        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return false;
    }
}
