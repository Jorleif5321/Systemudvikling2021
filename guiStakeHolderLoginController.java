package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Login;

import java.io.IOException;
import java.sql.SQLException;

public class guiStakeHolderLoginController {
    public TextField cprField;
    public TextField nameField;
    public Button createPatient;


    public void loginStakeHolderButton2(ActionEvent event) throws IOException, SQLException {
        Login login = new Login();
        boolean succes = login.stakeHolderLogin(nameField.getText(), cprField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiStakeHolderResult.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
    public void cancelButtonLogin (ActionEvent event) throws  IOException{
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiLogin.fxml"));
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
}
