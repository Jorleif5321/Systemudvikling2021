package Gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Mutation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class guiHealthProfMutationController implements Initializable {

    public Button AddMutation;
    public TextField registerDate;
    public TextField ZipCode;
    public Button updateMutation;
    public TextField MutationType2;
    public TextField UpdateMutationType1;
    public TextField AddMutationType1;


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

    public void addMutationButton (ActionEvent event) throws IOException {

        boolean succes = !Mutation.addMutation(AddMutationType1.getText(), registerDate.getText(), ZipCode.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfMutation.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }

    public void updateMutationButton (ActionEvent event) throws IOException, SQLException {

        boolean succes = !Mutation.updateMutation(UpdateMutationType1.getText(), MutationType2.getText());
        if (!succes) {
            System.out.println("ERROR");
        }
        else {
            Parent createMutation = FXMLLoader.load(getClass().getResource("guiHealthProfMutation.fxml"));
            Scene scene1 = new Scene(createMutation);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
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
