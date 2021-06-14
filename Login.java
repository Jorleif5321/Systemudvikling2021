package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {


    int CPR;
    private static String HealthProfName;
    private static String patientName;
    private static String StakeHolderName;




    public boolean patientLogin(String patientName, String cprLength) throws SQLException {
       boolean validPatient = true;

        if (!Validator.isRegisterPatient(patientName)) {
            System.out.println("Wrong name enter again");
            validPatient = false;

        }

        CPR = Integer.parseInt(cprLength);
        if (!Validator.isRegisterPatientCPR(CPR)) {
            System.out.println("Wrong CPR enter again");
            validPatient = false;

        }
            return validPatient;
    }

    public boolean healthProfLogin(String healthProfName) throws SQLException {
        boolean validHealthProf = true;

        if (!Validator.isRegisterHealthProf(healthProfName)) {
            System.out.println("Wrong name enter again");
            validHealthProf = false;
        }

        System.out.println("Succes");
        return validHealthProf;
    }

    public boolean stakeHolderLogin(String StakeHolderName, String cprLength) throws SQLException {
        boolean validStakeHolder = true;

        if (!Validator.isRegisterStakeHolder(StakeHolderName)) {
            System.out.println("Wrong name enter again");
            validStakeHolder = false;
        }

        CPR = Integer.parseInt(cprLength);
        if (!Validator.isRegisterStakeHolderCPR(CPR)) {
            System.out.println("Wrong CPR enter again");
            validStakeHolder = false;
        }
        System.out.println("Succes");
        return validStakeHolder;
    }

}


