package app.tecmis.admin;

import app.tecmis.connection.Config;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Admin implements Initializable {

    @FXML
    private AnchorPane adminPanel;

    @FXML
    private Button courseBtn;

    @FXML
    private AnchorPane course;

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
    private AnchorPane notise;

    @FXML
    private AnchorPane student;

    @FXML
    private Button studentBtn;

    @FXML
    private Button techofficerBtn;

    @FXML
    private AnchorPane techOfficer;

    @FXML
    private Button timeTableBtn;

    @FXML
    private AnchorPane timeTable;

    // lecture
    @FXML
    private ComboBox<String> _lecDepartment;

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
    private TextField lecSearchBar;

    @FXML
    private TableView<LecDetails> lecTableView;

    @FXML
    private TableColumn<LecDetails, String> lec_Address;

    @FXML
    private TableColumn<LecDetails, Date> lec_BOD;

    @FXML
    private TableColumn<LecDetails, String> lec_ContactNo;

    @FXML
    private TableColumn<LecDetails, String> lec_Email;

    @FXML
    private TableColumn<LecDetails, String> lec_Gender;

    @FXML
    private TableColumn<LecDetails, String> lec_ID;

    @FXML
    private TableColumn<LecDetails, String> lec_NIC;

    @FXML
    private TableColumn<LecDetails, String> lec_Name;

    @FXML
    private TableColumn<LecDetails, String> lec_Position;

    @FXML
    private TableColumn<LecDetails, String> lec_Password;

    @FXML
    private TableColumn<LecDetails, String> lec_Department;

    //student

    @FXML
    private TextField _stuAddress;

    @FXML
    private DatePicker _stuBOD;

    @FXML
    private TextField _stuContactNo;

    @FXML
    private ComboBox<String> _stuDepartment;

    @FXML
    private TextField _stuEmail;

    @FXML
    private RadioButton _stuGenderF;

    @FXML
    private RadioButton _stuGenderM;

    @FXML
    private TextField _stuId;

    @FXML
    private TextField _stuNIC;

    @FXML
    private TextField _stuName;

    @FXML
    private PasswordField _stuPassword;

    @FXML
    private ToggleGroup gender1;

    @FXML
    private TextField stuSearchBar;

    @FXML
    private TableView<StudentDetails> stuTableView;

    @FXML
    private TableColumn<StudentDetails, String> stu_Address;

    @FXML
    private TableColumn<StudentDetails, Date> stu_BOD;

    @FXML
    private TableColumn<StudentDetails, String> stu_ContactNo;

    @FXML
    private TableColumn<StudentDetails, String> stu_Department;

    @FXML
    private TableColumn<StudentDetails, String> stu_Email;

    @FXML
    private TableColumn<StudentDetails, String> stu_Gender;

    @FXML
    private TableColumn<StudentDetails, String> stu_ID;

    @FXML
    private TableColumn<StudentDetails, String> stu_NIC;

    @FXML
    private TableColumn<StudentDetails, String> stu_Name;

    @FXML
    private TableColumn<StudentDetails, String> stu_Password;

    // Tech Officer

    @FXML
    private TextField _tecAddress;

    @FXML
    private DatePicker _tecBOD;

    @FXML
    private TextField _tecContactNo;

    @FXML
    private TextField tecSearchBar;

    @FXML
    private TextField _tecEmail;

    @FXML
    private RadioButton _tecGenderF;

    @FXML
    private RadioButton _tecGenderM;

    @FXML
    private TextField _tecId;

    @FXML
    private TextField _tecNIC;

    @FXML
    private TextField _tecName;

    @FXML
    private PasswordField _tecPassword;

    @FXML
    private TextField _tecRoleTF;

    @FXML
    private ToggleGroup gender2;

    @FXML
    private ComboBox<String> _tecDepartment;

    @FXML
    private TableView<TechOfficerDetails> tecTableView;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Address;

    @FXML
    private TableColumn<TechOfficerDetails, Date> tec_BOD;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_ContactNo;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Department;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Email;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Gender;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_ID;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_NIC;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Name;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Password;

    @FXML
    private TableColumn<TechOfficerDetails, String> tec_Role;

    //Course

    @FXML
    private TextField _cCode;

    @FXML
    private TextField _cCredit;

    @FXML
    private ComboBox<String> _cDep;

    @FXML
    private TextField _cHoure;

    @FXML
    private TextField _cName;

    @FXML
    private ComboBox<String> _cType;

    @FXML
    private TableView<CourseDetails> _courseTableView;

    @FXML
    private TableColumn<CourseDetails, String> c_code;

    @FXML
    private TableColumn<CourseDetails, Integer> c_credit;

    @FXML
    private TableColumn<CourseDetails, String> c_dep;

    @FXML
    private TableColumn<CourseDetails, Integer> c_houre;

    @FXML
    private TableColumn<CourseDetails, String> c_name;

    @FXML
    private TableColumn<CourseDetails, String> c_type;

    @FXML
    private TextField courseSearchBar;

    //Notice

    @FXML
    private Label n_id;

    @FXML
    private TextArea n_description;

    @FXML
    private TextField n_tittle;
    
    @FXML
    private Label noticeDate;

    @FXML
    private TextField noticeSearchBar;

    @FXML
    private TableView<NoticeDetails> noticeTableView;

    @FXML
    private TableColumn<NoticeDetails, Date> _noticeDate;

    @FXML
    private TableColumn<NoticeDetails, Integer> _noticeId;

    @FXML
    private TableColumn<NoticeDetails, String> _noticeTittle;

    // Admin

    @FXML
    private Label total_lec;

    @FXML
    private Label total_student;

    @FXML
    private Label total_tecOfficer;

    @FXML
    private PieChart pi_chart;

    @FXML
    private BarChart<String, Number> chart_1;

    @FXML
    private LineChart<String, Number> chart_2;

    // Time Table
    private File scFile;
    private File imgPath;

    @FXML
    private ImageView imgView;

    @FXML
    private ComboBox<String> tt_dep;

    @FXML
    private ComboBox<String> tt_level;

    @FXML
    private ComboBox<String> tt_sem;

    @FXML
    private TableColumn<TimeTableDetails, String> _ttDep;

    @FXML
    private TableColumn<TimeTableDetails, String> _ttLevel;

    @FXML
    private TableColumn<TimeTableDetails, Integer> _ttNo;

    @FXML
    private TableColumn<TimeTableDetails, String> _ttSem;

    @FXML
    private TableView<TimeTableDetails> tt_view;

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
    void addNewStudentBtn(ActionEvent event) {
        addNewStudent();
    }
    @FXML
    void stuClearBtn(ActionEvent event) {
            cleanStuTextFiled();
    }
    @FXML
    void stuDeleteBtn(ActionEvent event) {
            deleteStudent();
    }
    @FXML
    void stuUpdateBtn(ActionEvent event) {
        updateStudent();
    }

    @FXML
    void addNewTechOfficerBtn(ActionEvent event) {
        addNewTechOfficer();
    }
    @FXML
    void tecOfficerDeleteBtn(ActionEvent event) {
        techOfficerDelete();
    }
    @FXML
    void techOfficerClearBtn(ActionEvent event) {
        cleanTechOfficerTextFiled();
    }
    @FXML
    void techOfficerUpdateBtn(ActionEvent event) {
        techOfficerUpdate();
    }

    @FXML
    void DeleteCourseBtn(ActionEvent event) {
        deleteCourse();
    }
    @FXML
    void newCourseAddBtn(ActionEvent event) {
        addNewCourse();
    }
    @FXML
    void resetCourseBtn(ActionEvent event) {
        clearCourseTextFiled();
    }
    @FXML
    void updateCourseBtn(ActionEvent event) {
        updateCourse();
    }

    @FXML
    void addNotice(ActionEvent event) {
        addNewNotice();
    }
    @FXML
    void clearNotice(ActionEvent event) {
        cleanNoticeFiled();
    }
    @FXML
    void deleteNotice(ActionEvent event) {
        deleteNotice();
    }
    @FXML
    void editNotice(ActionEvent event) {
        noticeEdit();
    }


    @FXML
    void tt_addBtn(ActionEvent event) {
        addNewTimeTable();
    }
    @FXML
    void tt_clearBtn(ActionEvent event) {

    }
    @FXML
    void tt_deleteBtn(ActionEvent event) {

    }
    @FXML
    void tt_editBtn(ActionEvent event) {

    }
    @FXML
    void tt_imgBtn(ActionEvent event) {
        takeImg();
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
    void handleRowsStuTable(MouseEvent event) {
        StudentDetails stuDetails = stuTableView.getSelectionModel().getSelectedItem();
        _stuId.setText(String.valueOf(stuDetails.getStuId()));
        _stuNIC.setText(String.valueOf(stuDetails.getStuNic()));
        _stuName.setText(String.valueOf(stuDetails.getStuFullName()));
        _stuAddress.setText(String.valueOf(stuDetails.getStuAddress()));
        _stuEmail.setText(String.valueOf(stuDetails.getStuEmail()));
        _stuPassword.setText(String.valueOf(stuDetails.getStuPassword()));
        _stuContactNo.setText(String.valueOf(stuDetails.getStuContactNo()));
        _stuDepartment.setValue(stuDetails.getStuDepName());

        String stuGender = String.valueOf(stuDetails.getStuGender());
        if("M".equalsIgnoreCase(stuGender)){
            _stuGenderM.setSelected(true);
        }else if("F".equalsIgnoreCase(stuGender)){
            _stuGenderF.setSelected(true);
        }

        String date = String.valueOf(stuDetails.getStuBod());
        LocalDate localDate = LocalDate.parse(date);
        _stuBOD.setValue(localDate);
    }
    @FXML
    void handleRowsTecTable(MouseEvent event) {
        TechOfficerDetails tecDetails = tecTableView.getSelectionModel().getSelectedItem();
        _tecId.setText(String.valueOf(tecDetails.getToId()));
        _tecNIC.setText(String.valueOf(tecDetails.getToNic()));
        _tecName.setText(String.valueOf(tecDetails.getToFullName()));
        _tecAddress.setText(String.valueOf(tecDetails.getToAddress()));
        _tecEmail.setText(String.valueOf(tecDetails.getToEmail()));
        _tecPassword.setText(String.valueOf(tecDetails.getToPassword()));
        _tecContactNo.setText(String.valueOf(tecDetails.getToContactNo()));
        _tecRoleTF.setText(String.valueOf(tecDetails.getToRole()));
        _tecDepartment.setValue(tecDetails.getToDepName());

        String tecGender = String.valueOf(tecDetails.getToGender());
        if("M".equalsIgnoreCase(tecGender)){
            _tecGenderM.setSelected(true);
        }else if("F".equalsIgnoreCase(tecGender)){
            _tecGenderF.setSelected(true);
        }

        String date = String.valueOf(tecDetails.getToBod());
        LocalDate localDate = LocalDate.parse(date);
        _tecBOD.setValue(localDate);
    }
    @FXML
    void handleCourseRows(MouseEvent event) {
        CourseDetails cd = _courseTableView.getSelectionModel().getSelectedItem();
        _cCode.setText(cd.getCourseCode());
        _cName.setText(cd.getCourseName());
        _cCredit.setText(String.valueOf(cd.getCourseCredit()));
        _cHoure.setText(String.valueOf(cd.getCourseHoures()));
        _cType.setValue(cd.getCourseType());
        _cDep.setValue(cd.getCourseDepartment());
    }
    @FXML
    void handleNoticeRows(MouseEvent event) {
        NoticeDetails noticeDetails = noticeTableView.getSelectionModel().getSelectedItem();
        n_tittle.setText(String.valueOf(noticeDetails.getNoticeTitle()));
        n_description.setText(String.valueOf(noticeDetails.getNoticeDescription()));
        noticeDate.setText(String.valueOf(noticeDetails.getNoticeDate()));
        n_id.setText(String.valueOf(noticeDetails.getNoticeId()));
    }
    @FXML
    void timeTableRowHandle(MouseEvent event) {
        TimeTableDetails ttDet = tt_view.getSelectionModel().getSelectedItem();
        tt_level.setValue(ttDet.getTtLevel());
        tt_dep.setValue(ttDet.getTtDepName());
        tt_sem.setValue(ttDet.getTtSem());
        imgView.setImage(new Image(new File(ttDet.getTtImgPath()).toURI().toString()));
    }
    @FXML
    void userSearchBar(MouseEvent event) {
        if(event.getSource() == lecSearchBar){
            lecSearch();
        } else if(event.getSource() == stuSearchBar){
            stuSearch();
        } else if(event.getSource() == tecSearchBar){
            tecSearch();
        } else if(event.getSource() == courseSearchBar){
            courseSearch();
        } else  if(event.getSource() == noticeSearchBar){
            noticeSearch();
        }

    }

    @FXML
    void navBar_link(ActionEvent event) {
        if(event.getSource()==dashbordBtn){
            dashbord.setVisible(true);
            lecture.setVisible(false);
            student.setVisible(false);
            techOfficer.setVisible(false);
            course.setVisible(false);
            notise.setVisible(false);
            timeTable.setVisible(false);
            total_student.setText(getCountUser("student"));
            total_lec.setText(getCountUser("lecture"));
            total_tecOfficer.setText(getCountUser("tech"));
        }else if(event.getSource()==lectureBtn){
            dashbord.setVisible(false);
            lecture.setVisible(true);
            student.setVisible(false);
            techOfficer.setVisible(false);
            course.setVisible(false);
            notise.setVisible(false);
            timeTable.setVisible(false);
        }else if(event.getSource()==studentBtn){
            dashbord.setVisible(false);
            lecture.setVisible(false);
            student.setVisible(true);
            techOfficer.setVisible(false);
            course.setVisible(false);
            notise.setVisible(false);
            timeTable.setVisible(false);
        }else if(event.getSource()==techofficerBtn){
            dashbord.setVisible(false);
            lecture.setVisible(false);
            student.setVisible(false);
            techOfficer.setVisible(true);
            course.setVisible(false);
            notise.setVisible(false);
            timeTable.setVisible(false);
        }else if(event.getSource()==courseBtn){
            dashbord.setVisible(false);
            lecture.setVisible(false);
            student.setVisible(false);
            techOfficer.setVisible(false);
            course.setVisible(true);
            notise.setVisible(false);
            timeTable.setVisible(false);
        }else if(event.getSource()==noticeBtn){
            dashbord.setVisible(false);
            lecture.setVisible(false);
            student.setVisible(false);
            techOfficer.setVisible(false);
            course.setVisible(false);
            notise.setVisible(true);
            timeTable.setVisible(false);
        }else if(event.getSource()==timeTableBtn){
            dashbord.setVisible(false);
            lecture.setVisible(false);
            student.setVisible(false);
            techOfficer.setVisible(false);
            course.setVisible(false);
            notise.setVisible(false);
            timeTable.setVisible(true);
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
        _stuDepartment.setItems(dep);
        _tecDepartment.setItems(dep);
        _cDep.setItems(dep);
        tt_dep.setItems(dep);
    }
    public String setDepId(Object DepName) {
        Connection conn2 = Config.getConfig();
        String ld = "";
        if(DepName != null){
            DepName = DepName.toString();
        }
        String depSql = "SELECT * FROM department";
        Statement depSt = null;
        ResultSet depRs = null;
        try{
            depSt = conn2.createStatement();
            depRs = depSt.executeQuery(depSql);
            while(depRs.next()){
                String depName = depRs.getString("dep_name");
                if(depName.equals(DepName)){
                    ld = depRs.getString("dep_id");
                    break;
                }
            }
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return ld;
    }
    public String courseType(){
        ObservableList<String> courseTypeList = FXCollections.observableArrayList("Theory","Practical","Theory & Practical");
        _cType.setItems(courseTypeList);
        return String.valueOf(courseTypeList);
    }
    public String selectLevel(){
        ObservableList<String> List = FXCollections.observableArrayList("Level 1","Level 2","Level 3","Level 4");
        tt_level.setItems(List);
        return String.valueOf(List);
    }
    public String selectSem(){
        ObservableList<String> List = FXCollections.observableArrayList("Semester 1","Semester 2");
        tt_sem.setItems(List);
        return String.valueOf(List);
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
        lec_ID.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecId"));
        lec_NIC.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecNic"));
        lec_Name.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecFullName"));
        lec_Address.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecAddress"));
        lec_Email.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecEmail"));
        lec_Gender.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecGender"));
        lec_BOD.setCellValueFactory(new PropertyValueFactory<LecDetails, Date>("lecBod"));
        lec_ContactNo.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecContactNo"));
        lec_Position.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecPosition"));
        lec_Department.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecDepName"));
        lec_Password.setCellValueFactory(new PropertyValueFactory<LecDetails,String>("lecPassword"));

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
        lecSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
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

    public ObservableList<StudentDetails> getStudent(){
        ObservableList<StudentDetails> stuList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String stuSql = "SELECT * FROM student s JOIN user u ON s.student_id = u.userId LEFT JOIN user_contact uc ON u.userId = uc.userId INNER JOIN department d ON d.dep_id = s.dep_id";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(stuSql);
            StudentDetails stu;
            while(rs.next()){
                stu = new StudentDetails(rs.getString("userId"),
                        rs.getString("nic"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("contact_no"),
                        rs.getString("dep_name"),
                        rs.getString("password")
                );
                stuList.add(stu);
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return stuList;
    }
    public void showStudentToTable() {
        ObservableList<StudentDetails> stuList = getStudent();
        stu_ID.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuId"));
        stu_NIC.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuNic"));
        stu_Name.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuFullName"));
        stu_Address.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuAddress"));
        stu_Email.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuEmail"));
        stu_Gender.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuGender"));
        stu_BOD.setCellValueFactory(new PropertyValueFactory<StudentDetails, Date>("stuBod"));
        stu_ContactNo.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuContactNo"));
        stu_Department.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuDepName"));
        stu_Password.setCellValueFactory(new PropertyValueFactory<StudentDetails,String>("stuPassword"));

        stuTableView.setItems(stuList);
    }
    private void addNewStudent(){
        Connection conn = Config.getConfig();
        String stuId = _stuId.getText();
        String stuNIC = _stuNIC.getText();
        String stuFullName = _stuName.getText();
        String stuAddress = _stuAddress.getText();
        String stuEmail = _stuEmail.getText();
        String stuGender = _stuGenderM.isSelected() ? "M" : "F";
        LocalDate stuBod = _stuBOD.getValue();
        String stuContactNo = _stuContactNo.getText();
        String stuPassword = _stuPassword.getText();
        Object stuDepName = _stuDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(stuDepName);

        if (stuId.isEmpty()
                || stuNIC.isEmpty()
                || stuFullName.isEmpty()
                || stuAddress.isEmpty()
                || stuEmail.isEmpty()
                || stuGender.isEmpty()
                || stuBod == null
                || stuContactNo.isEmpty()
                || stuPassword.isEmpty()
                || stuDepName == null) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }

        String[] nameParts = stuFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

        String lecUserSql = "INSERT INTO user (userId,nic,password,user_type,f_name,l_name,address,email,gender,bod) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String lectureSql = "INSERT INTO student (student_id,state,dep_id) VALUES (?, ?, ?)";
        String contactSql = "INSERT INTO user_contact (userId, contact_no) VALUES (?, ?)";

        try{
            PreparedStatement userPs = conn.prepareStatement(lecUserSql);
            userPs.setString(1, stuId);
            userPs.setString(2, stuNIC);
            userPs.setString(3, stuPassword);
            userPs.setString(4, "student");
            userPs.setString(5, first_name);
            userPs.setString(6, last_name);
            userPs.setString(7, stuAddress);
            userPs.setString(8, stuEmail);
            userPs.setString(9, stuGender);
            userPs.setString(10, stuBod.toString());
            userPs.executeUpdate();

            PreparedStatement stuStmt = conn.prepareStatement(lectureSql);
            stuStmt.setString(1, stuId);
            stuStmt.setString(2, "Active");
            stuStmt.setString(3, ld);
            stuStmt.executeUpdate();

            PreparedStatement contactStmt = conn.prepareStatement(contactSql);
            contactStmt.setString(1, stuId);
            contactStmt.setString(2, stuContactNo);
            contactStmt.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Student Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Student '" + stuId + "'added successfully!");
            successAlert.showAndWait();

        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showStudentToTable();
        cleanStuTextFiled();
    }
    private void updateStudent(){
        Connection conn = Config.getConfig();
        String stuId = _stuId.getText();
        String stuNIC = _stuNIC.getText();
        String stuFullName = _stuName.getText();
        String stuAddress = _stuAddress.getText();
        String stuEmail = _stuEmail.getText();
        String stuGender = _stuGenderM.isSelected() ? "M" : "F";
        LocalDate stuBod = _stuBOD.getValue();
        String stuContactNo = _stuContactNo.getText();
        String stuPassword = _stuPassword.getText();
        Object stuDepName = _stuDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(stuDepName);

        String[] nameParts = stuFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

        String ucUpdateSql = "UPDATE user_contact SET contact_no=? WHERE userId=?";
        String lecUpdateSql = "UPDATE student SET dep_id=? WHERE student_id=?";
        String userUpdateSql = "UPDATE user SET f_name = ?,l_name = ?, nic = ?, address = ?,email = ?,gender = ?,bod = ?, password = ? WHERE userId = ?";

        try{

            PreparedStatement ucPs = conn.prepareStatement(ucUpdateSql);
            ucPs.setString(1, stuContactNo);
            ucPs.setString(2, stuId);
            ucPs.executeUpdate();

            PreparedStatement stuUpdateStmt = conn.prepareStatement(lecUpdateSql);
            stuUpdateStmt.setString(1, ld);
            stuUpdateStmt.setString(2, stuId);
            stuUpdateStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(userUpdateSql);
            userPs.setString(1, first_name);
            userPs.setString(2, last_name);
            userPs.setString(3, stuNIC);
            userPs.setString(4, stuAddress);
            userPs.setString(5, stuEmail);
            userPs.setString(6, stuGender);
            userPs.setString(7, stuBod.toString());
            userPs.setString(8, stuPassword);
            userPs.setString(9, stuId);
            userPs.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Student Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Student '" + stuId + "' updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showStudentToTable();
        cleanStuTextFiled();
    }
    private void deleteStudent(){
        Connection conn = Config.getConfig();
        String stuId = _stuId.getText();

        String deleteStuContactSql = "DELETE FROM user_contact WHERE  userId =  ? ";
        String deleteStuSql = "DELETE FROM student WHERE student_id = ? ";
        String deleteUserSql = "DELETE FROM user WHERE userId = ? ";

        try{

            PreparedStatement user_contactPs = conn.prepareStatement(deleteStuContactSql);
            user_contactPs.setString(1, stuId);
            user_contactPs.executeUpdate();

            PreparedStatement stuStmt = conn.prepareStatement(deleteStuSql);
            stuStmt.setString(1, stuId);
            stuStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(deleteUserSql);
            userPs.setString(1, stuId);
            userPs.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Student Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Student '" + stuId + "'Deleted Successfully!");
            successAlert.showAndWait();

        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showStudentToTable();
        cleanStuTextFiled();
    }
    public void cleanStuTextFiled(){
        _stuId.setText("");
        _stuNIC.setText("");
        _stuName.setText("");
        _stuAddress.setText("");
        _stuEmail.setText("");
        _stuGenderM.setSelected(false);
        _stuBOD.setValue(null);
        _stuContactNo.setText("");
        _stuPassword.setText("");
        _stuDepartment.setValue(null);
    }
    public void stuSearch(){
        FilteredList<StudentDetails> filterStu = new FilteredList<>(getStudent(),e -> true);
        stuSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filterStu.setPredicate(predicateLecData ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicateLecData.getStuId().toLowerCase().contains(searchKey)) {
                    return true;
                }else if(predicateLecData.getStuFullName().toLowerCase().contains(searchKey)){
                    return true;
                } else if (predicateLecData.getStuAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getStuEmail().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateLecData.getStuGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getStuDepName().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<StudentDetails> sortedList = new SortedList<>(filterStu);
        sortedList.comparatorProperty().bind(stuTableView.comparatorProperty());
        stuTableView.setItems(sortedList);
    }

    public ObservableList<TechOfficerDetails> getTechOfficers() {
        ObservableList<TechOfficerDetails> techOfficerList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String toSql = "SELECT * FROM technical_officer t JOIN user u ON t.tech_officer_id = u.userId LEFT JOIN user_contact uc ON u.userId = uc.userId INNER JOIN department d ON d.dep_id = t.dep_id";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(toSql);
            TechOfficerDetails tod;
            while(rs.next()){
                tod = new TechOfficerDetails(rs.getString("userId"),
                        rs.getString("nic"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("contact_no"),
                        rs.getString("role"),
                        rs.getString("dep_name"),
                        rs.getString("password")
                );
                techOfficerList.add(tod);
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return techOfficerList;
    }
    public void showTechOfficerToTable() {
        ObservableList<TechOfficerDetails> tecList = getTechOfficers();
        tec_ID.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toId"));
        tec_NIC.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toNic"));
        tec_Name.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toFullName"));
        tec_Address.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toAddress"));
        tec_Email.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toEmail"));
        tec_Gender.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toGender"));
        tec_BOD.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails, Date>("toBod"));
        tec_ContactNo.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toContactNo"));
        tec_Role.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toRole"));
        tec_Department.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toDepName"));
        tec_Password.setCellValueFactory(new PropertyValueFactory<TechOfficerDetails,String>("toPassword"));

        tecTableView.setItems(tecList);
    }
    private void addNewTechOfficer() {
        Connection conn = Config.getConfig();
        String tecId = _tecId.getText();
        String tecNIC = _tecNIC.getText();
        String tecFullName = _tecName.getText();
        String tecAddress = _tecAddress.getText();
        String tecEmail = _tecEmail.getText();
        String tecGender = _tecGenderM.isSelected() ? "M" : "F";
        LocalDate tecBod = _tecBOD.getValue();
        String tecContactNo = _tecContactNo.getText();
        String tecRole = _tecRoleTF.getText();
        String tecPassword = _tecPassword.getText();
        Object tecDepName = _tecDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(tecDepName);

        if (tecId.isEmpty()
                || tecNIC.isEmpty()
                || tecFullName.isEmpty()
                || tecAddress.isEmpty()
                || tecEmail.isEmpty()
                || tecGender.isEmpty()
                || tecBod == null
                || tecContactNo.isEmpty()
                || tecRole.isEmpty()
                || tecPassword.isEmpty()
                || tecDepName == null) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }

        String[] nameParts = tecFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

        String tecUserSql = "INSERT INTO user (userId,nic,password,user_type,f_name,l_name,address,email,gender,bod) VALUES (?,?,?,?,?,?,?,?,?,?)";
        String tecSql = "INSERT INTO technical_officer (tech_officer_id,role,dep_id) VALUES (?, ?, ?)";
        String contactSql = "INSERT INTO user_contact (userId, contact_no) VALUES (?, ?)";

        try{
            PreparedStatement userPs = conn.prepareStatement(tecUserSql);
            userPs.setString(1, tecId);
            userPs.setString(2, tecNIC);
            userPs.setString(3, tecPassword);
            userPs.setString(4, "tech");
            userPs.setString(5, first_name);
            userPs.setString(6, last_name);
            userPs.setString(7, tecAddress);
            userPs.setString(8, tecEmail);
            userPs.setString(9, tecGender);
            userPs.setString(10, tecBod.toString());
            userPs.executeUpdate();

            PreparedStatement stuStmt = conn.prepareStatement(tecSql);
            stuStmt.setString(1, tecId);
            stuStmt.setString(2, tecRole);
            stuStmt.setString(3, ld);
            stuStmt.executeUpdate();

            PreparedStatement contactStmt = conn.prepareStatement(contactSql);
            contactStmt.setString(1, tecId);
            contactStmt.setString(2, tecContactNo);
            contactStmt.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Student Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Student '" + tecId + "'added successfully!");
            successAlert.showAndWait();

        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showTechOfficerToTable();
        cleanTechOfficerTextFiled();
    }
    public void techOfficerUpdate(){
        Connection conn = Config.getConfig();
        String tecId = _tecId.getText();
        String tecNIC = _tecNIC.getText();
        String tecFullName = _tecName.getText();
        String tecAddress = _tecAddress.getText();
        String tecEmail = _tecEmail.getText();
        String tecGender = _tecGenderM.isSelected() ? "M" : "F";
        LocalDate tecBod = _tecBOD.getValue();
        String tecContactNo = _tecContactNo.getText();
        String tecRole  = _tecRoleTF.getText();
        String tecPassword = _tecPassword.getText();
        Object tecDepName = _tecDepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(tecDepName);

        String[] nameParts = tecFullName.split(" ");
        String first_name = nameParts[0];
        String last_name = nameParts.length > 1 ? nameParts[1] : "";

        String ucUpdateSql = "UPDATE user_contact SET contact_no=? WHERE userId=?";
        String tecUpdateSql = "UPDATE  technical_officer  SET role=?, dep_id=? WHERE tech_officer_id=?";
        String userUpdateSql = "UPDATE user SET f_name = ?,l_name = ?, nic = ?, address = ?,email = ?,gender = ?,bod = ?, password = ? WHERE userId = ?";

        try{

            PreparedStatement ucPs = conn.prepareStatement(ucUpdateSql);
            ucPs.setString(1, tecContactNo);
            ucPs.setString(2, tecId);
            ucPs.executeUpdate();

            PreparedStatement tecUpdateStmt = conn.prepareStatement(tecUpdateSql);
            tecUpdateStmt.setString(1, tecRole);
            tecUpdateStmt.setString(2, ld);
            tecUpdateStmt.setString(3, tecId);
            tecUpdateStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(userUpdateSql);
            userPs.setString(1, first_name);
            userPs.setString(2, last_name);
            userPs.setString(3, tecNIC);
            userPs.setString(4, tecAddress);
            userPs.setString(5, tecEmail);
            userPs.setString(6, tecGender);
            userPs.setString(7, tecBod.toString());
            userPs.setString(8, tecPassword);
            userPs.setString(9, tecId);
            userPs.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture '" + tecId + "' updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showTechOfficerToTable();
        cleanTechOfficerTextFiled();
    }
    public void techOfficerDelete(){
        Connection conn = Config.getConfig();
        String tecId = _tecId.getText();

        String deleteTechContactSql = "DELETE FROM user_contact WHERE  userId =  ? ";
        String deleteTechSql = "DELETE FROM technical_officer WHERE tech_officer_id = ? ";
        String deleteUserSql = "DELETE FROM user WHERE userId = ? ";

        try{

            PreparedStatement user_contactPs = conn.prepareStatement(deleteTechContactSql);
            user_contactPs.setString(1, tecId);
            user_contactPs.executeUpdate();

            PreparedStatement toStmt = conn.prepareStatement(deleteTechSql);
            toStmt.setString(1, tecId);
            toStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(deleteUserSql);
            userPs.setString(1, tecId);
            userPs.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Lecture Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Lecture '" + tecId + "'Deleted Successfully!");
            successAlert.showAndWait();

        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        showTechOfficerToTable();
        cleanTechOfficerTextFiled();
    }
    public void cleanTechOfficerTextFiled(){
        _tecId.setText("");
        _tecNIC.setText("");
        _tecName.setText("");
        _tecAddress.setText("");
        _tecEmail.setText("");
        _tecGenderM.setSelected(false);
        _tecBOD.setValue(null);
        _tecContactNo.setText("");
        _tecRoleTF.setText("");
        _tecPassword.setText("");
        _tecDepartment.setValue(null);
    }
    public void tecSearch(){
        FilteredList<TechOfficerDetails> filter = new FilteredList<>(getTechOfficers(),e -> true);
        tecSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateLecData ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicateLecData.getToId().toLowerCase().contains(searchKey)) {
                    return true;
                }else if(predicateLecData.getToFullName().toLowerCase().contains(searchKey)){
                    return true;
                } else if (predicateLecData.getToAddress().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getToEmail().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateLecData.getToGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getToDepName().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (predicateLecData.getToRole().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<TechOfficerDetails> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(tecTableView.comparatorProperty());
        tecTableView.setItems(sortedList);
    }

    public ObservableList<CourseDetails> getCourseDetails(){
        ObservableList<CourseDetails> courseList = FXCollections.observableArrayList();
        Connection con = Config.getConfig();

        String courseSql = "SELECT * FROM course c INNER JOIN department d ON d.dep_id = c.dep_id ";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(courseSql);
            CourseDetails cd;
            while (rs.next()) {
                cd = new CourseDetails(
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        rs.getInt("course_credit"),
                        rs.getInt("course_houre"),
                        rs.getString("course_type"),
                        rs.getString("dep_name")
                );
                courseList.add(cd);
            }
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return courseList;
    }
    public void showCourseToTable(){
        ObservableList<CourseDetails> courseDetails = getCourseDetails();
        c_code.setCellValueFactory(new PropertyValueFactory<CourseDetails,String>("courseCode"));
        c_name.setCellValueFactory(new PropertyValueFactory<CourseDetails,String>("courseName"));
        c_credit.setCellValueFactory(new PropertyValueFactory<CourseDetails,Integer>("courseCredit"));
        c_houre.setCellValueFactory(new PropertyValueFactory<CourseDetails,Integer>("courseHoures"));
        c_type.setCellValueFactory(new PropertyValueFactory<CourseDetails,String>("courseType"));
        c_dep.setCellValueFactory(new PropertyValueFactory<CourseDetails,String>("courseDepartment"));

        _courseTableView.setItems(courseDetails);
    }
    public void addNewCourse(){
        Connection con = Config.getConfig();
        String c_code = _cCode.getText();
        String c_name = _cName.getText();
        int c_cradit = Integer.parseInt(_cCredit.getText());
        int c_houres = Integer.parseInt(_cHoure.getText());
        String c_type = _cType.getSelectionModel().getSelectedItem();
        String c_dep = _cDep.getSelectionModel().getSelectedItem();
        String c_depId = setDepId(c_dep);

        if(c_code.isEmpty()
                || c_name.isEmpty()
                || c_cradit == 0
                || c_houres == 0
                || c_type == null
                || c_dep == null
        ){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }
        String insertSql = "INSERT INTO course VALUE(?,?,?,?,?,?)";

        try{
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, c_code);
            ps.setString(2, c_name);
            ps.setInt(3, c_cradit);
            ps.setInt(4, c_houres);
            ps.setString(5, c_type);
            ps.setString(6,c_depId);
            ps.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("New Course Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Course '" + c_code + "' added successfully!");
            successAlert.showAndWait();
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
        showCourseToTable();
        clearCourseTextFiled();
    }
    public void updateCourse(){
        Connection con = Config.getConfig();

        String c_code = _cCode.getText();
        String c_name = _cName.getText();
        int c_cradit = Integer.parseInt(_cCredit.getText());
        int c_houres = Integer.parseInt(_cHoure.getText());
        String c_type = _cType.getSelectionModel().getSelectedItem();
        String c_dep = _cDep.getSelectionModel().getSelectedItem();
        String c_depId = setDepId(c_dep);

        String upSql = "UPDATE course SET course_name = ?,course_credit = ?,course_houre = ?,course_type = ?,dep_id = ? WHERE course_code = ?";
        try{
           PreparedStatement ps = con.prepareStatement(upSql);
           ps.setString(1, c_name);
           ps.setInt(2, c_cradit);
           ps.setInt(3, c_houres);
           ps.setString(4, c_type);
           ps.setString(5, c_depId);
           ps.setString(6, c_code);
           ps.executeUpdate();

           Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
           successAlert.setTitle("Course Updated");
           successAlert.setHeaderText(null);
           successAlert.setContentText("Course '" + c_code + "' Updated successfully!");
           successAlert.showAndWait();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        showCourseToTable();
        clearCourseTextFiled();
    }
    public void deleteCourse(){
        Connection con = Config.getConfig();
        String c_code = _cCode.getText();
        String c_name = _cName.getText();
        int c_cradit = Integer.parseInt(_cCredit.getText());
        int c_houres = Integer.parseInt(_cHoure.getText());
        String c_type = _cType.getSelectionModel().getSelectedItem();
        String c_dep = _cDep.getSelectionModel().getSelectedItem();
        String c_depId = setDepId(c_dep);

        String DeleteSql = "DELETE FROM course WHERE course_code = ?";

        try{
            PreparedStatement ps = con.prepareStatement(DeleteSql);
            ps.setString(1, c_code);
            ps.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Course Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Course '" + c_code + "' deleted successfully!");
            successAlert.showAndWait();
        }catch (Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        showCourseToTable();
        clearCourseTextFiled();
    }
    public void clearCourseTextFiled(){
        _cCode.setText("");
        _cName.setText("");
        _cCredit.setText("");
        _cHoure.setText("");
        _cType.setValue(null);
        _cDep.setValue(null);
    }
    public void courseSearch(){
        FilteredList<CourseDetails> filter = new FilteredList<>(getCourseDetails(),e -> true);
        courseSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateLecData ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicateLecData.getCourseCode().toLowerCase().contains(searchKey)) {
                    return true;
                }else if(predicateLecData.getCourseName().toLowerCase().contains(searchKey)){
                    return true;
                } else if (predicateLecData.getCourseDepartment().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateLecData.getCourseType().toLowerCase().contains(searchKey)) {
                    return true;
                }else if (String.valueOf(predicateLecData.getCourseCredit()).contains(searchKey)){
                    return true;
                } else if (String.valueOf(predicateLecData.getCourseHoures()).contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<CourseDetails> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(_courseTableView.comparatorProperty());
        _courseTableView.setItems(sortedList);
    }

    public ObservableList<NoticeDetails> getNoticeList() {
        ObservableList<NoticeDetails> noticeList = FXCollections.observableArrayList();
        Connection con = Config.getConfig();

        String noticeSql = "SELECT * FROM notice ORDER BY  notice_id DESC";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(noticeSql);
            NoticeDetails nd;
            while (rs.next()) {
                nd = new NoticeDetails(
                        rs.getInt("notice_id"),
                        rs.getString("notice_title"),
                        rs.getString("description"),
                        rs.getDate("date")
                );
                noticeList.add(nd);
            }
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return noticeList;
    }
    public void showNoticeToTable(){
        ObservableList<NoticeDetails> noticeDetails = getNoticeList();
        _noticeId.setCellValueFactory(new PropertyValueFactory<NoticeDetails,Integer>("noticeId"));
        _noticeTittle.setCellValueFactory(new PropertyValueFactory<NoticeDetails,String>("noticeTitle"));
        _noticeDate.setCellValueFactory(new PropertyValueFactory<NoticeDetails,Date>("noticeDate"));
        noticeTableView.setItems(noticeDetails);
    }
    public void addNewNotice(){
        Connection con = Config.getConfig();
        String nTittle = n_tittle.getText();
        String nDes = n_description.getText();
        LocalDate nDate = LocalDate.now();


        if(nTittle.isEmpty()
                || nDes.isEmpty()
        ){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }
        String insertSql = "INSERT INTO notice (description,date,notice_title) VALUE(?,?,?)";

        try{
            PreparedStatement ps = con.prepareStatement(insertSql);
            ps.setString(1, nDes);
            ps.setDate(2, java.sql.Date.valueOf(nDate));
            ps.setString(3, nTittle);
            ps.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("New Notice Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Notice '" + nTittle + "' added successfully!");
            successAlert.showAndWait();
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
        showNoticeToTable();
    }
    public void noticeEdit(){
        Connection con = Config.getConfig();
        String nTittle = n_tittle.getText();
        String nDes = n_description.getText();
        int nId = Integer.parseInt(n_id.getText());

        if(nTittle.isEmpty()
                || nDes.isEmpty()
        ){
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }

        String upSql = "UPDATE notice SET notice_title = ?,description = ? WHERE notice_id = ?";

        try{
            PreparedStatement ps = con.prepareStatement(upSql);
            ps.setString(1, nTittle);
            ps.setString(2, nDes);
            ps.setInt(3, nId);
            ps.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Notice Edited");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Notice '" + nTittle + "' edited successfully!");
            successAlert.showAndWait();
        } catch (Exception e) {
            System.out.println("Error"+ e.getMessage());
        }
        showNoticeToTable();
        cleanNoticeFiled();
    }
    public void deleteNotice(){
        Connection con = Config.getConfig();
        int nId = Integer.parseInt(n_id.getText());
        String nTittle = n_tittle.getText();
        String deleteSql = "DELETE FROM notice WHERE notice_id = ?";
        try{
            PreparedStatement ps = con.prepareStatement(deleteSql);
            ps.setInt(1, nId);
            ps.executeUpdate();
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Notice Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Notice '" + nTittle  + "' deleted successfully!");
            successAlert.showAndWait();

        }catch (Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        showNoticeToTable();
        cleanNoticeFiled();
    }
    public void cleanNoticeFiled(){
        n_id.setText("");
        n_tittle.setText("");
        n_description.setText("");
        noticeDate.setText("");
    }
    public void noticeSearch(){
        FilteredList<NoticeDetails> filter = new FilteredList<>(getNoticeList(),e -> true);
        noticeSearchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicateLecData ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicateLecData.getNoticeTitle().toLowerCase().contains(searchKey)) {
                    return true;
                }else if(String.valueOf(predicateLecData.getNoticeId()).contains(searchKey)){
                    return true;
                } else if (String.valueOf(predicateLecData.getNoticeDate()).contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<NoticeDetails> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(noticeTableView.comparatorProperty());
        noticeTableView.setItems(sortedList);
    }

    public String getCountUser(String uType){
        Connection con = Config.getConfig();
        String selectSql = "SELECT COUNT(userId) FROM user WHERE user_type = '"+uType +"'";
        String temp = "";
        try{
            PreparedStatement ps = con.prepareStatement(selectSql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                temp = rs.getString(1);

            }
        } catch (Exception e){
            System.out.println("Error"+ e.getMessage());
        }
        return temp;
    }
    public void dashboardLineChart() {
        Connection con = Config.getConfig();
        chart_2.getData().clear();
        String sql = "SELECT COUNT(notice_id) AS total_notices, date FROM notice GROUP BY date";

        try {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String date = rs.getString("date");
                int count = rs.getInt("total_notices");
                series.getData().add(new XYChart.Data<>(date, count));
            }
            chart_2.getData().add(series);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void loadCourseTypePieChart() {
        Connection con = Config.getConfig();
        pi_chart.getData().clear(); // Clear old data

        String sql = "SELECT course_type, COUNT(*) AS total FROM course GROUP BY course_type";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String type = rs.getString("course_type");
                int total = rs.getInt("total");
                PieChart.Data slice = new PieChart.Data(type, total);
                pi_chart.getData().add(slice);
            }

            pi_chart.setTitle("Courses by Type");
            pi_chart.setLegendVisible(true);
            pi_chart.setLabelsVisible(true);
        } catch (Exception e) {
            System.out.println("Error loading pie chart: " + e.getMessage());
        }
    }
    public void loadCourseEnrollmentBarChart() {
        Connection con = Config.getConfig();
        chart_1.getData().clear(); // Clear previous data

        String sql = "SELECT course_code, COUNT(student_id) AS student_count FROM student_course GROUP BY course_code";

        try {
            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName("Enrollments per Course");

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                int studentCount = rs.getInt("student_count");
                series.getData().add(new XYChart.Data<>(courseCode, studentCount));
            }

            chart_1.getData().add(series);
        } catch (Exception e) {
            System.out.println("Error loading bar chart: " + e.getMessage());
        }
    }

    public ObservableList<TimeTableDetails> getTimeTableList() {
        ObservableList<TimeTableDetails> list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String ttSql = "SELECT * FROM timetable t INNER JOIN department d ON t.dep_id = d.dep_id";
        Statement st = null;
        ResultSet rs = null;

        try{
            st = con.createStatement();
            rs = st.executeQuery(ttSql);
            TimeTableDetails ttD;
            while (rs.next()) {
                ttD = new TimeTableDetails(
                        rs.getInt("ttid"),
                        rs.getString("level"),
                        rs.getString("dep_id"),
                        rs.getString("semester"),
                        rs.getString("pdf_path"),
                        rs.getString("dep_name")
                );
                list.add(ttD);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
    public void addNewTimeTable(){
        Connection con = Config.getConfig();
        String depName = tt_dep.getSelectionModel().getSelectedItem();
        String depId = setDepId(depName);
        String semester = tt_sem.getSelectionModel().getSelectedItem();
        String level = tt_level.getSelectionModel().getSelectedItem();

        if(imgPath.equals("")){
            System.out.println("Image Path is empty");
            return;
        }

        String ttSql = "INSERT INTO timetable(level,dep_id,semester,pdf_path) VALUES(?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(ttSql);
            ps.setString(1, level);
            ps.setString(2, depId);
            ps.setString(3, semester);
            ps.setString(4, String.valueOf(imgPath));
            ps.executeUpdate();
            System.out.println("Added time table");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        showTimeTable();
    }
    public void showTimeTable(){
        ObservableList<TimeTableDetails> ttList = getTimeTableList();
        _ttNo.setCellValueFactory(new PropertyValueFactory<TimeTableDetails,Integer>("ttId"));
        _ttLevel.setCellValueFactory(new PropertyValueFactory<TimeTableDetails,String>("ttLevel"));
        _ttDep.setCellValueFactory(new PropertyValueFactory<TimeTableDetails,String>("ttDepName"));
        _ttSem.setCellValueFactory(new PropertyValueFactory<TimeTableDetails,String>("ttSem"));

         tt_view.setItems(ttList);
    }
    public void takeImg(){
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose Image");
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );
        scFile = fc.showOpenDialog(null);
        if(scFile != null){
            try{
                File uploadDir = new File("upload");
                if(!uploadDir.exists()) uploadDir.mkdir();

                File destFile = new File(uploadDir,scFile.getName());
                imgPath = destFile;
                Files.copy(scFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                imgView.setImage(new Image(destFile.toURI().toString()));

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showLectureToTable();
        showStudentToTable();
        showTechOfficerToTable();
        showCourseToTable();
        showNoticeToTable();
        showTimeTable();
        setDepName();
        courseType();
        total_student.setText(getCountUser("student"));
        total_lec.setText(getCountUser("lecture"));
        total_tecOfficer.setText(getCountUser("tech"));
        dashboardLineChart();
        loadCourseTypePieChart();
        loadCourseEnrollmentBarChart();
        selectLevel();
        selectSem();
    }

    @FXML
    void logout(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

}
