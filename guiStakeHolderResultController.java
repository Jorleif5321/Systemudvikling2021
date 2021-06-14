package Gui;

import jakarta.xml.bind.JAXBException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Patient;
import sample.Result;

import java.io.IOException;
import java.util.List;

import static sample.Result.getInfectiousPatients;

public class guiStakeHolderResultController {
    public TextField resultField;
    public TextField zipCodeField;
    public TextField fromDateField;
    public TextField toDateField;


    public void xmlReportButton (ActionEvent event) throws IOException, JAXBException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiStakeHolderResult.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    public void logOffButton (ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiSystemStart.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    public void generateResultSetButton (ActionEvent event) throws IOException, JAXBException {
        List<Patient> infectiousPatients = getInfectiousPatients(resultField.getText(), fromDateField.getText(), toDateField.getText(), zipCodeField.getText());
        boolean succes = Result.generateXMLReport(infectiousPatients);
        if (succes) {
            System.out.println("ERROR");
        } else {
            Result.generateXMLReport(infectiousPatients);
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiStakeHolderResult.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
}
