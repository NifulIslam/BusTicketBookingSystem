package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserPage implements Initializable {
    Msg msg;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUserPageLabelName();
        Msg msg=  new Msg(msgArea);
        new Tickets(ticketsTAusers);
    }
    @FXML
    private TextField ticketNameTf;
    @FXML
    private Button buyBtn;
    @FXML
    private TextArea ticketsTAusers;
    @FXML
    private Label magLabelUser;
    @FXML
    private TextArea msgArea;
    @FXML
    private Text UserPageLabelName;
    private void setUserPageLabelName(){ UserPageLabelName.setText(HomePage.user.name); }


    public void buyBtnAction(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if(Client.buy(ticketNameTf.getText())){
            TicketManager.addTicket(HomePage.user.name,ticketNameTf.getText() );
            magLabelUser.setText("booked");

        }
        else{
            magLabelUser.setText("invalid ticket name or already sold");
        }
        ticketNameTf.setText("");
    }
    public void btnLogOutAction(ActionEvent actionEvent) {
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }

    public void btnExpandAction(ActionEvent actionEvent) {
      //  msg.stop();
        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MessagePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }

    public void btnUserProfileAction(ActionEvent actionEvent) {

        Stage stage =Main.stage;
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("UserProfilePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new javafx.scene.Scene(root));
        stage.show();

    }


}
