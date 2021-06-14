package Gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.consent;

import java.io.IOException;
import java.sql.SQLException;

public class guiPatientConsentController {


    public TextField searchStatusCprField;
    public TextField setConsentField;
    public TextField setConsentCprField;
    @FXML
    private TableView<consent> statusConsentTableView;
    @FXML
    private TableColumn<consent, Integer> statusConsentColumn;


    ObservableList<consent> listM;
    public void patientDataButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientData.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }

    public void newsButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientNews.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }

    public void consentButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientConsent.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }

    public void logOffButton (ActionEvent event) throws  IOException{
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiSystemStart.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    public void searchConsentButton(ActionEvent event) throws IOException {

        if (!consent.statusConsent(searchStatusCprField.getText())) {
            System.out.println("ERROR");
        } else {


            statusConsentColumn.setCellValueFactory(new PropertyValueFactory<consent, Integer>( "status"));

                try {
                    listM=consent.getStatusConsent(searchStatusCprField.getText());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                statusConsentTableView.setItems(listM);
        }
    }

    public void updateConsentButton(ActionEvent event) throws IOException {
        boolean succes = consent.updateConsent(setConsentField.getText(), setConsentCprField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {

            Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientConsent.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
}
