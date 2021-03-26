package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class HomePage {

    @FXML
    private Button btnAdmin;

    @FXML
    private Button btnSignUp;

    @FXML
    private Button btnUser;

    @FXML
    void btnAdminAction(ActionEvent event) throws IOException {
    }

    @FXML
    void btnSignUpAction(ActionEvent event) {

    }

    @FXML
    void btnUserAction(ActionEvent event) {

    }

    public void btnAdminAction(javafx.event.ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    public void btnSignUpAction(javafx.event.ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }

    public void btnUserAction(javafx.event.ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();
    }
}