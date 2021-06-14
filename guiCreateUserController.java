package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class guiCreateUserController {
    public void createPatientButton(ActionEvent event) throws IOException {
    Parent createPatient = FXMLLoader.load(getClass().getResource("guiPatientRegistration.fxml"));
    Scene scene1 = new Scene(createPatient);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

    window.setScene(scene1);
    window.show();

}
    public void createHealthProfButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiHealthProfRegister.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
    public void createStakeHolderButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiStakeHolderRegister.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
    public void returnToStart(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiSystemStart.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
}
