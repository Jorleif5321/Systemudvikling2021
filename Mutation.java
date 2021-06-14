package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Mutation {
    private static int ZIPcode;
    private String type;
    private LocalDate registerDate;
    private Integer ZipCode;


    public String getType() {

        return type;
    }

    public LocalDate getRegisterDate() {

        return registerDate;
    }

    public Integer getZipCode() {

        return ZipCode;
    }

    public void setType(String type) {

        this.type = type;
    }

    public void setRegisterDate(LocalDate registerDate) {

        this.registerDate = registerDate;
    }

    public void setZipCode(Integer zipCode) {

        ZipCode = zipCode;
    }

    public Mutation(String type, LocalDate registerDate, Integer zipCode) {

        this.type = type;
        this.registerDate = registerDate;
        ZipCode = zipCode;
    }

    public static ObservableList<Mutation> getDataMutation() throws SQLException {
        ObservableList<Mutation> list = FXCollections.observableArrayList();
        try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cdb.mutation");
            ResultSet rs = ps.executeQuery();
            {

                while (rs.next()) {

                    String type = rs.getString("type");
                    LocalDate registerDate = rs.getDate("registerDate").toLocalDate();
                    Integer ZipCode = rs.getInt("zipCode");


                    list.add(new Mutation(type, registerDate, ZipCode));

                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(list);
        return list;
    }


    public static boolean addMutation(String type, String registerDate, String ZIPcode1) {
        Boolean validAddMutation = true;
        Boolean sqlSucceed = true;


        if (!Validator.isValidBirthDay(registerDate)) {
            System.out.println("Wrong register date enter again");
            validAddMutation = false;
        }
        ZIPcode = Integer.parseInt(ZIPcode1);
        if (!Validator.isValidZIPcode(ZIPcode1)) {
            System.out.println("Wrong ZIPcode enter again");
            validAddMutation = false;
        }

        if (validAddMutation) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.parse(registerDate, formatter);
            Date registerDate2 = Date.valueOf(localDate);
            String insert = "INSERT INTO cdb.mutation ( type, registerDate, ZIPcode)" + " values ( ?, ?, ? )";
            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {
                PreparedStatement preparedStmt = con.prepareStatement(insert);
                preparedStmt.setString(1, type);
                preparedStmt.setDate(2, registerDate2);
                preparedStmt.setInt(3, ZIPcode);
                preparedStmt.execute();
                System.out.println("Mutation added");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                sqlSucceed = false;
            }
        }
        return validAddMutation && sqlSucceed;
    }

    public static boolean updateMutation(String type1, String type2) throws SQLException {
        String update = "UPDATE cdb.mutation SET type = ? WHERE type =?";
        try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {
            PreparedStatement preparedStmt = con.prepareStatement(update);
            preparedStmt.setString(1, type2);
            preparedStmt.setString(2, type1);
            preparedStmt.execute();
            System.out.println("Mutation updatet");

            String update2 = "UPDATE cdb.test SET type = ? WHERE type =?";
            try (Connection conn = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {
                PreparedStatement preparedStmt2 = con.prepareStatement(update2);
                preparedStmt2.setString(1, type2);
                preparedStmt2.setString(2, type1);
                preparedStmt2.execute();
                System.out.println("Mutation in test updatet");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            return true;
        }

    }
}


