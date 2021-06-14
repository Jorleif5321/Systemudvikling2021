package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class guiSystemStartController {
    public void loginButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiLogin.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
    public void createUserButton(ActionEvent event) throws IOException {
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiCreateUser.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();

    }
}
