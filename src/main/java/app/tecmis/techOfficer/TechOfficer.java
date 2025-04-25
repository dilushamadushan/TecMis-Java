package app.tecmis.techOfficer;

import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class TechOfficer implements Initializable {

    @FXML
    private Button logout;

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
    private Button attendence_btn;

    @FXML
    private Pane attendence_stage2;

    @FXML
    private Button details_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private Button logout_btn1;

    @FXML
    private AnchorPane main_page1;

    @FXML
    private Button notice_btn;

    @FXML
    private Pane secondStage1;

    @FXML
    private Pane secondStage2;

    @FXML
    private Pane secondStage3;

    @FXML
    private Pane secondstage4;

    @FXML
    private Pane stage1;

    @FXML
    private Pane stage2;

    @FXML
    private Pane stage3;

    @FXML
    private Pane stage4;

    @FXML
    private Button submit_attendence_btn;

    @FXML
    private Button submit_attendence_btn1;

    @FXML
    private Button submit_attendence_btn11;

    @FXML
    void submitAttendenceBtn(ActionEvent event) {

    }

    @FXML
    void SecondswitchPage(ActionEvent event) {
        if (event.getSource() == Medical_details_btn) {
            System.out.println("Medical details button pressed");
            secondStage1.setVisible(true);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
        } else if (event.getSource() == Medical_edit_btn) {
            System.out.println("Medical edit button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(true);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
        } else if (event.getSource() == Medical_btn) {
            System.out.println("Medical button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(true);
            secondstage4.setVisible(false);
        } else if (event.getSource() == Medical_notice_btn) {
            System.out.println("Medical notice button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(true);
        }

    }

    @FXML
    void switchPage(ActionEvent event) {
        if (event.getSource() == details_btn) {
            System.out.println("Details button pressed");
            stage1.setVisible(true);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(false);

        } else if (event.getSource() == edit_btn) {
            System.out.println("Edit button pressed");
            stage1.setVisible(false);
            stage2.setVisible(true);
            stage3.setVisible(false);
            stage4.setVisible(false);


        } else if (event.getSource() == attendence_btn) {
            System.out.println("UserDetails button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(true);
            stage4.setVisible(false);

        } else if (event.getSource() == notice_btn) {
            System.out.println("MedicalTONotice button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(true);
        }

    }

    //medical

    @FXML
    private TableColumn<Medical, String> _mCCode;

    @FXML
    private TableColumn<Medical, String> _mDescription;

    @FXML
    private TableColumn<Medical, Date> _mEDate;

    @FXML
    private TableColumn<Medical, String> _mId;

    @FXML
    private TableColumn<Medical, Date> _msDate;

    @FXML
    private TableColumn<Medical, String> _msId;

    @FXML
    private TextField m_course;

    @FXML
    private TextField m_id;

    @FXML
    private TextArea m_reasone;

    @FXML
    private DatePicker me_date;

    @FXML
    private TableView<Medical> medicalTable;

    @FXML
    private DatePicker ms_date;

    @FXML
    private TextField ms_id;

    //MedicalTONotice
    @FXML
    private TableColumn<MedicalTONotice, String> n_date;

    @FXML
    private TableColumn<MedicalTONotice, String> n_description;

    @FXML
    private TableColumn<MedicalTONotice, String> n_id;

    @FXML
    private TableColumn<MedicalTONotice, String> n_title;

    @FXML
    private TableView<MedicalTONotice> noticTable;

    //UserDetails

    @FXML
    private TextArea _attAddress;

    @FXML
    private DatePicker _attBirthday;

    @FXML
    private TextField _attDepartmentName;

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
    private TextArea _attEditAddress;

    @FXML
    private DatePicker _attEditBOD;

    @FXML
    private TextField _attEditDepartmentName;

    @FXML
    private TextField _attEditEmail;

    @FXML
    private TextField _attEditFname;

    @FXML
    private TextField _attEditLname;

    @FXML
    private TextField _attEditNIC;

    @FXML
    private TextField _attEditOfficerId;

    @FXML
    private TextField _attEditRole;

    @FXML
    private RadioButton _attEditMale;

    @FXML
    private RadioButton _attEditFemale;

    @FXML
    private Button Details_save_btn;

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

    //MedicalDetails

    @FXML
    private TextArea _medAddress;

    @FXML
    private DatePicker _medBOD;

    @FXML
    private TextField _medDname;

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

    //MedicalEditeDetails
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
    private DatePicker _medBirthday;

    @FXML
    private Button medicalTO_btn;

    @FXML
    private ToggleGroup attRadioBtn;

    @FXML
    private ToggleGroup EditattRadioBtn;



    //________________Medical_TO_details___________________
    public ObservableList<UserMedDetails> getMedicalUserDetails() {
        ObservableList<UserMedDetails> List = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String toSql = "SELECT * \n" +
                "FROM technical_officer t \n" +
                "JOIN user u ON t.tech_officer_id = u.userId \n" +
                "LEFT JOIN user_contact uc ON u.userId = uc.userId \n" +
                "INNER JOIN department d ON d.dep_id = t.dep_id \n" +
                "WHERE t.role = 'Medical officer';\n";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(toSql);
            UserMedDetails ud;
            while(rs.next()){
                ud = new UserMedDetails(
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
    public void showMedicalUserDetails(){
        ObservableList<UserMedDetails> List = getMedicalUserDetails();
        UserMedDetails mud = List.get(0);
        _medFname.setText(mud.getMed_Fname());
        _medLname.setText(mud.getMed_Lname());
        _medId.setText(mud.getMed_Officer_id());
        _medEmail.setText(mud.getMed_Email());
        _medAddress.setText(mud.getMed_Address());
        _medMale.setSelected(mud.getMed_Gender().equals("M"));
        _medFemale.setSelected(mud.getMed_Gender().equals("F"));
        _medNIC.setText(mud.getMed_NIC());
        _medBOD.setValue(LocalDate.parse(mud.getMed_Bod()));
        _medRole.setText(mud.getMed_Role());
        _medDname.setText(mud.getMed_Dname());
    }

    //______________Medical_TO_Edite_details__________________

    public ObservableList<UserMedEditeDetails> getUserMedEditeDetails() {
        ObservableList<UserMedEditeDetails> EList = FXCollections.observableArrayList();
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
            UserMedEditeDetails Eud;
            while(rs.next()){
                Eud = new UserMedEditeDetails(
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
    public void showMedUserEditDetails(){
        ObservableList<UserMedEditeDetails> EList = getUserMedEditeDetails();
        UserMedEditeDetails Eud = EList.get(0);
        _medEditFname.setText(Eud.getMedEditFname());
        _medEditLname.setText(Eud.getMedEditLname());
        _medEditOfficerId.setText(Eud.getMedEditOfficer_id());
        _medEditEmail.setText(Eud.getMedEditEmail());
        _medEditAddress.setText(Eud.getMedEditAddress());
        _medEditMale.setSelected(Eud.getMedEditGender().equals("M"));
        _medEditFemale.setSelected(Eud.getMedEditGender().equals("F"));
        _medEditNIC.setText(Eud.getMedEditNIC());
        _medBirthday.setValue(LocalDate.parse(Eud.getMedEditBod()));
        _medEditRole.setText(Eud.getMedEditRole());
        _medEditDepartmentName.setText(Eud.getMedEditDname());
    }


    @FXML
    void UserMedicalAccountDetailsSave(ActionEvent event) {
        Connection conn = Config.getConfig();
        String medEditProOfficer_id = _medEditOfficerId.getText();
        String medEditProEditFname = _medEditFname.getText();
        String medEditProEditLname = _medEditLname.getText();
        String medEditProEditEmail = _medEditEmail.getText();
        String medEditProEditAddress = _medEditAddress.getText();

        String sql = "UPDATE user SET f_name = ?, l_name = ?, email = ?, address = ? WHERE userId = ?";
        try{
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(1, medEditProEditFname);
            sp.setString(2, medEditProEditLname);
            sp.setString(3, medEditProEditEmail);
            sp.setString(4, medEditProEditAddress);
            sp.setString(5, medEditProOfficer_id);
            sp.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Medical Details Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Medical '" + medEditProOfficer_id + "' updated successfully!");
            updatedAlert.showAndWait();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }

    //______________________Attendence_TO_details_________________________

    public ObservableList<UserDetails> getAttendanceUserDetails() {
        ObservableList<UserDetails> List = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String toSql = "SELECT * \n" +
                "FROM technical_officer t \n" +
                "JOIN user u ON t.tech_officer_id = u.userId \n" +
                "LEFT JOIN user_contact uc ON u.userId = uc.userId \n" +
                "INNER JOIN department d ON d.dep_id = t.dep_id \n" +
                "WHERE t.role = 'attendance officer';\n";
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
            sp.setString(5, _attEditOfficerId.getText());
            sp.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture '" + attEditOfficer_id + "' updated successfully!");
            updatedAlert.showAndWait();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }




    // _________________________Medical________________

    public ObservableList<Medical> getMedical(){
        ObservableList<Medical> list = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM medical";
        Statement st = null;
        ResultSet rs = null;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Medical md ;
            while(rs.next()){
                md = new Medical(
                        rs.getString("student_id"),
                        rs.getString("medical_id"),
                        rs.getString("course_code"),
                        rs.getDate("s_date"),
                        rs.getDate("e_date"),
                        rs.getString("description"),
                        rs.getString("tech_officer_id")
                );
                list.add(md);
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
        return list;
    }

    public void showMedicalToTable(){
        ObservableList<Medical> list = getMedical();
        _mId.setCellValueFactory(new PropertyValueFactory<Medical,String>("medical_id"));
        _msId.setCellValueFactory(new PropertyValueFactory<Medical,String>("student_id"));
        _msDate.setCellValueFactory(new PropertyValueFactory<Medical,Date>("s_date"));
        _mEDate.setCellValueFactory(new PropertyValueFactory<Medical,Date>("e_date"));
        _mCCode.setCellValueFactory(new PropertyValueFactory<Medical,String>("course_code"));
        _mDescription.setCellValueFactory(new PropertyValueFactory<Medical,String>("description"));

        medicalTable.setItems(list);
    }

    @FXML
    void add_medical(ActionEvent event) {
        Connection conn = Config.getConfig();

        String student_id = m_id.getText();
        String medical_id = ms_id.getText();
        String course_code = m_course.getText();
        LocalDate sDate = ms_date.getValue();
        LocalDate eDate = me_date.getValue();
        String description = m_reasone.getText();
        String tech_officer_id = "TEC001";

        if (student_id.isEmpty()
                || medical_id.isEmpty()
                || course_code.isEmpty()
                || sDate == null
                || eDate == null) {
            Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
            errorAlert.setTitle("Missing Fields");
            errorAlert.setHeaderText(null);
            errorAlert.setContentText("Please fill in all the required fields before submitting.");
            errorAlert.showAndWait();
            return;
        }

        String sql = "INSERT INTO medical(medical_id ,student_id ,course_code,s_date,e_date,description,tech_officer_id ) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(2, medical_id);
            sp.setString(1, student_id);
            sp.setString(3, course_code);
            sp.setDate(4, java.sql.Date.valueOf(sDate));
            sp.setDate(5, java.sql.Date.valueOf(eDate));
            sp.setString(6, description);
            sp.setString(7, tech_officer_id);

            sp.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Lecture Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Lecture '" + medical_id + "'added successfully!");
            successAlert.showAndWait();



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        showMedicalToTable();
    }

    @FXML
    void medical_delete(ActionEvent event) {
        Connection conn = Config.getConfig();
        String medical_id = m_id.getText();
        String sql = "DELETE FROM medical WHERE medical_id = ?";
        try{
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(1, medical_id);
            sp.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Lecture Deleted");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Lecture '" + medical_id + "'Deleted Successfully!");
            successAlert.showAndWait();

            showMedicalToTable();
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        showMedicalToTable();
    }

    @FXML
    void medical_update(ActionEvent event) {
        Connection conn = Config.getConfig();
        String medical_id = m_id.getText();

        String sql = "UPDATE medical SET student_id = ?, course_code = ?, s_date = ?, e_date = ?, description = ? WHERE medical_id = ?";
        try{
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(1, ms_id.getText());
            sp.setString(2, m_course.getText());
            sp.setDate(3, java.sql.Date.valueOf(ms_date.getValue()));
            sp.setDate(4, java.sql.Date.valueOf(me_date.getValue()));
            sp.setString(5, m_reasone.getText());
            sp.setString(6, medical_id);
            sp.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture '" + medical_id + "' updated successfully!");
            updatedAlert.showAndWait();


        }catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
        showMedicalToTable();
    }

    @FXML
    void md_tableRowHandle(MouseEvent event) {
        Medical list =  medicalTable.getSelectionModel().getSelectedItem();
        m_id.setText(String.valueOf(list.getMedical_id()));
        ms_id.setText(String.valueOf(list.getStudent_id()));
        m_course.setText(String.valueOf(list.getCourse_code()));
        m_reasone.setText(String.valueOf(list.getDescription()));

        String sDate = String.valueOf(list.getS_date());
        String eDate = String.valueOf(list.getE_date());

        ms_date.setValue(LocalDate.parse(sDate));
        me_date.setValue(LocalDate.parse(eDate));
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


    //__________________________Medical_TO_Notice______________

    public ObservableList<MedicalTONotice> getMedicalNotices(){
        ObservableList<MedicalTONotice> list = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM notice";
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            MedicalTONotice nd ;
            while(rs.next()){
                nd = new MedicalTONotice(
                        rs.getString("notice_id"),
                        rs.getDate("date").toString(),
                        rs.getString("notice_title"),
                        rs.getString("description")
                );
                list.add(nd);
                //System.out.println(list);
            }
        } catch (Exception e) {
            System.out.println("error : " + e.getMessage());
        }
        return list;
    }

    public void showMedicalNoticesToTable(){
        ObservableList<MedicalTONotice> list = getMedicalNotices();
        n_id.setCellValueFactory(new PropertyValueFactory<MedicalTONotice, String>("notice_id"));
        n_date.setCellValueFactory(new PropertyValueFactory<MedicalTONotice, String>("notice_date"));
        n_title.setCellValueFactory(new PropertyValueFactory<MedicalTONotice,String>("notice_title"));
        n_description.setCellValueFactory(new PropertyValueFactory<MedicalTONotice,String>("notice_descr"));
        noticTable.setItems(list);
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
    void logOutBtn(ActionEvent event) {
        try{
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicalToTable();
        showMedicalNoticesToTable();
        showUserDetails();
        showUserEditDetails();
        showAttendenceNoticeToTable();
        showMedicalUserDetails();
        showMedUserEditDetails();
    }
}