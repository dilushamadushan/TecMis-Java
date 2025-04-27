package app.tecmis.techOfficer;

import app.tecmis.LoginController;
import app.tecmis.connection.Config;
import app.tecmis.lecture.UndergraduateInformation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDate;

import javafx.scene.image.ImageView;

import java.util.Date;
import java.util.ResourceBundle;

public class TechOfficer implements Initializable {

        public static String userName = LoginController.techOfficerTg;
        @FXML
        private TextField Attendence_Ccode;

        @FXML
        private DatePicker Attendence_Date;

        @FXML
        private Label Attendence_ID;

        @FXML
        private Button Details_save_btn;

        @FXML
        private ToggleGroup EditattRadioBtn;

        @FXML
        private Button Medical_btn;

        @FXML
        private Button Medical_details_btn;

        @FXML
        private Button Medical_edit_btn;

        @FXML
        private Button Medical_logout_btn;

        @FXML
        private Button Medical_notice_btn;

        @FXML
        private TextArea _attAddress;

        @FXML
        private DatePicker _attBirthday;

        @FXML
        private TextField _attDepartmentName;

        @FXML
        private TextArea _attEditAddress;

        @FXML
        private DatePicker _attEditBOD;

        @FXML
        private TextField _attEditDepartmentName;

        @FXML
        private TextField _attEditEmail;

        @FXML
        private RadioButton _attEditFemale;

        @FXML
        private TextField _attEditFname;

        @FXML
        private TextField _attEditLname;

        @FXML
        private RadioButton _attEditMale;

        @FXML
        private TextField _attEditNIC;

        @FXML
        private TextField _attEditOfficerId;

        @FXML
        private TextField _attEditRole;

        @FXML
        private TextField _attEmail;

        @FXML
        private RadioButton _attFemale;

        @FXML
        private TextField _attFname;

        @FXML
        private TextField _attId;

        @FXML
        private TextField _attLname;

        @FXML
        private RadioButton _attMale;

        @FXML
        private TextField _attNIC;

        @FXML
        private TextField _attRole;

        @FXML
        private TextArea _medAddress;

        @FXML
        private DatePicker _medBOD;

        @FXML
        private DatePicker _medBirthday;

        @FXML
        private TextField _medDname;

        @FXML
        private TextArea _medEditAddress;

        @FXML
        private TextField _medEditDepartmentName;

        @FXML
        private TextField _medEditEmail;

        @FXML
        private RadioButton _medEditFemale;

        @FXML
        private TextField _medEditFname;

        @FXML
        private TextField _medEditLname;

        @FXML
        private RadioButton _medEditMale;

        @FXML
        private TextField _medEditNIC;

        @FXML
        private TextField _medEditOfficerId;

        @FXML
        private TextField _medEditRole;

        @FXML
        private TextField _medEmail;

        @FXML
        private RadioButton _medFemale;

        @FXML
        private TextField _medFname;

        @FXML
        private TextField _medId;

        @FXML
        private TextField _medLname;

        @FXML
        private RadioButton _medMale;

        @FXML
        private TextField _medNIC;

        @FXML
        private TextField _medRole;

        @FXML
        private Button add_attendence_btn;

        @FXML
        private ToggleGroup attRadioBtn;

        @FXML
        private Button attendence_btn;

        @FXML
        private Pane attendence_stage2;

        @FXML
        private Button delete_attendence_btn;

        @FXML
        private Button details_btn;

        @FXML
        private Button edit_btn;

        @FXML
        private Button findatt_btn;

        @FXML
        private ImageView imgView;

        @FXML
        private Button logout;

        @FXML
        private TextField m_course;

        @FXML
        private TextField m_id;

        @FXML
        private TextArea m_reasone;

        @FXML
        private AnchorPane main_page1;

        @FXML
        private DatePicker me_date;

        @FXML
        private Button medicalTO_btn;

        @FXML
        private DatePicker ms_date;

        @FXML
        private TextField ms_id;

