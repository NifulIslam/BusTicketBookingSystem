package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
       // new Tickets(ticketsTAusers);
    }
    @FXML
    private Label magLabelUser;
    @FXML
    private TextArea msgArea;
    @FXML
    private Text UserPageLabelName;
    private void setUserPageLabelName(){ UserPageLabelName.setText(HomePage.user.name); }



    private void buy(String ticket)  {
        try {
            if (Client.buy(ticket)) {
                TicketManager.addTicket(HomePage.user.name, ticket);
                magLabelUser.setText("booked");

            } else {
                magLabelUser.setText(" already sold");
            }

        }
        catch (Exception e){
            System.out.println(e);
            System.out.println("cannot buy");
        }
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

    public void a1btnAction(ActionEvent actionEvent){
        buy("a1");
    }
    public void a2btnAction(ActionEvent actionEvent) {
        buy("a2");
    }

    public void a3btnAction(ActionEvent actionEvent) {
        buy("a3");
    }

    public void a5btnAction(ActionEvent actionEvent) {
        buy("a5");
    }

    public void a4btnAction(ActionEvent actionEvent) {
        buy("a4");
    }

    public void a6btnAction(ActionEvent actionEvent) {
        buy("a6");
    }

    public void a7btnAction(ActionEvent actionEvent) {
        buy("a7");
    }

    public void a8btnAction(ActionEvent actionEvent) {
        buy("a8");
    }

    public void a9tnAction(ActionEvent actionEvent) {
        buy("a9");
    }

    public void b1btnAction(ActionEvent actionEvent) { buy("b1");
    }

    public void b9btnAction(ActionEvent actionEvent) { buy("b9");
    }

    public void b8btnAction(ActionEvent actionEvent) { buy("b8");
    }

    public void b7btnAction(ActionEvent actionEvent) { buy("b7");
    }

    public void b6btnAction(ActionEvent actionEvent) { buy("b6");
    }

    public void b5btnAction(ActionEvent actionEvent) { buy("b5");
    }

    public void b4btnAction(ActionEvent actionEvent) { buy("b4");
    }

    public void b3btnAction(ActionEvent actionEvent) { buy("b3");
    }

    public void b2btnAction(ActionEvent actionEvent) { buy("b2");
    }

    public void b17btnAction(ActionEvent actionEvent) { buy("b17");
    }

    public void a17btnAction(ActionEvent actionEvent) { buy("a17");
    }

    public void b18btnAction(ActionEvent actionEvent) {buy("b18");
    }

    public void a18btnAction(ActionEvent actionEvent) { buy("a18");
    }

    public void b16btnAction(ActionEvent actionEvent) { buy("b16");
    }

    public void a16btnAction(ActionEvent actionEvent) { buy("a16");
    }

    public void b10btnAction(ActionEvent actionEvent) { buy("b10");
    }

    public void a10btnAction(ActionEvent actionEvent) { buy("a10");
    }

    public void b11btnAction(ActionEvent actionEvent) { buy("b11");
    }

    public void a11btnAction(ActionEvent actionEvent) { buy("a11");
    }

    public void a12btnAction(ActionEvent actionEvent) { buy("a12");
    }

    public void b12btnAction(ActionEvent actionEvent) { buy("b12");
    }

    public void a13btnAction(ActionEvent actionEvent) { buy("a13");
    }

    public void b13btnAction(ActionEvent actionEvent) { buy("b13");
    }

    public void a14btnAction(ActionEvent actionEvent) { buy("a14");
    }

    public void b14btnAction(ActionEvent actionEvent) { buy("b14");
    }

    public void a15btnAction(ActionEvent actionEvent) { buy("a15");
    }

    public void b15btnAction(ActionEvent actionEvent) { buy("b15");
    }
}
