package app.tecmis.admin;

import app.tecmis.connection.Config;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Admin implements Initializable {

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
    private ComboBox _lecDepartment;

    @FXML
    private TextField _lecAddress;

    @FXML
    private DatePicker _lecBOD;

    @FXML
    private TextField _lecContactNo;

    @FXML
    private TextField _lecEmail;

    @FXML
    private RadioButton _lecGenderF;

    @FXML
    private RadioButton _lecGenderM;

    @FXML
    private TextField _lecId;

    @FXML
    private PasswordField _lecPassword;

    @FXML
    private TextField _lecNIC;

    @FXML
    private TextField _lecName;

    @FXML
    private TextField _lecPositionTF;


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
    private TableColumn<LecDetails, String> _userPassword;

    @FXML
    private TableColumn<LecDetails, String> _userDepartment;

    @FXML
    void lecSearchBar(MouseEvent event) {
        lecSearch();
    }

    @FXML
    void addNewLectureBtn(ActionEvent event) {
        addNewLecture();
    }
    @FXML
    void lecClearBtn(ActionEvent event) {
        cleanLecTextFiled();
    }
    @FXML
    void lecDeleteBtn(ActionEvent event) {
        lecDelete();
    }
    @FXML
    void lecUpdateBtn(ActionEvent event) {
        lecUpdate();
    }

    @FXML
    void handleRowsLecTable(MouseEvent event) {
        LecDetails lecDetails = lecTableView.getSelectionModel().getSelectedItem();
        _lecId.setText(String.valueOf(lecDetails.getLecId()));
        _lecNIC.setText(String.valueOf(lecDetails.getLecNic()));
        _lecName.setText(String.valueOf(lecDetails.getLecFullName()));
        _lecAddress.setText(String.valueOf(lecDetails.getLecAddress()));
        _lecEmail.setText(String.valueOf(lecDetails.getLecEmail()));
        _lecPositionTF.setText(String.valueOf(lecDetails.getLecPosition()));
        _lecPassword.setText(String.valueOf(lecDetails.getLecPassword()));
        _lecContactNo.setText(String.valueOf(lecDetails.getLecContactNo()));
        _lecDepartment.setValue(lecDetails.getLecDepName());

        String lecGender = String.valueOf(lecDetails.getLecGender());
        if("M".equalsIgnoreCase(lecGender)){
            _lecGenderM.setSelected(true);
        }else if("F".equalsIgnoreCase(lecGender)){
            _lecGenderF.setSelected(true);
        }

        String date = String.valueOf(lecDetails.getLecBod());
        LocalDate localDate = LocalDate.parse(date);
        _lecBOD.setValue(localDate);
    }

    @FXML
    void navBar_link(ActionEvent event) {
        if(event.getSource()==dashbordBtn){
            dashbord.setVisible(true);
            lecture.setVisible(false);
        }else if(event.getSource()==lectureBtn){
            dashbord.setVisible(false);
            lecture.setVisible(true);
            setDepName();
        }
    }

    public ObservableList<String> getDepartmentNameList() {
        ObservableList<String> listDepName = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String depSql = "SELECT * FROM department";
        Statement depSt = null;
        ResultSet depRs = null;
        try{
            depSt = con.createStatement();
            depRs = depSt.executeQuery(depSql);
            while(depRs.next()){
                String depName = depRs.getString("dep_name");
                listDepName.add(depName);
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return listDepName;
    }
    public void setDepName(){
        ObservableList<String> dep = getDepartmentNameList();
        _lecDepartment.setItems(dep);
    }
    public String setDepId(Object lecDepName) {
        Connection conn2 = Config.getConfig();
        String ld = "";
        if(lecDepName != null){
            lecDepName = lecDepName.toString();
        }
        String depSql = "SELECT * FROM department";
        Statement depSt = null;
        ResultSet depRs = null;
        try{
            depSt = conn2.createStatement();
            depRs = depSt.executeQuery(depSql);
            while(depRs.next()){
                String depName = depRs.getString("dep_name");
                if(depName.equals(lecDepName)){
                    ld = depRs.getString("dep_id");
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return ld;
    }

    public ObservableList<LecDetails> getLecture(){
        ObservableList<LecDetails> lecList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String sql = "SELECT * FROM lecture l JOIN user u ON l.lecture_id = u.userId LEFT JOIN user_contact uc ON u.userId = uc.userId INNER JOIN department d ON d.dep_id = l.dep_id";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            LecDetails lecDetails;
            while(rs.next()){
                lecDetails = new LecDetails(rs.getString("userId"),rs.getString("nic"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("contact_no"),
                        rs.getString("position"),
                        rs.getString("dep_name"),
                        rs.getString("password")
                );
                lecList.add(lecDetails);
                //System.out.println("user id" + rs.getString("userId"));
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return lecList;
    }

    public void showLectureToTable() {
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
        _userDepartment.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecDepName"));
        _userPassword.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecPassword"));

        lecTableView.setItems(List);
    }
    @FXML
    private void addNewLecture(){
        Connection conn = Config.getConfig();
        String lecId = _lecId.getText();
        String lecNIC = _lecNIC.getText();
        String lecFullName = _lecName.getText();
        String lecAddress = _lecAddress.getText();
        String lecEmail = _lecEmail.getText();
        String lecGender = _lecGenderM.isSelected() ? "M" : "F";
        LocalDate lecBod = _lecBOD.getValue();
        String lecContactNo = _lecContactNo.getText();
        String lecPosition  = _lecPositionTF.getText();
        String lecPassword = _lecPassword.getText();
        Object lecDepName = _lecDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(lecDepName);

        if (lecId.isEmpty()
                || lecNIC.isEmpty()
                || lecFullName.isEmpty()
                || lecAddress.isEmpty()
                || lecEmail.isEmpty()
                || lecGender.isEmpty()
                || lecBod == null
                || lecContactNo.isEmpty()
                || lecPosition.isEmpty()
                || lecPassword.isEmpty()
                || lecDepName == null) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }

        String[] nameParts = lecFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

       String lecUserSql = "INSERT INTO user (userId,nic,password,user_type,f_name,l_name,address,email,gender,bod) VALUES (?,?,?,?,?,?,?,?,?,?)";
       String lectureSql = "INSERT INTO lecture (lecture_id, position,dep_id) VALUES (?, ?, ?)";
       String contactSql = "INSERT INTO user_contact (userId, contact_no) VALUES (?, ?)";

       try{
           PreparedStatement userPs = conn.prepareStatement(lecUserSql);
           userPs.setString(1, lecId);
           userPs.setString(2, lecNIC);
           userPs.setString(3, lecPassword);
           userPs.setString(4, "lecture");
           userPs.setString(5, first_name);
           userPs.setString(6, last_name);
           userPs.setString(7, lecAddress);
           userPs.setString(8, lecEmail);
           userPs.setString(9, lecGender);
           userPs.setString(10, lecBod.toString());
           userPs.executeUpdate();

           PreparedStatement lectureStmt = conn.prepareStatement(lectureSql);
           lectureStmt.setString(1, lecId);
           lectureStmt.setString(2, lecPosition);
           lectureStmt.setString(3, ld);
           lectureStmt.executeUpdate();

           PreparedStatement contactStmt = conn.prepareStatement(contactSql);
           contactStmt.setString(1, lecId);
           contactStmt.setString(2, lecContactNo);
           contactStmt.executeUpdate();

           Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
           successAlert.setTitle("Lecture Added");
           successAlert.setHeaderText(null);
           successAlert.setContentText("Lecture '" + lecId + "'added successfully!");
           successAlert.showAndWait();

       } catch (Exception e){
           System.out.println("Error " + e.getMessage());
       }
       showLectureToTable();
       cleanLecTextFiled();
    }
    public void lecUpdate(){
        Connection conn = Config.getConfig();
        String lecId = _lecId.getText();
        String lecNIC = _lecNIC.getText();
        String lecFullName = _lecName.getText();
        String lecAddress = _lecAddress.getText();
        String lecEmail = _lecEmail.getText();
        String lecGender = _lecGenderM.isSelected() ? "M" : "F";
        LocalDate lecBod = _lecBOD.getValue();
        String lecContactNo = _lecContactNo.getText();
        String lecPosition  = _lecPositionTF.getText();
        String lecPassword = _lecPassword.getText();
        Object lecDepName = _lecDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(lecDepName);

        String[] nameParts = lecFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

        String ucUpdateSql = "UPDATE user_contact SET contact_no=? WHERE userId=?";
        String lecUpdateSql = "UPDATE lecture SET position=?, dep_id=? WHERE lecture_id=?";
        String userUpdateSql = "UPDATE user SET f_name = ?,l_name = ?, nic = ?, address = ?,email = ?,gender = ?,bod = ?, password = ? WHERE userId = ?";

        try{

            PreparedStatement ucPs = conn.prepareStatement(ucUpdateSql);
            ucPs.setString(1, lecContactNo);
            ucPs.setString(2, lecId);
            ucPs.executeUpdate();

            PreparedStatement lecUpdateStmt = conn.prepareStatement(lecUpdateSql);
            lecUpdateStmt.setString(1, lecPosition);
            lecUpdateStmt.setString(2, ld);
            lecUpdateStmt.setString(3, lecId);
            lecUpdateStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(userUpdateSql);
            userPs.setString(1, first_name);
            userPs.setString(2, last_name);
            userPs.setString(3, lecNIC);
            userPs.setString(4, lecAddress);
            userPs.setString(5, lecEmail);
            userPs.setString(6, lecGender);
            userPs.setString(7, lecBod.toString());
            userPs.setString(8, lecPassword);
            userPs.setString(9, lecId);
            userPs.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture '" + lecId + "' updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showLectureToTable();
        cleanLecTextFiled();
    }
    public void lecDelete(){
        Connection conn = Config.getConfig();
        String lecId = _lecId.getText();

        String deletlecContactSql = "DELETE FROM user_contact WHERE  userId =  ? ";
        String deleteLecSql = "DELETE FROM lecture WHERE lecture_id = ? ";
        String deleteUserSql = "DELETE FROM user WHERE userId = ? ";

        try{

            PreparedStatement user_contactPs = conn.prepareStatement(deletlecContactSql);
            user_contactPs.setString(1, lecId);
            user_contactPs.executeUpdate();

            PreparedStatement lectureStmt = conn.prepareStatement(deleteLecSql);
            lectureStmt.setString(1, lecId);
            lectureStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(deleteUserSql);
            userPs.setString(1, lecId);
            userPs.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Lecture Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Lecture '" + lecId + "'Deleted Successfully!");
            successAlert.showAndWait();

        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showLectureToTable();
        cleanLecTextFiled();
    }
    public void cleanLecTextFiled(){
        _lecId.setText("");
        _lecNIC.setText("");
        _lecName.setText("");
        _lecAddress.setText("");
        _lecEmail.setText("");
        _lecGenderM.setSelected(false);
        _lecBOD.setValue(null);
        _lecContactNo.setText("");
        _lecPositionTF.setText("");
        _lecPassword.setText("");
        _lecDepartment.setValue(null);
    }
    public void lecSearch(){
        FilteredList<LecDetails> filter = new FilteredList<>(getLecture(),e -> true);
        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateLecData ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicateLecData.getLecId().toLowerCase().contains(searchKey)) {
                    return true;
                }else if(predicateLecData.getLecFullName().toLowerCase().contains(searchKey)){
                    return true;
                } else if (predicateLecData.getLecAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getLecEmail().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateLecData.getLecGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getLecDepName().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateLecData.getLecPosition().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<LecDetails> sortedList = new SortedList<>(filter);
         sortedList.comparatorProperty().bind(lecTableView.comparatorProperty());
         lecTableView.setItems(sortedList);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showLectureToTable();
        setDepName();
    }
}
