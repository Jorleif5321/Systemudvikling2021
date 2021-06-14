package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateUser {
    Integer CPR = null;
    Integer tNumber = null;
    Integer streetNumber = null;
    Integer ZIPcode = null;
    Date birthdate = null;



    public boolean createPatient(String cprLength, String name, String birthDate, String numberLength, String streetName, String streetNumber1, String ZIPcode1) {
        Boolean validPatient = true;
        Boolean sqlSucceed = true;

        CPR = Integer.parseInt(cprLength);
        if (!Validator.isValidCPR(cprLength)) {
            System.out.println("Wrong CPR enter again");
            validPatient = false;
        }

        if (!Validator.isValidUsername(name)) {
            System.out.println("Wrong name enter again");
            validPatient = false;
        }

        if (!Validator.isValidBirthDay(birthDate)) {
            System.out.println("Wrong Birthday enter again");
            validPatient = false;
        }

        tNumber = Integer.parseInt(numberLength);
        if (!Validator.isValidNumber(numberLength)) {
            System.out.println("Wrong Number enter again");
            validPatient = false;
        }

        if (!Validator.isValidStreetName(streetName)) {
            System.out.println("Wrong streetName enter again");
            validPatient = false;
        }

        streetNumber = Integer.parseInt(streetNumber1);
        if (!Validator.isValidStreetNumber(streetNumber1)) {
            System.out.println("Wrong streetNumber enter again");
            validPatient = false;
        }

        ZIPcode = Integer.parseInt(ZIPcode1);
        if (!Validator.isValidZIPcode(ZIPcode1)) {
            System.out.println("Wrong ZIPcode enter again");
            validPatient = false;
        }

        if (validPatient) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate localDate = LocalDate.parse(birthDate, formatter);
            birthdate = Date.valueOf(localDate);
            String insert = "INSERT INTO cdb.patient ( CPR, name, birthDate, tNumber, streetName, streetNumber, ZIPcode )" + " values (  ?, ?, ?, ?, ?, ?, ? )";

            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

                PreparedStatement preparedStmt = con.prepareStatement(insert);

                preparedStmt.setInt(1, CPR);
                preparedStmt.setString(2, name);
                preparedStmt.setDate(3, birthdate);
                preparedStmt.setInt(4, tNumber);
                preparedStmt.setString(5, streetName);
                preparedStmt.setInt(6, streetNumber);
                preparedStmt.setInt(7, ZIPcode);

                preparedStmt.execute();


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                sqlSucceed = false;
            }

            if (!consent.setConsent(1, CPR)) {
                sqlSucceed = false;
            }
        }
        return validPatient && sqlSucceed;
    }

    public boolean createHealthProf(String name, String numberLength, String streetName, String streetNumber1) {
        Boolean validHealthPRof = true;
        Boolean sqlSucceed = true;

        if (!Validator.isValidUsername(name)) {
            System.out.println("Wrong name enter again");
            validHealthPRof = false;
        }

        tNumber = Integer.parseInt(numberLength);
        if (!Validator.isValidNumber(numberLength)) {
            System.out.println("Wrong Number enter again");
            validHealthPRof = false;
        }
        if (!Validator.isValidStreetName(streetName)) {
            System.out.println("Wrong streetName enter again");
            validHealthPRof = false;
        }

        streetNumber = Integer.parseInt(streetNumber1);
        if (!Validator.isValidStreetNumber(streetNumber1)) {
            System.out.println("Wrong streetNumber enter again");
            validHealthPRof = false;
        }


        if (validHealthPRof) {
            String insert = "INSERT INTO cdb.healthprof (Name, tnumber, streetName, streetNumber )" + " values ( ?, ?, ? , ? )";
            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

                PreparedStatement preparedStmt = con.prepareStatement(insert);

                preparedStmt.setString(1, name);
                preparedStmt.setInt(2, tNumber);
                preparedStmt.setString(3, streetName);
                preparedStmt.setInt(4, streetNumber);


                preparedStmt.execute();
                return true;


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                sqlSucceed = false;
            }

        }

        return validHealthPRof && sqlSucceed;
    }

    public boolean createStakeHolder(String name, String cprLength, String numberLength) {
        Boolean validStakeHolder = true;
        Boolean sqlSucceed = true;

        if (!Validator.isValidUsername(name)) {
            System.out.println("Wrong name enter again");
            validStakeHolder = false;
        }

        CPR = Integer.parseInt(cprLength);
        if (!Validator.isValidCPR(cprLength)) {
            System.out.println("Wrong CPR enter again");
            validStakeHolder = false;
        }

        tNumber = Integer.parseInt(numberLength);
        if (!Validator.isValidNumber(numberLength)) {
            System.out.println("Wrong Number enter again");
            validStakeHolder = false;
        }

        if (validStakeHolder) {
            String insert = "INSERT INTO cdb.stakeholder ( name, CPR, tNumber )" + " values (  ?, ?, ? )";
            try (Connection con = DriverManager.getConnection(Database.getUrl(), null, Database.getPwd())) {

                PreparedStatement preparedStmt = con.prepareStatement(insert);
                preparedStmt.setString(1, name);
                preparedStmt.setInt(2, CPR);
                preparedStmt.setInt(3, tNumber);


                preparedStmt.execute();


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                sqlSucceed = false;
            }

        }
        return validStakeHolder && sqlSucceed;
    }
}