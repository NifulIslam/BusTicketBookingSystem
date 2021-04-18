package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpPage {
    @FXML
    private TextField SignInName;

    @FXML
    private Label SignUpLabelNotifi;
    @FXML
    private PasswordField signInPass;
    public void btnSignUpAction(ActionEvent actionEvent) {
        if (NewUserHandle.isValidName(SignInName.getText())) {
            NewUserHandle.createNewUser(SignInName.getText(), signInPass.getText());
            Stage stage = Main.stage;
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("UserPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        }
        else{
            SignUpLabelNotifi.setText("username already taken");
        }
    }

}
