package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class guiLoginController {
    public void loginHealthProfButton1(ActionEvent event) throws IOException, SQLException {
        Parent loginHealthProf = FXMLLoader.load(getClass().getResource("guiHealthProfLogin.fxml"));
        Scene scene1 = new Scene(loginHealthProf);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
    public void loginPatientButton1(ActionEvent event) throws IOException, SQLException {
        Parent loginPatient = FXMLLoader.load(getClass().getResource("guiPatientLogin.fxml"));
        Scene scene1 = new Scene(loginPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
    public void loginStakeHolderButton1(ActionEvent event) throws IOException, SQLException {
        Parent loginStakeHolder = FXMLLoader.load(getClass().getResource("guiStakeHolderLogin.fxml"));
        Scene scene1 = new Scene(loginStakeHolder);
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
