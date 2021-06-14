
package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Mutation;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class guiPatientNewsController implements Initializable {
    public void patientDataButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientData.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
    public void newsButton (ActionEvent event) throws IOException {
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


    @FXML
    private TableView<Mutation> mutationTableView;
    @FXML
    private TableColumn<Mutation, String> mutationTypeColumn;
    @FXML
    private TableColumn<Mutation, LocalDate> registerDateColumn;
    @FXML
    private TableColumn<Mutation, Integer> ZipCodeColumn;

    ObservableList<Mutation> listM;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mutationTypeColumn.setCellValueFactory(new PropertyValueFactory<Mutation, String>( "Type"));
        registerDateColumn.setCellValueFactory(new PropertyValueFactory<Mutation, LocalDate>("registerDate"));
        ZipCodeColumn.setCellValueFactory(new PropertyValueFactory<Mutation, Integer>("ZipCode"));
        try {
            listM=Mutation.getDataMutation();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        mutationTableView.setItems(listM);
    }
}
