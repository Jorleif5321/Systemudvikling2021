package Gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class guiHealthProfPatientDataController {
    public Button createPatient;


    public TextField cprFieldAddPatientField;
    public TextField nameAddPatientField;
    public TextField birthdateAddPatientField;
    public TextField tNumberAddPatientField;
    public TextField streetNameAddPatientField;
    public TextField streetNumberAddPatientField;
    public TextField zipCodeAddPatientField;

    public TextField resultTestDataField;
    public TextField testDateTestDataField;
    public TextField patientCPRTestDataField;
    public TextField mutationTypeTestDataField;
    public TextField idHealthProfTestDataField;

    public TextField zipCodeGeoField;
    public TextField mutationTypeGeoField;
    public TextField cprGeoField;
    public TextField registerDateGeoField;
    public TextField longitudeGeoField;
    public TextField latitudeGeoField;

    public TextField cprSensorField;
    public TextField pullsSensorField;
    public TextField bodyTemperatureSensorField;

    public TextField searchPatientTextField;



    @FXML
    private TableView<PatientData> personalInfo;
    @FXML
    private TableColumn<PatientData, Integer> cprsearchPateintColumn;
    @FXML
    private TableColumn<PatientData, String> nameSearchPatientField;
    @FXML
    private TableColumn<PatientData, LocalDate> birthdateSearchPatientField;
    @FXML
    private TableColumn<PatientData, Integer> tNumberColumn;
    @FXML
    private TableColumn<PatientData, Integer> streetNameColumn;
    @FXML
    private TableColumn<PatientData, Integer> StreetNumberColumn;
    @FXML
    private TableColumn<PatientData, Integer> ZipCodeColumn;

    boolean listM;

    public void registerPatientButton(ActionEvent event) throws IOException {
        CreateUser user = new CreateUser();
        boolean succes = user.createPatient(cprFieldAddPatientField.getText(), nameAddPatientField.getText(), birthdateAddPatientField.getText(), tNumberAddPatientField.getText(), streetNameAddPatientField.getText(), streetNumberAddPatientField.getText(), zipCodeAddPatientField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
    public void registerTestDataButton(ActionEvent event) throws IOException {
        boolean succes = Patient.setTestData(resultTestDataField.getText(), testDateTestDataField.getText(), patientCPRTestDataField.getText(), mutationTypeTestDataField.getText(), idHealthProfTestDataField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
    public void registerGeolocationButton(ActionEvent event) throws IOException {

        boolean succes = Patient.setGeoLocationData(latitudeGeoField.getText(), longitudeGeoField.getText(), mutationTypeGeoField.getText(),registerDateGeoField.getText(), zipCodeGeoField.getText(), cprGeoField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
    public void registerSensorDataButton(ActionEvent event) throws IOException {

        boolean succes = Patient.setSensorData(bodyTemperatureSensorField.getText(), pullsSensorField.getText(), cprSensorField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }

    public void patientDataButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }

    public void mutationButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfMutation.fxml"));
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
    public void cancelButton (ActionEvent event) throws  IOException{
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfPatientData.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
//
//    public void searchDataButton(ActionEvent event) throws SQLException {
//
//
//
//                if (!PatientData.getTestData(searchPatientTextField.getText()) ){
//                    System.out.println("ERROR");
//            } else {
//
//                    cprsearchPateintColumn.setCellValueFactory(new PropertyValueFactory<PatientData, Integer>( "CPR"));
//                    nameSearchPatientField.setCellValueFactory(new PropertyValueFactory<PatientData, String>( "name"));
//                    birthdateSearchPatientField.setCellValueFactory(new PropertyValueFactory<PatientData, LocalDate>( "status"));
//                    tNumberColumn.setCellValueFactory(new PropertyValueFactory<PatientData, Integer>( "status"));
//                    streetNameColumn.setCellValueFactory(new PropertyValueFactory<PatientData, Integer>( "status"));
//                    StreetNumberColumn.setCellValueFactory(new PropertyValueFactory<PatientData, Integer>( "status"));
//                    ZipCodeColumn.setCellValueFactory(new PropertyValueFactory<PatientData, Integer>( "status"));
//
//
//                try {
//                    listM=PatientData.getTestData(searchPatientTextField.getText());
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }personalInfo.setItems(listM);
//
//            }
//        }
                }


