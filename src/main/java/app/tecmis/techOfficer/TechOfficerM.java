package app.tecmis.techOfficer;

import app.tecmis.App;
import app.tecmis.LoginController;
import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class TechOfficerM implements Initializable {

    public static String userName = LoginController.techOfficerTg;

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
    private TableView<?> AttnoticTable;

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
    private ToggleGroup attRadioBtn;

    @FXML
    private TableColumn<?, ?> att_n_date;

    @FXML
    private TableColumn<?, ?> att_n_description;

    @FXML
    private TableColumn<?, ?> att_n_id;

    @FXML
    private TableColumn<?, ?> att_n_title;

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

    @FXML
    private Button attendence_btn;

    @FXML
    private Pane attendence_stage2;

    @FXML
    private Button details_btn;

    @FXML
    private Button edit_btn;

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
    private ToggleGroup medEditRadioBtn;

    @FXML
    private ToggleGroup medRadioBtn;

    @FXML
    private Button medicalTO_btn;

    @FXML
    private TableView<Medical> medicalTable;

    @FXML
    private DatePicker ms_date;

    @FXML
    private TextField ms_id;

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
    private Pane secondStage5;

    @FXML
    private Button submit_attendence_btn;

    @FXML
    private Button submit_attendence_btn1;

    @FXML
    private Button submit_attendence_btn11;

    @FXML
    private Button timetable_btn;


    @FXML
    private ComboBox<String> MedicalTimeTableDepartmentComboBoxBtn;

    @FXML
    private ComboBox<String> MedicalTimeTableLevelComboBoxBtn;

    @FXML
    private ComboBox<String> MedicalTimeTableSemesterComboBoxBtn;

    @FXML
    private Button Medical_TimeTable_btn;

    @FXML
    private ImageView MedicalimgView;

    @FXML
    private TextField session_textfield;

    @FXML
    private Button addDocumentmedicalBtn;


    @FXML
    private Text medical_profile_name;

    @FXML
    private List<String> uploadedDocuments = new ArrayList<>();

    @FXML
    void SecondswitchPage(ActionEvent event) {
        if (event.getSource() == Medical_details_btn) {
            System.out.println("Medical details button pressed");
            secondStage1.setVisible(true);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
            secondStage5.setVisible(false);
        } else if (event.getSource() == Medical_edit_btn) {
            System.out.println("Medical edit button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(true);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
            secondStage5.setVisible(false);
        } else if (event.getSource() == Medical_btn) {
            System.out.println("Medical button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(true);
            secondstage4.setVisible(false);
            secondStage5.setVisible(false);
        } else if (event.getSource() == Medical_notice_btn) {
            System.out.println("Medical notice button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(true);
            secondStage5.setVisible(false);
        } else if (event.getSource() == Medical_TimeTable_btn){
            System.out.println("Medical Time Table button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
            secondStage5.setVisible(true);
        }

    }

    @FXML
    void UserAccountDetailsSave(ActionEvent event) {

    }


    @FXML
    void submitAttendenceBtn(ActionEvent event) {

    }

    @FXML
    void switchPage(ActionEvent event) {

    }

    //_________________ Profile Edite ____________

    @FXML
    private File selectedFile;


    @FXML
    private ImageView medicalProfilepic;

    @FXML
    void EditeMedicalProfile(MouseEvent event) {
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

                medicalProfilepic.setImage(new Image(destFile.toURI().toString()));

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


    public void loadMedUserImage(String userId) {
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
                        medicalProfilepic.setImage(img);
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

    //__________ profile name ___________

    private ObservableList<ProfileNameMed> getProfileNameMed() {
        ObservableList<ProfileNameMed> profileNameList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = Config.getConfig();
            String sql = "select * from user WHERE userId = '"+userName+"'";
            Statement st;
            ResultSet rs;

            try {
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                ProfileNameMed profileNamemed;

                while (rs.next()) {
                    profileNamemed = new ProfileNameMed(
                            rs.getString("f_name"),
                            rs.getString("l_name")
                    );

                    profileNameList.add(profileNamemed);
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
        ObservableList<ProfileNameMed> stuList = getProfileNameMed();
        ProfileNameMed stu = stuList.get(0);
        medical_profile_name.setText(stu.getMedFullName() );
    }

    //________________Medical_TO_details___________________

    public ObservableList<UserMedDetails> getMedicalUserDetails() {
        ObservableList<UserMedDetails> List = FXCollections.observableArrayList();
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
                "WHERE t.role = 'medical officer';\n";
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
        String m_report_path = String.join(",", uploadedDocuments);
        String tech_officer_id = userName;

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

        String sql = "INSERT INTO medical(medical_id ,student_id ,course_code,s_date,e_date,description,tech_officer_id,m_report_path ) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement sp = conn.prepareStatement(sql);
            sp.setString(2, medical_id);
            sp.setString(1, student_id);
            sp.setString(3, course_code);
            sp.setDate(4, java.sql.Date.valueOf(sDate));
            sp.setDate(5, java.sql.Date.valueOf(eDate));
            sp.setString(6, description);
            sp.setString(7, tech_officer_id);
            sp.setString(8, m_report_path);

            sp.executeUpdate();

            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Medical Details Added");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Medical '" + medical_id + "'added successfully!");
            successAlert.showAndWait();



        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        showMedicalToTable();
    }

    @FXML
    void addDocumentmedical(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF Files");

        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf");
        fileChooser.getExtensionFilters().add(extFilter);

        List<File> selectedFiles = fileChooser.showOpenMultipleDialog(null);

        if (selectedFiles != null) {
            File uploadDir = new File("upload");
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            for (File file : selectedFiles) {
                try {
                    File destFile = new File(uploadDir, file.getName());
                    Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    String relativePath = File.separator + "upload" + File.separator + file.getName();
                    uploadedDocuments.add(relativePath);  // Save the path to the list

                    System.out.println("Uploaded: " + relativePath);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Upload Successful");
            alert.setHeaderText(null);
            alert.setContentText("Selected documents uploaded successfully.");
            alert.showAndWait();
        }
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

    //____________________Time Table_________

    @FXML
    void MedicalTimetableDetailsfind(ActionEvent event) {
        loadTimeImage();
    }

    public String MlevelType(){
        ObservableList<String> List = FXCollections.observableArrayList("Level 1","Level 2","Level 3","Level 4");
        MedicalTimeTableLevelComboBoxBtn.setItems(List);
        return String.valueOf(List);
        }
        public String MsemsterType(){
            ObservableList<String> List = FXCollections.observableArrayList("Semester 1","Semester 2");
            MedicalTimeTableSemesterComboBoxBtn.setItems(List);
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
        public void setMdepartmentType(){
            ObservableList<String> dep = getDepartmentNameList();
            MedicalTimeTableDepartmentComboBoxBtn.setItems(dep);
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



        public void loadTimeImage() {
            String level = MedicalTimeTableLevelComboBoxBtn.getValue();
            String semester = MedicalTimeTableSemesterComboBoxBtn.getValue();
            Object DepName = MedicalTimeTableDepartmentComboBoxBtn.getSelectionModel().getSelectedItem();
            String ld = setDepId(DepName);
            try {
                Connection con = Config.getConfig();

                if (DepName == null || level == null || semester == null) {
                    System.out.println("Please select department, level, and semester first!");
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
                            MedicalimgView.setImage(img);
                        } else {System.out.println("Image file not found at: " + pdfPath);
                        }
                    } else {
                        System.out.println("No image path found in database.");
                    }
                } else {
                    System.out.println("No timetable found for selected options."); // Only happens if no record is matched
                }

                rs.close();
                ps.close();
            } catch (Exception e) {
                System.out.println("Error loading timetable image: " + e.getMessage());
            }
        }


    @FXML
    void logOutBtn(ActionEvent event) {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root, 700,450));
            stage.show();
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.close();
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showMedicalToTable();
        showMedicalNoticesToTable();
        showMedicalUserDetails();
        showMedUserEditDetails();
        MlevelType();
        MsemsterType();
        setMdepartmentType();
        loadTimeImage();
        loadMedUserImage(userName);
        SetAttprofileName();
    }
}
