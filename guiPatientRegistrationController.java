package Gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.CreateUser;

import java.io.IOException;

public class guiPatientRegistrationController {
    public TextField zipCodeField;
    public TextField cprField;
    public TextField tNumberField;
    public TextField streetNameField;
    public TextField streetNumberField;
    public TextField birthdateField;
    public TextField nameField;
    public Button createPatient;

    public void registerPatientButton(ActionEvent event) throws IOException {
        CreateUser user = new CreateUser();
        boolean succes = user.createPatient(cprField.getText(), nameField.getText(), birthdateField.getText(), tNumberField.getText(), streetNameField.getText(), streetNumberField.getText(), zipCodeField.getText());
        if (!succes) {
            System.out.println("ERROR");
        } else {
            Parent createPatient = FXMLLoader.load(getClass().getResource("guiSystemStart.fxml"));
            Scene scene1 = new Scene(createPatient);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(scene1);
            window.show();

        }
    }
    public void cancelButton (ActionEvent event) throws  IOException{
        Parent createPatient = FXMLLoader.load(getClass().getResource("guiCreateUser.fxml"));
        Scene scene1 = new Scene(createPatient);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

}
