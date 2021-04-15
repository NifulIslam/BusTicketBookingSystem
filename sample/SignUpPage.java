package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPage {
    public void btnSignUpAction(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }
}
