package cancelbooking;

import com.jfoenix.controls.JFXButton;
import hotel.Room;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class CancelBookingController implements Initializable {

    @FXML
    private Label back;
    @FXML
    private JFXButton Logobtn;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;

    @FXML
    private TextField roomNoField;
    @FXML
    private JFXButton clearbtn;
    @FXML
    private JFXButton CacnelBookingBTN;
    @FXML
    private JFXButton roomBTN;
    @FXML
    private JFXButton guestsBTN;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLabel.setText(login.LoginController.user.getUsername());
    }

    @FXML
    private void logout(Event event) {
        new homepage.HomePageController().logout(event);
    }

    @FXML
    public void goToHomePage(Event event) {
        new CheckPerson.CheckpersonController().goToHomePage(event);
    }

    @FXML
    void goTO_check_Person(ActionEvent event) {
        new homepage.HomePageController().goTO_check_Person(event);

    }

    @FXML
    private void goTo_room_booking(Event event) {
        new homepage.HomePageController().goTo_room_booking(event);
    }

    @FXML
    private void goTo_cancel_booking(Event event) {
        new homepage.HomePageController().goTo_cancel_booking(event);
    }

    @FXML
    private void goTO_check_out(Event event) {
        new homepage.HomePageController().goTo_Check_out(event);
    }

    @FXML
    private void CancelBookingAction(ActionEvent event) {
        if ("".equals(roomNoField.getText())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setContentText("you must Fill all fields to go to Confirmation window !");
            alert.setHeaderText("Fill all fields !");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/Error01.png"));
            alert.showAndWait();
        } else {

            int flag;
            try {
                flag = Room.CheckOut(Integer.parseInt(roomNoField.getText()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setHeaderText("Error , room no not valid !");
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.show();
                return;
            }
            switch (flag) {
                case 1: {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setHeaderText("Cancel Booking is Done ");
                    alert.setTitle("info");
                    alert.show();
                    new homepage.HomePageController().goTo_cancel_booking(event);
                    break;
                }
                case 0: {
                    Alert alert = new Alert(Alert.AlertType.WARNING, null, ButtonType.OK);
                    alert.setHeaderText("Room was already Empty !");
                    alert.setTitle("info");
                    alert.show();
                    break;
                }
                default: {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setHeaderText("Room number not valid ...");
                    alert.setContentText("Error , room: " + roomNoField.getText() + " no not valid !");
                    alert.setTitle("Error");
                    alert.show();
                    break;
                }
            }
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {

        roomNoField.setText("");
    }

    @FXML
    private void goto_Rooms(ActionEvent event) {
        new homepage.HomePageController().goTo_Rooms(event);
    }

    @FXML
    private void goTo_guests(ActionEvent event) {
        new homepage.HomePageController().goTo_Guests(event);
    }
}
