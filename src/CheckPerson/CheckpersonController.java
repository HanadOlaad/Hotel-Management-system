package CheckPerson;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import hotel.Guest;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.stage.Stage;
import javafx.util.Callback;
import project.DataBase;
import project.Paths;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import static login.LoginController.decorator;
import static login.LoginController.window;

public class CheckpersonController extends Component implements Initializable {
    Connection con;
    PreparedStatement pst;


    @FXML
    private JFXButton roomBTN;

    @FXML
    private JFXButton guestsBTN;

    @FXML
    private Label backLabel;

    @FXML
    private JFXButton Logobtn;

    @FXML
    private Label usernameLabel;

    @FXML
    private Hyperlink logoutLink;

    @FXML
    private JFXButton BtnSerach;

    @FXML
    private TextField txtSearchName;

    @FXML
    private TableView<Guest> tabel2;
    @FXML
    private TableColumn<Guest, String> CRoomid;

    @FXML
    private TableColumn<Guest, String> Cname;

    @FXML
    private TableColumn<Guest, String> Cphone;

    @FXML
    private TableColumn<Guest, String> Ccity;

    @FXML
    private TableColumn<Guest, String> Cnationality;

    @FXML
    private TableColumn<Guest, String> Cpassport;
    private ObservableList<Guest> custList;

    public boolean isFieldsEmpty() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if ("".equals(txtSearchName.getText()) ){
            Alert alert = new Alert(Alert.AlertType.ERROR,"",ButtonType.OK);

            alert.setHeaderText("This Field IS Empty!");
            alert.setTitle("Error");
//            System.out.println("Inside if in isFieldsEmpty() ");

            return true;
        } else {

            System.out.println("Inside else in isFieldsEmpty() ");
            return false;
        }
    }



   


    @FXML
    void goTO_check_Person(Event event) {
        new homepage.HomePageController().goTO_check_Person(event);

    }

    @FXML
    void goTO_check_out(Event event) {
        new homepage.HomePageController().goTo_Check_out(event);

    }

    @FXML
    public void goToHomePage(Event event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Paths.HOMEPAGEVIEW));

            decorator.setContent(root);
            decorator.setCustomMaximize(true);
            decorator.setBorder(Border.EMPTY);

            decorator.setTitle("Hotel Reservation System");

            Image icon = new Image(getClass().getResourceAsStream("/img/icon.jpg"));
            window.getIcons().add(icon);
            window.setTitle("Hotel System");
            root.requestFocus();
        } catch (IOException ex) {
            System.out.println("Error load loginFXML !");
        } catch (Exception ex) {
            System.out.println("Error !!");
            ex.printStackTrace();
        }


    }

    @FXML
    void goTo_cancel_booking(Event event) {
        new homepage.HomePageController().goTo_cancel_booking(event);

    }

    @FXML
    void goTo_guests(Event event) {
        new homepage.HomePageController().goTo_Guests(event);
    }

    @FXML
    void goTo_room_booking(Event event) {
        new homepage.HomePageController().goTo_room_booking(event);

    }

    @FXML
    void goto_Rooms(Event event) {
        new homepage.HomePageController().goTo_Rooms(event);
    }

    @FXML
    void logout(Event event) {
        new homepage.HomePageController().logout(event);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        final ObservableList<Guest> custList= (ObservableList<Guest>) DataBase.getGuests();

        List<Guest> guests = DataBase.getGuests();

        for (int i = 0; i < guests.size(); i++) {
            System.out.println("aa" + guests.get(i));
        }
        CRoomid.setCellValueFactory(new PropertyValueFactory("roomID"));
        Cname.setCellValueFactory(new PropertyValueFactory("Name"));
        Ccity.setCellValueFactory(new PropertyValueFactory("city"));
        Cnationality.setCellValueFactory(new PropertyValueFactory("Nationality"));
        Cpassport.setCellValueFactory(new PropertyValueFactory("passportNumber"));
        Cphone.setCellValueFactory(new PropertyValueFactory("phoneNo"));
        try {

            tabel2.getItems().addAll(guests);
//            tabel2.setItems(custList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        usernameLabel.setText(login.LoginController.user.getUsername());


    }
    @FXML

    void btnSearch(Event event) throws SQLException {
    }
    }



