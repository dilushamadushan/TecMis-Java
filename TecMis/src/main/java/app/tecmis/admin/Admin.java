package app.tecmis.admin;

import app.tecmis.connection.Config;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.ResourceBundle;

public class Admin implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showLecture();
    }

    @FXML
    private AnchorPane adminPanel;

    @FXML
    private Button courseBtn;

    @FXML
    private AnchorPane dashbord;

    @FXML
    private Button dashbordBtn;

    @FXML
    private AnchorPane lecture;

    @FXML
    private Button lectureBtn;

    @FXML
    private Button noticeBtn;

    @FXML
    private Button studentBtn;

    @FXML
    private Button techofficerBtn;

    @FXML
    private Button timeTableBtn;

    @FXML
    void logout(ActionEvent event) {
        Platform.exit();
    }

    // lecture

    @FXML
    private Label _errorMsgLec;

    @FXML
    private Label _resultMsgLec;

    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField searchBar;

    @FXML
    private TableView<LecDetails> lecTableView;

    @FXML
    private TableColumn<LecDetails, String> _userAddress;

    @FXML
    private TableColumn<LecDetails, Date> _userBOD;

    @FXML
    private TableColumn<LecDetails, String> _userContactNo;

    @FXML
    private TableColumn<LecDetails, String> _userEmail;

    @FXML
    private TableColumn<LecDetails, String> _userGender;

    @FXML
    private TableColumn<LecDetails, String> _userID;

    @FXML
    private TableColumn<LecDetails, String> _userNIC;

    @FXML
    private TableColumn<LecDetails, String> _userName;

    @FXML
    private TableColumn<LecDetails, String> _lecPosition;

    @FXML
    void navBar_link(ActionEvent event) {
        if(event.getSource()==dashbordBtn){
            dashbord.setVisible(true);
            lecture.setVisible(false);
        }else if(event.getSource()==lectureBtn){
            dashbord.setVisible(false);
            lecture.setVisible(true);
        }
    }

    @FXML
    void searchBarBtn(MouseEvent event) {

    }

    public ObservableList<LecDetails> getLecture(){
        ObservableList<LecDetails> lecList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String sql = "SELECT * FROM lecture l JOIN user u ON l.lecture_id = u.userId LEFT JOIN user_contact uc ON u.userId = uc.userId;\n";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            LecDetails lecDetails;
            while(rs.next()){
                lecDetails = new LecDetails(rs.getString("userId"),rs.getString("nic"),rs.getString("f_name"),rs.getString("l_name"),rs.getString("address"),rs.getString("email"),rs.getString("gender"),rs.getDate("bod"),rs.getString("contact_no"),rs.getString("position"));
                lecList.add(lecDetails);
                //System.out.println("user id" + rs.getString("userId"));
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return lecList;
    }

    public void showLecture() {
        ObservableList<LecDetails> List = getLecture();
        _userID.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecId"));
        _userNIC.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecNic"));
        _userName.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecFullName"));
        _userAddress.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecAddress"));
        _userEmail.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecEmail"));
        _userGender.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecGender"));
        _userBOD.setCellValueFactory(new PropertyValueFactory<LecDetails, Date>("lecBod"));
        _userContactNo.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecContactNo"));
        _lecPosition.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecPosition"));


        lecTableView.setItems(List);
    }

}