        @FXML
        private Button notice_btn;

        @FXML
        private Pane stage1;

        @FXML
        private Pane stage2;

        @FXML
        private Pane stage3;

        @FXML
        private Pane stage4;

        @FXML
        private Pane stage5;

        @FXML
        private Button timetable_btn;

        @FXML
        private Button update_att_btn;

    @FXML
    private ImageView profile_img;

    @FXML
    private ImageView profile_img_edit;

        @FXML
        void SecondswitchPage(ActionEvent event) {

        }

        @FXML
        void UserMedicalAccountDetailsSave(ActionEvent event) {

        }

        @FXML
        void add_medical(ActionEvent event) {

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

        @FXML
        void md_tableRowHandle(MouseEvent event) {

        }

        @FXML
        void medical_delete(ActionEvent event) {

        }

        @FXML
        void medical_update(ActionEvent event) {

        }

    @FXML
    void switchPage(ActionEvent event) {
        if (event.getSource() == details_btn) {
            System.out.println("Details button pressed");
            stage1.setVisible(true);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(false);
            stage5.setVisible(false);
            showUserDetails();
            SetAttprofileName();

        } else if (event.getSource() == edit_btn) {
            System.out.println("Edit button pressed");
            stage1.setVisible(false);
            stage2.setVisible(true);
            stage3.setVisible(false);
            stage4.setVisible(false);
            stage5.setVisible(false);


        } else if (event.getSource() == attendence_btn) {
            System.out.println("UserDetails button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(true);
            stage4.setVisible(false);
            stage5.setVisible(false);

        } else if (event.getSource() == notice_btn) {
            System.out.println("MedicalTONotice button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(true);
            stage5.setVisible(false);

        } else if (event.getSource() == timetable_btn) {
            System.out.println("Time Table button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(false);
            stage5.setVisible(true);

        }

    }

    @FXML
    private TableView<Medical> medicalTable;

    @FXML
    private ToggleGroup medRadioBtn;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Course_code;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Date;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Reg_No;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Session_type;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Status;

    @FXML
    private TableColumn<Attendence, String> _Attendence_Student_ID;

    //Attendence_TO_Notice

    @FXML
    private TableView<AttendenceTONotice> AttnoticTable;

    @FXML
    private TableColumn<AttendenceTONotice, String> att_n_date;

    @FXML
    private TableColumn<AttendenceTONotice, String> att_n_description;

    @FXML
    private TableColumn<AttendenceTONotice, String> att_n_id;

    @FXML
    private TableColumn<AttendenceTONotice, String> att_n_title;

    @FXML
    private ToggleGroup medEditRadioBtn;

    @FXML
    private ComboBox<String> TimeTableLevelComboBoxBtn;

    @FXML
    private ComboBox<String> TimeTableSemesterComboBoxBtn;

    @FXML
    private ComboBox<String> TimeTableDepartmentComboBoxBtn;

    @FXML
    private ComboBox<String> Attendence_Status;

    @FXML
    private ComboBox<String> Attendence_Stype;

    @FXML
    private TextField Attendence_stdID;

    @FXML
    private TableView<Attendence> Attendence_table;

    @FXML
    private Button clear_attendence_btn;

    @FXML
    private Text profile_name;

    @FXML
    private Button confirmMedicalBtn;

    @FXML
    private TableColumn<MedicalAttendance, String> colCourseCode;

    @FXML
    private TableColumn<MedicalAttendance, String> colEDate;

    @FXML
    private TableColumn<MedicalAttendance, String> colMedicalId;

    @FXML
    private TableColumn<MedicalAttendance, String> colSDate;

    @FXML
    private TableColumn<MedicalAttendance, String> colStudentId;

    @FXML
    private TableView<MedicalAttendance> medicalAttendanceTable;

    ObservableList<MedicalAttendance> medicalAttendanceList = FXCollections.observableArrayList();

    //______________________Attendence_TO_details_________________________

    public ObservableList<UserDetails> getAttendanceUserDetails() {
        ObservableList<UserDetails> List = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String toSql = "SELECT * \n" +
                "FROM technical_officer t \n" +
                "JOIN user u ON t.tech_officer_id = u.userId \n" +
                "LEFT JOIN user_contact uc ON u.userId = uc.userId \n" +
                "INNER JOIN department d ON d.dep_id = t.dep_id \n" +
                "WHERE u.userId = '"+userName+"'";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(toSql);
            UserDetails ud;
            while(rs.next()){
                ud = new UserDetails(
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("userId"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getString("nic"),
                        rs.getString("bod"),
                        rs.getString("role"),
                        rs.getString("dep_name")
                );
                List.add(ud);
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return List;
    }
    public void showUserDetails(){
        ObservableList<UserDetails> List = getAttendanceUserDetails();
        UserDetails ud = List.get(0);
        _attFname.setText(ud.getAttFname());
        _attLname.setText(ud.getAttLname());
        _attId.setText(ud.getAttOfficer_id());
        _attEmail.setText(ud.getAttEmail());
        _attAddress.setText(ud.getAttAddress());
        _attMale.setSelected(ud.getAttGender().equals("M"));
        _attFemale.setSelected(ud.getAttGender().equals("F"));
        _attNIC.setText(ud.getAttNIC());
        _attBirthday.setValue(LocalDate.parse(ud.getAttBod()));
        _attRole.setText(ud.getAttRole());
        _attDepartmentName.setText(ud.getAttDname());
    }

    //____________Attendence_TO_Edite_details________

    public ObservableList<UserEditDetails> getUserEditDetails() {
        ObservableList<UserEditDetails> EList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String Sql = "SELECT * \n" +
                "FROM technical_officer t \n" +
                "JOIN user u ON t.tech_officer_id = u.userId \n" +
                "LEFT JOIN user_contact uc ON u.userId = uc.userId \n" +
                "INNER JOIN department d ON d.dep_id = t.dep_id \n" +
                "WHERE t.role = 'attendance officer';\n";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(Sql);
            UserEditDetails Eud;
            while(rs.next()){
                Eud = new UserEditDetails(
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("userId"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("gender"),
                        rs.getString("nic"),
                        rs.getString("bod"),
                        rs.getString("role"),
                        rs.getString("dep_name")
                );
                EList.add(Eud);
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return EList;
    }
    public void showUserEditDetails(){
        ObservableList<UserEditDetails> EList = getUserEditDetails();
        UserEditDetails Eud = EList.get(0);
        _attEditFname.setText(Eud.getAttEditFname());
        _attEditLname.setText(Eud.getAttEditLname());
        _attEditOfficerId.setText(Eud.getAttEditOfficer_id());
        _attEditEmail.setText(Eud.getAttEditEmail());
        _attEditAddress.setText(Eud.getAttEditAddress());
        _attEditMale.setSelected(Eud.getAttEditGender().equals("M"));
        _attEditFemale.setSelected(Eud.getAttEditGender().equals("F"));
        _attEditNIC.setText(Eud.getAttEditNIC());
        _attEditBOD.setValue(LocalDate.parse(Eud.getAttEditBod()));
        _attEditRole.setText(Eud.getAttEditRole());
        _attEditDepartmentName.setText(Eud.getAttEditDname());
    }


    @FXML
    void UserAccountDetailsSave(ActionEvent event) {
        Connection conn = Config.getConfig();
        String attEditOfficer_id = _attEditOfficerId.getText();

        String sql = "UPDATE user SET f_name = ?, l_name = ?, email = ?, address = ? WHERE userId = ?";
        try{
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(1, _attEditFname.getText());
            sp.setString(2, _attEditLname.getText());
            sp.setString(3, _attEditEmail.getText());
            sp.setString(4, _attEditAddress.getText());
            sp.setString(5,userName);
            sp.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Tech Officer Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Tech Officer '" + attEditOfficer_id + "' updated successfully!");
            updatedAlert.showAndWait();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }


    //_____________________Attendence_________________

    public ObservableList<Attendence> getAttendence(){
        ObservableList<Attendence> list = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM attendence";
        Statement st = null;
        ResultSet rs = null;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Attendence att ;
            while(rs.next()){
                att = new Attendence(
                        rs.getInt("att_state_id"),
                        rs.getString("date"),
                        rs.getString("att_state"),
                        rs.getString("session_type"),
                        rs.getString("student_id"),
                        rs.getString("course_code"),
                        rs.getString("tech_officer_id")

                );
                list.add(att);
               //System.out.println(rs.getString("course_code"));
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
        return list;
    }

    public void showAttendenceToTable(){
        ObservableList<Attendence> list = getAttendence();

        _Attendence_Date.setCellValueFactory(new PropertyValueFactory<>("attendance_date"));
        _Attendence_Session_type.setCellValueFactory(new PropertyValueFactory<Attendence,String>("attendance_SessionType"));
        _Attendence_Student_ID.setCellValueFactory(new PropertyValueFactory<Attendence,String>("attendance_student_id"));
        _Attendence_Course_code.setCellValueFactory(new PropertyValueFactory<>("attendance_course_code"));
        _Attendence_Status.setCellValueFactory(new PropertyValueFactory<Attendence,String>("attendance_status"));

        Attendence_table.setItems(list);
    }

    @FXML
    void AddAttendenceDetails(ActionEvent event) {
        Connection conn = Config.getConfig();
        String attendance_date = Attendence_Date.getValue() != null ? Attendence_Date.getValue().toString() : null;
        String attendance_session_type = Attendence_Stype.getValue();
        String attendance_student_id = Attendence_stdID.getText();
        String attendance_course_code = Attendence_Ccode.getText();
        String attendance_status = Attendence_Status.getValue();
        String attendance_tech_officer_id = userName;

        if (
                attendance_date == null
                || attendance_session_type.isEmpty()
                || attendance_student_id.isEmpty()
                || attendance_course_code.isEmpty()
                || attendance_status.isEmpty()) {

            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }
//ALTER TABLE attendence ADD COLUMN att_state_id INT AUTO_INCREMENT PRIMARY KEY FIRST;
        String sql = "INSERT INTO attendence(date,session_type,student_id ,course_code ,att_state,tech_officer_id) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement at = conn.prepareStatement(sql);
            at.setString(1, attendance_date);
            at.setString(2, attendance_session_type);
            at.setString(3, attendance_student_id);
            at.setString(4, attendance_course_code);
            at.setString(5, attendance_status);
            at.setString(6, attendance_tech_officer_id);

            at.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Attendance Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Attendance Added Successfully!");
            successAlert.showAndWait();


        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        showAttendenceToTable();
    }

    @FXML
    void att_tableRowHandle(MouseEvent event) {
        Attendence list =  Attendence_table.getSelectionModel().getSelectedItem();
        Attendence_ID.setText(String.valueOf(list.getAttendance_id()));
        Attendence_stdID.setText(String.valueOf(list.getAttendance_student_id()));
        Attendence_Date.setValue(LocalDate.parse(list.getAttendance_date()));
        Attendence_Status.setValue(list.getAttendance_status());
        Attendence_Stype.setValue(String.valueOf(list.getAttendance_SessionType()));
        Attendence_Ccode.setText(String.valueOf(list.getAttendance_course_code()));
    }

    @FXML
    void updateAttendenceBtn(ActionEvent event) {
        Connection conn = Config.getConfig();
        String att_state_id = Attendence_ID.getText();

        String sql = "UPDATE attendence SET date = ?, att_state = ?, session_type = ?, student_id = ?, course_code = ? WHERE att_state_id = ?";
        try{
            PreparedStatement sp = conn.prepareStatement(sql);

            sp.setString(1, Attendence_Date.getValue() != null ? Attendence_Date.getValue().toString() : null);
            sp.setString(2, Attendence_Status.getValue());
            sp.setString(3, Attendence_Stype.getValue());
            sp.setString(4, Attendence_stdID.getText());
            sp.setString(5, Attendence_Ccode.getText());
            sp.setString(6, att_state_id);
            sp.executeUpdate();



            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Attencdence Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Attendence '" + Attendence_ID + "' updated successfully!");
            updatedAlert.showAndWait();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        showAttendenceToTable();
    }

    @FXML
    void deleteAttendenceBtn(ActionEvent event) {
        Connection conn = Config.getConfig();
        String att_state_id = Attendence_ID.getText();

        String sql = "DELETE FROM attendence WHERE att_state_id  = ?";

        try{
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(1, att_state_id);
            sp.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        showAttendenceToTable();
    }

    @FXML
    void clearAttendenceBtn(ActionEvent event) {
        Attendence_stdID.setText("");
        Attendence_Date.setValue(null);
        Attendence_Status.setValue(null);
        Attendence_Stype.setValue(null);
        Attendence_Ccode.setText("");
        Attendence_ID.setText("");
    }


    public String AttendenceStatusType(){
        ObservableList<String> departmentTypeList = FXCollections.observableArrayList("Present","Absent");
        Attendence_Status.setItems(departmentTypeList);
        return String.valueOf(departmentTypeList);
    }
    public String AttendenceSessionType(){
        ObservableList<String> List = FXCollections.observableArrayList("Theory","Practical");
        Attendence_Stype.setItems(List);
        return String.valueOf(List);
    }

    //________________Attendence Medical Approval Part_______

    public ObservableList<MedicalAttendance> getMedicalAttendance(){
        ObservableList<MedicalAttendance> list = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM medical";
        Statement st = null;
        ResultSet rs = null;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            MedicalAttendance md ;
            while(rs.next()){
                md = new MedicalAttendance(
                        rs.getString("student_id"),
                        rs.getString("medical_id"),
                        rs.getString("course_code"),
                        new java.util.Date(rs.getDate("s_date").getTime()),
                        new java.util.Date(rs.getDate("e_date").getTime()),
                        rs.getString("description"),
                        rs.getString("tech_officer_id"),
                        rs.getString("m_report_path")
                );
                list.add(md);
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
        return list;
    }

    public void showMedicalToTable(){
        ObservableList<MedicalAttendance> list = getMedicalAttendance();
        colMedicalId.setCellValueFactory(new PropertyValueFactory<MedicalAttendance,String>("medical_id"));
        colCourseCode.setCellValueFactory(new PropertyValueFactory<MedicalAttendance,String>("course_code"));
        colStudentId.setCellValueFactory(new PropertyValueFactory<MedicalAttendance,String>("student_id"));
        colSDate.setCellValueFactory(new PropertyValueFactory<>("s_date"));
        colEDate.setCellValueFactory(new PropertyValueFactory<>("e_date"));


        medicalAttendanceTable.setItems(list);
    }


    @FXML
    void confirmMedical(ActionEvent event) {
        MedicalAttendance selectedMedical = medicalAttendanceTable.getSelectionModel().getSelectedItem();

            if (selectedMedical != null) {
                Connection conn = Config.getConfig();

                String studentId = selectedMedical.getStudent_id();
                String courseCode = selectedMedical.getCourse_code();
                Date startDate = selectedMedical.getS_date();
                Date endDate = selectedMedical.getE_date();

                String sql = "UPDATE attendence " +
                        "SET att_state = 'Medical' " +
                        "WHERE student_id = ? " +
                        "AND course_code = ? " +
                        "AND date BETWEEN ? AND ? " +
                        "AND att_state = 'Absent'";

                try {
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, studentId);
                    ps.setString(2, courseCode);
                    ps.setDate(3, new java.sql.Date(startDate.getTime()));
                    ps.setDate(4, new java.sql.Date(endDate.getTime()));

                    int updatedRows = ps.executeUpdate();

                    if (updatedRows > 0) {
                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                        successAlert.setTitle("Success");
                        successAlert.setHeaderText(null);
                        successAlert.setContentText("Medical Approved Successfully! (" + updatedRows + " records updated)");
                        successAlert.showAndWait();
                    } else {
                        Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                        errorAlert.setTitle("Warning");
                        errorAlert.setHeaderText(null);
                        errorAlert.setContentText("No absent records found to update.");
                        errorAlert.showAndWait();
                    }

                    // Refresh the table after update
                   // loadJoinMedicalAttendanceOnlyAbsent();

                } catch (SQLException e) {
                    System.out.println("Error Approving Medical: " + e.getMessage());
                }
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("No Selection");
                errorAlert.setHeaderText(null);
                errorAlert.setContentText("Please select a medical record to approve!");
                errorAlert.showAndWait();
            }
        showMedicalToTable();
        }

    @FXML
    void medicalattendenceevent(MouseEvent event) {

    }

    //_________________Attendence_TO_Notice_______________

    public ObservableList<AttendenceTONotice> getNotice(){
        ObservableList<AttendenceTONotice> list = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM notice";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            AttendenceTONotice Attn;
            while(rs.next()){
                Attn = new AttendenceTONotice(
                        rs.getString("notice_id"),
                        rs.getDate("date").toString(),
                        rs.getString("notice_title"),
                        rs.getString("description")
                );
                list.add(Attn);
                //System.out.println(list);
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
        return list;
    }

    public void showAttendenceNoticeToTable(){
        ObservableList<AttendenceTONotice> list = getNotice();
        att_n_id.setCellValueFactory(new PropertyValueFactory<AttendenceTONotice, String>("notice_id"));
        att_n_date.setCellValueFactory(new PropertyValueFactory<AttendenceTONotice, String>("notice_date"));
        att_n_title.setCellValueFactory(new PropertyValueFactory<AttendenceTONotice,String>("notice_title"));
        att_n_description.setCellValueFactory(new PropertyValueFactory<AttendenceTONotice,String>("notice_descr"));
        AttnoticTable.setItems(list);
    }

    //______________________ Time table ____________

    @FXML
    void TimetableDetailsfind(ActionEvent event) {
        loadAttTimeTableImage();
    }

    public String AttlevelType(){
        ObservableList<String> List = FXCollections.observableArrayList("Level 1","Level 2","Level 3","Level 4");
        TimeTableLevelComboBoxBtn.setItems(List);
        return String.valueOf(List);
    }
    public String AttsemsterType(){
        ObservableList<String> List = FXCollections.observableArrayList("Semester 1","Semester 2");
        TimeTableSemesterComboBoxBtn.setItems(List);
        return String.valueOf(List);
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
    public void setAttdepartmentType(){
        ObservableList<String> dep = getDepartmentNameList();
        TimeTableDepartmentComboBoxBtn.setItems(dep);
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



    public void loadAttTimeTableImage() {
        String level = TimeTableLevelComboBoxBtn.getValue();
        String semester = TimeTableSemesterComboBoxBtn.getValue();
        Object DepName = TimeTableDepartmentComboBoxBtn.getSelectionModel().getSelectedItem();
        String ld = setDepId(DepName);
        try {
            Connection con = Config.getConfig();


            if (DepName == null || level == null || semester == null) {
                return;
            }

            String sql = "SELECT pdf_path FROM timetable WHERE dep_id = ? AND level = ? AND semester = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ld);
            ps.setString(2, level);
            ps.setString(3, semester);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String pdfPath = rs.getString("pdf_path");
                if (pdfPath != null && !pdfPath.isEmpty()) {
                    File imageFile = new File(pdfPath);
                    if (imageFile.exists()) {
                        Image img = new Image(imageFile.toURI().toString());
                        imgView.setImage(img);
                    } else {System.out.println("Image file not found at: " + pdfPath);
                    }
                } else {
                    System.out.println("No image path found in database.");
                }
            } else {
                System.out.println("No timetable found for selected options.");
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error loading timetable image: " + e.getMessage());
        }
    }

    //---------------profile edite----------------

    @FXML
    private File selectedFile;

    @FXML
    void edite_imgeBtn_profile(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Connection con = null;
            try {
                con = Config.getConfig();

                File uploadDir = new File("upload");
                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                File destFile = new File(uploadDir, selectedFile.getName());
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copied to: " + destFile);

                profile_img.setImage(new Image(destFile.toURI().toString()));

                 // your target user ID
                String filePath = String.valueOf(destFile); // get full path

                // Check if user already has a photo
                String checkSql = "SELECT user_img FROM user WHERE userId = ?";
                PreparedStatement checkPs = con.prepareStatement(checkSql);
                checkPs.setString(1, userName);
                ResultSet rs = checkPs.executeQuery();

                if (rs.next()) {
                    // update photo
                    String updateSql = "UPDATE user SET user_img = ? WHERE userId = ?";
                    PreparedStatement updatePs = con.prepareStatement(updateSql);
                    updatePs.setString(1, filePath);
                    updatePs.setString(2, userName);
                    updatePs.executeUpdate();
                    updatePs.close();
                } else {
                    // insert new user + photo
                    String insertSql = "INSERT INTO user (userId, user_img) VALUES (?, ?)";
                    PreparedStatement insertPs = con.prepareStatement(insertSql);
                    insertPs.setString(1, userName);
                    insertPs.setString(2, filePath);
                    insertPs.executeUpdate();
                    insertPs.close();
                }

                rs.close();
                checkPs.close();
            } catch (Exception e) {
                System.out.println("Error handling profile photo: " + e.getMessage());
            } finally {
                try {
                    if (con != null) con.close();
                } catch (Exception ex) {
                    System.out.println("Error closing connection: " + ex.getMessage());
                }
            }
        }
    }


    public void loadAttUserImage(String userId) {
        Connection con = null;
        try {
            con = Config.getConfig();
            String sql = "SELECT user_img FROM user WHERE userId = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String user_img = rs.getString("user_img");
                if (user_img != null && !user_img.isEmpty()) {
                    File imageFile = new File(user_img);
                    if (imageFile.exists()) {
                        Image img = new Image(imageFile.toURI().toString());
                        profile_img.setImage(img);
                    } else {
                        System.out.println("Image file not found: " + user_img);
                    }
                } else {
                    System.out.println("No image path in database.");
                }
            } else {
                System.out.println("No user found with ID: " + userId);
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error loading user image: " + e.getMessage());
        }
    }

    //_______________profile name_______________



    private ObservableList<ProfileName> getProfileName() {
        ObservableList<ProfileName> profileNameList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = Config.getConfig();
            String sql = "select * from user WHERE userId = '"+userName+"'";
            Statement st;
            ResultSet rs;

            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                ProfileName profileName;

                while (rs.next()) {
                    profileName = new ProfileName(
                            rs.getString("f_name"),
                            rs.getString("l_name")
                    );

                    profileNameList.add(profileName);
                }
                return profileNameList;
            } catch (Exception e) {
                System.out.println("error: " + e.getMessage());
            }
        } finally {

        }
        return profileNameList;
        }

    public void SetAttprofileName(){
        ObservableList<ProfileName> stuList = getProfileName();
        ProfileName stu = stuList.get(0);
        profile_name.setText(stu.getAttFullName() );
    }

        @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showUserDetails();
        showUserEditDetails();
        showAttendenceNoticeToTable();
        AttlevelType();
        AttsemsterType();
        AttendenceStatusType();
        AttendenceSessionType();
        getAttendence();
        showAttendenceToTable();
        loadAttUserImage(userName);
        SetAttprofileName();
        setAttdepartmentType();
        showMedicalToTable();
    }
}