package sample;

import jakarta.xml.bind.JAXBException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        consent.statusConsent("1007962011");


        Parent root = FXMLLoader.load(getClass().getResource("../Gui/guiSystemStart.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("CoronaAppen");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}