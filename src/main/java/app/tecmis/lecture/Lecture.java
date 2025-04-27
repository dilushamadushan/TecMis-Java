package app.tecmis.lecture;

import app.tecmis.LoginController;
import app.tecmis.admin.TimeTableDetails;
import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx .scene.layout.Pane;

//profile window

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;


//========================

//notice window
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;


//======================


import java.net.URL;
import java.util.*;
import java.util.Date;


public class Lecture implements Initializable {

    @FXML
    void logoutClick(MouseEvent event) {

    }



    //undergraduate
    @FXML
    private TableView<UndergraduateInformation> Undergraduate_table;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_indexnumber;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_fname;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_lname;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_address;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_email;

    @FXML
    private TableColumn<UndergraduateInformation, String> col_gender;

    @FXML
    private TableColumn<UndergraduateInformation, Date> col_dob;

    String username = LoginController.lecTg;
    public String getPassword() {
        String password = null;

        // SQL query to fetch the password where lec_id matches
        String sql = "SELECT password FROM user WHERE username = ?";

        // Establishing a connection and executing the query
        try (Connection conn = Config.getConfig();  // Assuming Config.getConfig() returns a valid connection
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);  // lec_id (username)

            // Execute the query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    password = rs.getString("password");  // Fetch the password from the result set
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Handle any SQL exceptions
        }

        return password;  // Return the password (or null if not found)
    }



    @FXML
    public String getCourseCode() {
        String course_code = null;
        Connection conn = Config.getConfig();
        // SQL query to fetch the course_code where lec_id matches
        String sql = "SELECT course_code FROM lecture_course WHERE lecture_id = '"+username+"'";
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                course_code = rs.getString("course_code");
            }
            System.out.println(rs.getString("course_code"));
        } catch (Exception e) {
            System.out.println("Exception in getCourseCode: " + e.getMessage());
        }

        return course_code;
    }


        @FXML
    public ObservableList<UndergraduateInformation> getUndergraduate() {
        ObservableList<UndergraduateInformation> undergraduateList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "select * from user WHERE user_type = 'student'";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            UndergraduateInformation undergraduate;

            while (rs.next()) {
                undergraduate = new UndergraduateInformation(
                        rs.getString("userId"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("bod"),
                        rs.getString("address")
                );

                undergraduateList.add(undergraduate);
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        return undergraduateList;
    }

    public void showUndergraduate() {
        ObservableList<UndergraduateInformation> list = getUndergraduate();

        col_indexnumber.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateId"));
        col_fname.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateFname"));
        col_address.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateAddress"));
        col_gender.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateGender"));
        col_dob.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,Date>("undergraduateDob"));
        col_email.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateEmail"));
        col_lname.setCellValueFactory(new PropertyValueFactory<UndergraduateInformation,String>("undergraduateLname"));

        Undergraduate_table.setItems(list);
    }















    //=======================================



    //attandance

    @FXML
    private TextField Text_feild_TGnumber;

    @FXML
    private TableView<Attendance_Information> attandance_table;

    @FXML
    private TableColumn<Attendance_Information, String> col_tgnumber_attandance;

    @FXML
    private TableColumn<Attendance_Information, String> col_date_attandance;

    @FXML
    private TableColumn<Attendance_Information, String> col_theory_practical_attandance;

    @FXML
    private TableColumn<Attendance_Information, String> col_state_attandance;

    // Removed @FXML annotation as this is a data method, not an FXML event handler
    public ObservableList<Attendance_Information> getAttendance() {
        ObservableList<Attendance_Information> attendanceList = FXCollections.observableArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = Config.getConfig();
            String query = "SELECT a.student_id, a.date, a.session_type, a.att_state " +
                    "FROM attendence a " +
                    "JOIN lecture_course lc ON a.course_code = lc.course_code " +
                    "WHERE lc.lecture_id = ?";

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username); // Set the lecture_id parameter

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Attendance_Information attendance = new Attendance_Information(
                        rs.getString("student_id"),
                        rs.getString("date"),
                        rs.getString("session_type"),
                        rs.getString("att_state")
                );

                attendanceList.add(attendance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Simply print stack trace without showing alert
        }
        return attendanceList;
    }

    @FXML
    public void showAttendance() {
        ObservableList<Attendance_Information> list = getAttendance();

        // Fixed PropertyValueFactory to match the actual getter method names in Attendance_Information
        col_tgnumber_attandance.setCellValueFactory(new PropertyValueFactory<>("tg_number"));
        col_date_attandance.setCellValueFactory(new PropertyValueFactory<>("attendance_date"));
        col_theory_practical_attandance.setCellValueFactory(new PropertyValueFactory<>("theory_practical_attendance"));
        col_state_attandance.setCellValueFactory(new PropertyValueFactory<>("status_attendance"));

        // Set the items to display in the table
        attandance_table.setItems(list);
    }



    // medical

    @FXML
    private TableView<Medical_Information> Medical_table;
    @FXML
    private TableColumn<Medical_Information, String> tg_number_medical;
    @FXML
    private TableColumn<Medical_Information, String> description_medical;
    @FXML
    private TableColumn<Medical_Information, String> start_date_medical;
    @FXML
    private TableColumn<Medical_Information, String> end_date_medical;

    @FXML
    private TableColumn<Medical_Information, String> course_medical;

    public ObservableList<Medical_Information> getMedical() {
        ObservableList<Medical_Information> medicalList = FXCollections.observableArrayList();
        Connection conn = conn = Config.getConfig();
        String query = "SELECT student_id, description, s_date, e_date, course_code FROM medical";
        Statement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.createStatement();
            rs = pstmt.executeQuery(query);
            Medical_Information medical;
            while (rs.next()) {
                 medical = new Medical_Information(
                        rs.getString("student_id"),
                        rs.getString("description"),
                        rs.getString("s_date"),
                        rs.getString("e_date"),
                        rs.getString("course_code")
                );
                medicalList.add(medical);
                System.out.println(rs.getString("student_id"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException in getMedical: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in getMedical: " + e.getMessage());
        }
        return medicalList;
    }

    @FXML
    public void showMedical() {
        ObservableList<Medical_Information> list = getMedical();
            // Then set up the table columns
            tg_number_medical.setCellValueFactory(new PropertyValueFactory<>("medical_tg"));
            description_medical.setCellValueFactory(new PropertyValueFactory<>("medical_description"));
            start_date_medical.setCellValueFactory(new PropertyValueFactory<>("medical_start_date"));
            end_date_medical.setCellValueFactory(new PropertyValueFactory<>("medical_end_date"));
            course_medical.setCellValueFactory(new PropertyValueFactory<>("medical_course"));

            // Finally, set the items to display in the table
            Medical_table.setItems(list);
    }

    @FXML
    void attSearchBar(MouseEvent event) {

        attSearch();
        mdicalSearch();
    }

    private void attSearch() {
        FilteredList<Attendance_Information> filter = new FilteredList<>(getAttendance(), e -> true);
        Text_feild_TGnumber.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicate ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicate.getTg_number().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<Attendance_Information> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(attandance_table.comparatorProperty());
        attandance_table.setItems(sortedList);
    }

    private void mdicalSearch() {
        FilteredList<Medical_Information> filter = new FilteredList<>(getMedical(), e -> true);
        Text_feild_TGnumber.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(predicate ->{
                if(newValue == null || newValue.isEmpty()) return true;

                String searchKey = newValue.toLowerCase();

                if (predicate.getMedical_tg().toLowerCase().contains(searchKey)) {
                    return true;
                }else{
                    return false;
                }
            });
        });
        SortedList<Medical_Information> sortedList = new SortedList<>(filter);
        sortedList.comparatorProperty().bind(Medical_table.comparatorProperty());
        Medical_table.setItems(sortedList);
    }


    //========================












    //========================



    //============================================================


//profile
    @FXML
    private TextField user_name_textfeild;
    @FXML
    private TextField password_text_feild;
    @FXML
    private ImageView change_photo_icon;

    @FXML
    private Button edit_profile_btn;

    @FXML
    private Label information_lebal;

    @FXML
    private Label security_lebal;


    @FXML
    private TextField first_name_textfield;

    @FXML
    private TextField last_name_textfield;

    @FXML
    private TextField contact_number_textfield;


    @FXML
    private TextField gmail_textfield;

    @FXML
    private Button save_changes_butten;

    @FXML
    private Button edit_infor_btn;

    @FXML
    private Button edit_btn;


    @FXML
    private AnchorPane profile_part2_infor_panel;

    @FXML
    private AnchorPane profile_window_inside_part1;

    @FXML
    private AnchorPane profile_part2_Securitiy_panel;
    @FXML
    void saveLecBtn(ActionEvent event) {
        lecUpdate();
    }
    @FXML
    void editMode(ActionEvent event) {
        first_name_textfield.setEditable(true);
        last_name_textfield.setEditable(true);
        contact_number_textfield.setEditable(true);
        gmail_textfield.setEditable(true);

    }

    @FXML

    void showSecurity(){
        Connection con = Config.getConfig();
        String id = username;
        String password ="pass1";
        user_name_textfeild.setText(id);
        password_text_feild.setText(password);
        user_name_textfeild.setEditable(false);
        password_text_feild.setEditable(false);


    }




    @FXML
    void information_lebal_click(MouseEvent event) {

        if(event.getSource() == information_lebal) {
            profile_part2_infor_panel.setVisible(true);
            profile_part2_Securitiy_panel.setVisible(false);

        } else if (event.getSource() == security_lebal) {

            profile_part2_infor_panel.setVisible(false);
            profile_part2_Securitiy_panel.setVisible(true);



        }
    }


    private File selectedFile;

    @FXML
    void edit_profile_btn_click(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        selectedFile = fileChooser.showOpenDialog(null);
        Connection con = Config.getConfig();
        if (selectedFile != null) {
            try {
                File uploadDir = new File("upload");
                if (!uploadDir.exists()) uploadDir.mkdir();

                File destFile = new File(uploadDir, selectedFile.getName());
                Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copied to: " + destFile);

                change_photo_icon.setImage(new Image(destFile.toURI().toString()));


                String userId = username; // your target user

                // check if user already has photo
                String checkSql = "SELECT user_img FROM user WHERE userId = ?";
                PreparedStatement checkPs = con.prepareStatement(checkSql);
                checkPs.setString(1, userId);
                ResultSet rs = checkPs.executeQuery();

                if (rs.next()) {
                    // update photo
                    String updateSql = "UPDATE user SET user_img = ? WHERE userId = ?";
                    PreparedStatement updatePs = con.prepareStatement(updateSql);
                    updatePs.setString(1, String.valueOf(destFile));
                    updatePs.setString(2, userId);
                    updatePs.executeUpdate();
                    updatePs.close();
                } else {
                    // insert user + photo (only if needed)
                    String insertSql = "INSERT INTO user (userId, user_img) VALUES (?, ?)";
                    PreparedStatement insertPs = con.prepareStatement(insertSql);
                    insertPs.setString(1, userId);
                    insertPs.setString(2, String.valueOf(destFile));
                    insertPs.executeUpdate();
                    insertPs.close();
                }

            } catch (Exception e) {
                System.out.println("Error handling profile photo: " + e.getMessage());
            }
        }
    }


    public void loadUserImage(String userId) {
        try {
            Connection con = Config.getConfig();
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
                        change_photo_icon.setImage(img);
                    } else {
                        System.out.println("Image file not found.");
                    }
                } else {
                    System.out.println("No image path in database.");
                }
            } else {
                System.out.println("No user found with ID: " + userId);
            }
        } catch (Exception e) {
            System.out.println("Error loading user image: " + e.getMessage());
        }
    }






    //===================

    //notice

    @FXML
    private TableColumn<NoticeInformation,String> col_Description;

    @FXML
    private TableColumn<NoticeInformation, Date> col_data;

    @FXML
    private TableColumn<NoticeInformation, String> col_notice_id;

    @FXML
    private TableColumn<NoticeInformation, String> col_notice_title;

    @FXML
    private TableView<NoticeInformation> notice_table;



    @FXML
    private Label lbl_notice_title;

    @FXML
    private Label lbl_Description;

    @FXML
    private Label lbl_date;


    @FXML

    public ObservableList<NoticeInformation> getNotice(){

        ObservableList<NoticeInformation> NoticeList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String query = "SELECT * FROM notice";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            NoticeInformation notice;
            while (rs.next()){
                notice = new NoticeInformation(rs.getString("notice_id"),rs.getString("description"),rs.getDate("date"),rs.getString("notice_title"));
                NoticeList.add(notice);
            }


        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
            return NoticeList;
    }
    @FXML
    public  void showNotice(){
        ObservableList<NoticeInformation> List = getNotice();
          col_notice_id.setCellValueFactory(new PropertyValueFactory<NoticeInformation,String>("noticeId"));
        col_data.setCellValueFactory(new PropertyValueFactory<NoticeInformation,Date>("Date"));
        col_notice_title.setCellValueFactory(new PropertyValueFactory<NoticeInformation,String>("noticeTitle"));

        notice_table.setItems(List);



    }

    @FXML
    void handleNotice(MouseEvent event) {


        NoticeInformation notice = notice_table.getSelectionModel().getSelectedItem();
        lbl_notice_title.setText("" + notice.getNoticeTitle());
        lbl_date.setText(""+notice.getDate());
        lbl_Description.setText(""+notice.getDescription());


    }






    //=========================


    //course

    @FXML
    private AnchorPane course_box;

    @FXML
    private Label lbl_course_name;

    @FXML
    private Label lbl_course_code;
    @FXML
    private Label lbl_course_credit;
    @FXML
    private Label lbl_course_hourses;
    @FXML
    private Label lbl_course_type;



    @FXML
    private Button btn_upload_matroyal;
    @FXML
    private TextField session_textfeild;

    @FXML
    private Label lbl_sucsuzzzz;


    public  ObservableList<CourseInformation> getCourse(){
        ObservableList<CourseInformation> courseList = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String sql = "SELECT c.course_code, c.course_name, c.course_credit, c.course_houre, c.course_type, c.dep_id " +
                "FROM lecture_course lc " +
                "INNER JOIN course c ON lc.course_code = c.course_code " +
                "WHERE lc.lecture_id = '" + username + "'";
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            CourseInformation course;
            while (rs.next()){
                course = new CourseInformation(
                  rs.getString("course_name"),
                        rs.getString("course_code"),
                        rs.getInt("course_credit"),
                        rs.getInt("course_houre"),
                        rs.getString("course_type")
                );
                courseList.add(course);

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return courseList;
    }

    public void ShowCourseDetils() {
        ObservableList<CourseInformation> courseList = getCourse();
            CourseInformation course = courseList.get(0);
            lbl_course_name.setText(course.getCourse_name());
            lbl_course_code.setText(course.getCourse_code());
            lbl_course_credit.setText("" + course.getCourse_credit());
            lbl_course_hourses.setText("" + course.getCourse_houres());
            lbl_course_type.setText(course.getCourse_type());

    }


    public void addpdfaction(ActionEvent event) {
        int sessionValue = 0;
        if (!session_textfeild.getText().isEmpty()) {
            try {
                sessionValue = Integer.parseInt(session_textfeild.getText());
                if (sessionValue >= 1 && sessionValue <= 15) {
                    Connection con = Config.getConfig();
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
                                System.out.println("Copied to: " + destFile.getAbsolutePath());
                                String relativePath = File.separator + "upload" + File.separator + file.getName();

                                // Save to database
                                try {
                                    String lec_name = username;
                                    String coursecode = lbl_course_code.getText();

                                    String sql = "INSERT INTO lecture_matrials (course_code, lecture_id, session_type, file_path) VALUES (?, ?, ?, ?)";
                                    PreparedStatement ps = con.prepareStatement(sql);
                                    ps.setString(1, coursecode);      // course_code
                                    ps.setString(2, lec_name);        // lecture_id - must exist in lecture table
                                    ps.setInt(3, sessionValue);       // session_type
                                    ps.setString(4, relativePath);    // file_path


                                    ps.executeUpdate();
                                    lbl_sucsuzzzz.setText("File Uploaded Successfully");
                                    showMatiriyaldetils();
                                } catch (Exception e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    // Value is not between 1 and 15
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid Session Value");
                    alert.setContentText("Please enter a session value between 1 and 15");
                    alert.showAndWait();
                }
            } catch (NumberFormatException e) {
                // Input is not an integer
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Please enter a numeric value for session");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("EMPTY SET");
            alert.setContentText("Please enter session");
            alert.showAndWait();
        }
    }
    //lecture metiriyal


    @FXML
    private TableView<Lecture_matrials_Information> table_matrials;
    @FXML
    private TableColumn<Lecture_matrials_Information, String> col_course_code;
    @FXML
    private TableColumn<Lecture_matrials_Information, String> col_lecture_id;

    @FXML
    private TableColumn<Lecture_matrials_Information, String> col_sesion_number;
    @FXML
    private TableColumn<Lecture_matrials_Information, String> col_file;

    public ObservableList<Lecture_matrials_Information> getmatrials() {
        ObservableList<Lecture_matrials_Information> metiriyalList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String sql = "SELECT * FROM lecture_matrials WHERE lecture_id = '"+username+"'";

        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            Lecture_matrials_Information matirialDetils;
            while (rs.next()) {
                matirialDetils = new Lecture_matrials_Information(
                        rs.getString("course_code"),
                        rs.getString("lecture_id"),
                        rs.getString("session_type"),
                        rs.getString("file_path")

                );
                metiriyalList.add(matirialDetils);

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return metiriyalList;
    }

    public void showMatiriyaldetils() {
        ObservableList<Lecture_matrials_Information> metiriyalList = getmatrials();

        col_course_code.setCellValueFactory(new PropertyValueFactory<Lecture_matrials_Information,String>("course_code"));
        col_lecture_id.setCellValueFactory(new PropertyValueFactory<Lecture_matrials_Information,String>("lecture_id"));
        col_sesion_number.setCellValueFactory(new PropertyValueFactory<Lecture_matrials_Information,String>("session"));
        col_file.setCellValueFactory(new PropertyValueFactory<Lecture_matrials_Information,String>("file_path"));

        table_matrials.setItems(metiriyalList);
    }



    @FXML
    private Button delete_matiriyal_btn;

    @FXML
    private Button update_matiriyal_btn;

    @FXML
    private AnchorPane fieldAREAPanel;

    @FXML
    private TextField file_txt;
    @FXML
    private TextField session_txt;
    @FXML
    void handleMatiriyal(MouseEvent event) {

        file_txt.setEditable(false);
        session_txt.setEditable(false);

        fieldAREAPanel.setVisible(true);

        Lecture_matrials_Information matiriyal = table_matrials.getSelectionModel().getSelectedItem();
        file_txt.setText("" + matiriyal.getFile_path());
        session_txt.setText(""+matiriyal.getSession());



    }
    @FXML
    void Delete_Matiriyal_btn(ActionEvent event) {

        String  file_path = file_txt.getText();
        String  session = session_txt.getText();


       try {
           String sql = "DELETE FROM lecture_matrials WHERE file_path = ? AND session_type = ?";
           PreparedStatement pst = Config.getConfig().prepareStatement(sql);
           pst.setString(1, file_path);
           pst.setString(2, session);

           pst.executeUpdate();

           showMatiriyaldetils();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);
           alert.setTitle("Information");
           alert.setHeaderText("File Deleted Successfully");
           alert.setContentText("File Deleted Successfully");
           alert.showAndWait();
           fieldAREAPanel.setVisible(false);
           file_txt.clear();
           session_txt.clear();
           lbl_sucsuzzzz.setText("");
       } catch (Exception e) {
           throw new RuntimeException(e);
       }





    }











    //=============================







    //=================================================



    //exam

    @FXML
    private TableView<Exam_Mark_Information> Mark_table;


    @FXML
    private TableColumn<Exam_Mark_Information, String> COL_tgnumber;
    @FXML
    private TableColumn<Exam_Mark_Information, String> COL_Course_code;
    @FXML
    private TableColumn<Exam_Mark_Information, String> COL_Mark_id;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_AS1;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_AS2;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_Q1;

    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_Q2;

    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_Q3;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_Q4;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_mid;

    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_end_T;
    @FXML
    private TableColumn<Exam_Mark_Information, Float> COL_ENd_P;


    @FXML
    private TextField tg_number_textField;
    @FXML
    private TextField CourseCode_textField;
    @FXML
    private TextField Mark_id_textField;
    @FXML
    private TextField AS1_textField;

    @FXML
    private TextField AS2_textField;


    @FXML
    private TextField Q1_textField;

    @FXML
    private TextField Q2_textField;

    @FXML
    private TextField Q3_textField;
    @FXML
    private TextField Q4_textField;
    @FXML
    private TextField Mid_exam_textField;
    @FXML
    private TextField End_Theory_textField;
    @FXML
    private TextField End_Practical_textField;

    @FXML
    private Button btn_cler;

    @FXML
    private Label markID_lbl;
    @FXML
    private Button Delete_btn;
    @FXML
    private Button btn_update;


@FXML
    public ObservableList<Exam_Mark_Information> getMark(){
    Connection conn = Config.getConfig();

            ObservableList<Exam_Mark_Information> markList = FXCollections.observableArrayList();


        String lectureId = username; // example: user login lecture id

        String sql = "SELECT * FROM mark JOIN lecture_course ON mark.course_code = lecture_course.course_code WHERE lecture_course.lecture_id = '"+lectureId+"'";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            Exam_Mark_Information markDetils;

            while (rs.next()) {
                Exam_Mark_Information markDetails = new Exam_Mark_Information(
                        rs.getString("student_id"),
                        rs.getString("course_code"),
                        rs.getString("mark_id"),
                        rs.getFloat("assesment_1") ,
                        rs.getFloat("assesment_2") ,
                        rs.getFloat("quiz_1") ,
                        rs.getFloat("quiz_2") ,
                        rs.getFloat("quiz_3") ,
                        rs.getFloat("quiz_4") ,
                        rs.getFloat("mid_term") ,
                        rs.getFloat("end_theory") ,
                        rs.getFloat("end_practical")
                );
                markList.add(markDetails);

            }
            System.out.println(markList);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


            return markList;



    }
    @FXML
    public void showMark() {
        ObservableList<Exam_Mark_Information> markList = getMark();


        COL_tgnumber.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,String>("tg_number"));
        COL_Course_code.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,String>("course_code"));
//        COL_Mark_id.setCellValueFactory(new PropertyValueFactory<>("markId"));
        COL_AS1.setCellValueFactory(new PropertyValueFactory<>("aS1"));
        COL_AS2.setCellValueFactory(new PropertyValueFactory<>("aS2"));
        COL_Q1.setCellValueFactory(new PropertyValueFactory<>("q1"));
        COL_Q2.setCellValueFactory(new PropertyValueFactory<>("q2"));
        COL_Q3.setCellValueFactory(new PropertyValueFactory<>("q3"));
        COL_Q4.setCellValueFactory(new PropertyValueFactory<>("q4"));


        COL_mid.setCellValueFactory(new PropertyValueFactory<>("mid"));
        COL_end_T.setCellValueFactory(new PropertyValueFactory<>("end_T"));
        COL_ENd_P.setCellValueFactory(new PropertyValueFactory<>("end_P"));

        Mark_table.setItems(markList);
    }
@FXML
    void handle_mark(MouseEvent event) {

    Exam_Mark_Information mark = Mark_table.getSelectionModel().getSelectedItem();

        tg_number_textField.setText("" + mark.getTg_number());
        CourseCode_textField.setText("" + mark.getCourse_code());
//        Mark_id_textField.setText("" + mark.getMarkId());
        AS1_textField.setText(""+mark.getAS1());
        AS2_textField.setText(""+mark.getAS2());
        Q1_textField.setText(""+mark.getQ1());
        Q2_textField.setText(""+mark.getQ2());
        Q3_textField.setText(""+mark.getQ3());
        Q4_textField.setText(""+mark.getQ4());
        Mid_exam_textField.setText(""+mark.getMid());
        End_Theory_textField.setText(""+mark.getEnd_T());
        End_Practical_textField.setText(""+mark.getEnd_P());
        markID_lbl.setText("" + mark.getMarkId());






    }
    public void  clearText_feild_action(ActionEvent event) {

        tg_number_textField.setText("");
        CourseCode_textField.setText("");

        AS1_textField.setText("");
        AS2_textField.setText("");
        Q1_textField.setText("");
        Q2_textField.setText("");
        Q3_textField.setText("");
        Q4_textField.setText("");
        Mid_exam_textField.setText("");
        End_Theory_textField.setText("");
        End_Practical_textField.setText("");
        markID_lbl.setText("");



    }
    @FXML
    private boolean isValidMark(double mark) {
        return mark >= 0 && mark <= 100;
    }
    @FXML
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }



    @FXML
    public void addData(ActionEvent event) {
        Connection conn = Config.getConfig();

        String cCode = CourseCode_textField.getText();
        String SId= tg_number_textField.getText();
        float assesment1 = Float.parseFloat(AS1_textField.getText());
        float assesment2 = Float.parseFloat(AS2_textField.getText());
        float quiz1 = Float.parseFloat(Q1_textField.getText());
        float quiz2 = Float.parseFloat(Q2_textField.getText());
        float quiz3 = Float.parseFloat(Q3_textField.getText());
        float quiz4 = Float.parseFloat(Q4_textField.getText());
        float midterm = Float.parseFloat(Mid_exam_textField.getText());
        float endTheory = Float.parseFloat(End_Theory_textField.getText());
        float endPractical = Float.parseFloat(End_Practical_textField.getText());


        if (tg_number_textField.getText().isEmpty() ||
                cCode.isEmpty() ||
                Float.isNaN(assesment1) ||
                Float.isNaN(assesment2) ||
                Float.isNaN(quiz1) ||
                Float.isNaN(quiz2) ||
                Float.isNaN(quiz3) ||
                Float.isNaN(quiz4) ||
                Float.isNaN(midterm) ||
                Float.isNaN(endTheory) ||
                Float.isNaN(endPractical)) {

            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all fields properly.");
            return;
        }


        if (!isValidMark(assesment1) || !isValidMark(assesment2) || !isValidMark(quiz1) || !isValidMark(quiz2) ||
                !isValidMark(quiz3) || !isValidMark(quiz4) || !isValidMark(midterm) ||
                !isValidMark(endTheory) || !isValidMark(endPractical)) {

            showAlert(Alert.AlertType.ERROR, "Validation Error", "Marks must be between 0 and 100.");
            return;
        }



      try {

            String insertSql = "INSERT INTO mark (student_id, course_code, assesment_1, assesment_2, quiz_1, quiz_2, quiz_3, quiz_4, mid_term, end_theory, end_practical) VALUES (?,?,?,?,?,?,?,?,?,?,?)";




            // If no duplicate, insert new data
            PreparedStatement userPs = conn.prepareStatement(insertSql);
            userPs.setString(1, tg_number_textField.getText());
            userPs.setString(2, CourseCode_textField.getText());
            userPs.setDouble(3, assesment1);
            userPs.setDouble(4, assesment2);
            userPs.setDouble(5, quiz1);
            userPs.setDouble(6, quiz2);
            userPs.setDouble(7, quiz3);
            userPs.setDouble(8, quiz4);
            userPs.setDouble(9, midterm);
            userPs.setDouble(10, endTheory);
            userPs.setDouble(11, endPractical);

            int rowsInserted = userPs.executeUpdate();
            showMark();
            enterMark(cCode, assesment1, assesment2, quiz1, quiz2, quiz3, quiz4, midterm, endTheory, endPractical, SId);
            if (rowsInserted > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Data added successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Failed to add data. Please try again.");
            }

        } catch (Exception e) {
            // Print stack trace for debugging
            e.printStackTrace();

            // Show specific error message to user
            showAlert(Alert.AlertType.ERROR, "Error",
                    "Database error: " + e.getMessage());
        }
      showMark();
    }

    private static void enterMark(String courseCode, float aS1, float aS2, float q1, float q2, float q3, float q4, float mid, float endT, float endP, String studentId) {
        float finalMark = calculateFinalMark(courseCode, aS1, aS2, q1, q2, q3, q4, mid, endT, endP);
        String grade = getGrade(finalMark);
        Connection con = Config.getConfig();
        System.out.printf("%-10s %-10s %-10.2f %-10s%n", studentId, courseCode, finalMark, grade);
        String sql = "INSERT INTO final_mark(student_id, course_code, final_mark, grade) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, studentId);
            ps.setString(2, courseCode);
            ps.setFloat(3, finalMark); // <--- setFloat instead of setDouble
            ps.setString(4, grade);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static float calculateFinalMark(String courseCode,
                                           Float assessment1, Float assessment2,
                                           Float quiz1, Float quiz2, Float quiz3, Float quiz4,
                                           Float midTerm, Float endTheory, Float endPractical) {
        float finalMark = 0.0f;

        if (courseCode.equals("ICT2122")) {
            ArrayList<Float> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);
            if (quiz4 != null && quiz4 != 0) quizList.add(quiz4);

            float quizMark = (float) (bestAverage(quizList, 3) * 0.10f);
            float assessmentMark = (assessment1 != null && assessment1 != 0 ? assessment1 : 0) * 0.10f;
            float midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20f;
            float finalTheoryMark = (endTheory != null && endTheory != 0 ? endTheory : 0) * 0.60f;

            finalMark = quizMark + assessmentMark + midTermMark + finalTheoryMark;
        }
        else if (courseCode.equals("ICT2113")) {
            ArrayList<Float> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            float quizMark = (float) (bestAverage(quizList, 2) * 0.10f);
            float midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20f;
            float finalTheoryMark = (endTheory != null && endTheory != 0 ? endTheory : 0) * 0.40f;
            float finalPracticalMark = (endPractical != null && endPractical != 0 ? endPractical : 0) * 0.30f;

            finalMark = quizMark + midTermMark + finalTheoryMark + finalPracticalMark;
        }
        else if (courseCode.equals("ICT2133")) {
            ArrayList<Float> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            ArrayList<Float> assessList = new ArrayList<>();
            if (assessment1 != null && assessment1 != 0) assessList.add(assessment1);
            if (assessment2 != null && assessment2 != 0) assessList.add(assessment2);

            float quizMark = (float) (bestAverage(quizList, 2) * 0.10f);
            float assessmentMark = (float) (bestAverage(assessList, 2) * 0.20f);
            float finalTheoryMark = (endTheory != null && endTheory != 0 ? endTheory : 0) * 0.40f;
            float finalPracticalMark = (endPractical != null && endPractical != 0 ? endPractical : 0) * 0.30f;

            finalMark = quizMark + assessmentMark + finalTheoryMark + finalPracticalMark;
        }
        else if (courseCode.equals("ICT2142")) {
            float assessmentMark = (assessment1 != null && assessment1 != 0 ? assessment1 : 0) * 0.20f;
            float midTermMark = (midTerm != null && midTerm != 0 ? midTerm : 0) * 0.20f;
            float finalPracticalMark = (endPractical != null && endPractical != 0 ? endPractical : 0) * 0.60f;

            finalMark = assessmentMark + midTermMark + finalPracticalMark;
        }
        else if (courseCode.equals("ICT2152")) {
            ArrayList<Float> quizList = new ArrayList<>();
            if (quiz1 != null && quiz1 != 0) quizList.add(quiz1);
            if (quiz2 != null && quiz2 != 0) quizList.add(quiz2);
            if (quiz3 != null && quiz3 != 0) quizList.add(quiz3);

            ArrayList<Float> assessList = new ArrayList<>();
            if (assessment1 != null && assessment1 != 0) assessList.add(assessment1);
            if (assessment2 != null && assessment2 != 0) assessList.add(assessment2);

            float quizMark = (float) (bestAverage(quizList, 2) * 0.10f);
            float assessmentMark = (float) (bestAverage(assessList, 2) * 0.20f);
            float finalTheoryMark = (endTheory != null && endTheory != 0 ? endTheory : 0) * 0.70f;

            finalMark = quizMark + assessmentMark + finalTheoryMark;
        }

        return finalMark;
    }


    private static double bestAverage(ArrayList<Float> marks, int bestCount) {
        if (marks.isEmpty()) return 0;
        Collections.sort(marks);
        int size = marks.size();
        int startIndex = Math.max(size - bestCount, 0);
        int sum = 0;
        for (int i = startIndex; i < size; i++) {
            sum += marks.get(i);
        }
        return sum / (double) (size - startIndex);
    }

    private static String getGrade(double finalMark) {
        if (finalMark >= 85) return "A+";
        else if (finalMark >= 70) return "A";
        else if (finalMark >= 65) return "A-";
        else if (finalMark >= 60) return "B+";
        else if (finalMark >= 55) return "B";
        else if (finalMark >= 50) return "B-";
        else if (finalMark >= 45) return "C+";
        else if (finalMark >= 40) return "C";
        else if (finalMark >= 35) return "C-";
        else if (finalMark >= 30) return "D+";
        else if (finalMark >= 25) return "D";
        else return "E";
    }















    @FXML

    public void DeleteAction(ActionEvent event) {





        // Get all values from text fields
        String tg_number = tg_number_textField.getText();
        String course_code = CourseCode_textField.getText();
        String mark_id = markID_lbl.getText();  // mark_id should be from the label as it's the unique identifier

        String as1 = AS1_textField.getText();
        String as2 = AS2_textField.getText();
        String q1 = Q1_textField.getText();
        String q2 = Q2_textField.getText();
        String q3 = Q3_textField.getText();
        String q4 = Q4_textField.getText();
        String mid = Mid_exam_textField.getText();
        String endT = End_Theory_textField.getText();
        String endP = End_Practical_textField.getText();

        // Check if any of the fields are empty except mark_id
        if (tg_number.isEmpty() || course_code.isEmpty() ||
                as1.isEmpty() || as2.isEmpty() || q1.isEmpty() || q2.isEmpty() || q3.isEmpty() || q4.isEmpty() ||
                mid.isEmpty() || endT.isEmpty() || endP.isEmpty()) {

            // Show validation error message if any field is empty
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please fill all fields properly before deleting.");
            return;
        }

        // Proceed with delete operation based on mark_id (which is unique)
        try {
            Connection conn = Config.getConfig();  // Assuming your database connection class is Config

            // SQL to delete the record based on mark_id (as it is unique)
            String deleteSql = "DELETE FROM mark WHERE mark_id = ?";
            PreparedStatement deletePs = conn.prepareStatement(deleteSql);
            deletePs.setString(1, mark_id);  // Use mark_id as the identifier

            // Execute the delete query
            int rowsDeleted = deletePs.executeUpdate();

            if (rowsDeleted > 0) {
                // Show success alert if record was deleted
                showAlert(Alert.AlertType.INFORMATION, "Success", "Record with Mark ID " + mark_id + " deleted successfully.");
                // Optionally, clear the fields after deletion
                clearFields();
                showMark();
            } else {
                // Show error if no record was found for the provided mark_id
                showAlert(Alert.AlertType.ERROR, "Failed", "No record found to delete with Mark ID " + mark_id);
            }

        } catch (SQLException e) {
            // Handle any database errors
            showAlert(Alert.AlertType.ERROR, "Database Error", "An error occurred while deleting the record.");
            e.printStackTrace();
        }
    }

    // Helper method to clear text fields after deletion
    private void clearFields() {
        tg_number_textField.clear();
        CourseCode_textField.clear();
        markID_lbl.setText("");  // Clear the mark_id label
        AS1_textField.clear();
        AS2_textField.clear();
        Q1_textField.clear();
        Q2_textField.clear();
        Q3_textField.clear();
        Q4_textField.clear();
        Mid_exam_textField.clear();
        End_Theory_textField.clear();
        End_Practical_textField.clear();
    }



    @FXML
    public void updateData(ActionEvent event) {
        // Check if all fields are filled
        if (tg_number_textField.getText().isEmpty() ||
                CourseCode_textField.getText().isEmpty() ||
                AS1_textField.getText().isEmpty() ||
                AS2_textField.getText().isEmpty() ||
                Q1_textField.getText().isEmpty() ||
                Q2_textField.getText().isEmpty() ||
                Q3_textField.getText().isEmpty() ||
                Q4_textField.getText().isEmpty() ||
                Mid_exam_textField.getText().isEmpty() ||
                End_Theory_textField.getText().isEmpty() ||
                End_Practical_textField.getText().isEmpty() ||
                markID_lbl.getText().isEmpty()) {

            showAlert(Alert.AlertType.ERROR, "Validation Error", "Please select a record to update first.");
            return;
        }

        // Parse and validate marks
        double as1, as2, q1, q2, q3, q4, mid, endT, endP;
        try {
            as1 = Double.parseDouble(AS1_textField.getText());
            as2 = Double.parseDouble(AS2_textField.getText());
            q1 = Double.parseDouble(Q1_textField.getText());
            q2 = Double.parseDouble(Q2_textField.getText());
            q3 = Double.parseDouble(Q3_textField.getText());
            q4 = Double.parseDouble(Q4_textField.getText());
            mid = Double.parseDouble(Mid_exam_textField.getText());
            endT = Double.parseDouble(End_Theory_textField.getText());
            endP = Double.parseDouble(End_Practical_textField.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Marks must be valid numbers.");
            return;
        }

        // Validate mark ranges
        if (!isValidMark(as1) || !isValidMark(as2) || !isValidMark(q1) || !isValidMark(q2) ||
                !isValidMark(q3) || !isValidMark(q4) || !isValidMark(mid) ||
                !isValidMark(endT) || !isValidMark(endP)) {

            showAlert(Alert.AlertType.ERROR, "Validation Error", "Marks must be between 0 and 100.");
            return;
        }

        try {
            Connection conn = Config.getConfig();
            String updateSql = "UPDATE mark SET student_id = ?, course_code = ?, assesment_1 = ?, " +
                    "assesment_2 = ?, quiz_1 = ?, quiz_2 = ?, quiz_3 = ?, quiz_4 = ?, " +
                    "mid_term = ?, end_theory = ?, end_practical = ? WHERE mark_id = ?";

            PreparedStatement updatePs = conn.prepareStatement(updateSql);
            updatePs.setString(1, tg_number_textField.getText());
            updatePs.setString(2, CourseCode_textField.getText());
            updatePs.setDouble(3, as1);
            updatePs.setDouble(4, as2);
            updatePs.setDouble(5, q1);
            updatePs.setDouble(6, q2);
            updatePs.setDouble(7, q3);
            updatePs.setDouble(8, q4);
            updatePs.setDouble(9, mid);
            updatePs.setDouble(10, endT);
            updatePs.setDouble(11, endP);
            updatePs.setString(12, markID_lbl.getText());

            int rowsUpdated = updatePs.executeUpdate();
            showMark(); // Refresh table display

            if (rowsUpdated > 0) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Record updated successfully!");
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Failed to update record. Please try again.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "Database error: " + e.getMessage());
        }
    }













    //=================================================


    @FXML
    private ImageView logout_photo;



    @FXML
    private AnchorPane undergraduate_window;
    @FXML
    private AnchorPane notice_window;
    @FXML
    private AnchorPane grade_window;
    @FXML
    private AnchorPane exam_window;
    @FXML
    private AnchorPane eligibility_window;
    @FXML
    private AnchorPane attenfance_window;



    @FXML
    private Pane back_btn_pane;

    @FXML
    private AnchorPane courses_window;

    @FXML
    private AnchorPane profile_window;


    @FXML
    private AnchorPane all_profile_window;

    @FXML
    private ImageView attendeance_photo;

    @FXML
    private ImageView courses;

    @FXML
    private ImageView eligibility_photo;

    @FXML
    private ImageView exam_mark;

    @FXML
    private ImageView grade_gpa_photo;

    @FXML
    private AnchorPane main_panel;

    @FXML
    private ImageView notice_photo;

    @FXML
    private ImageView profile;

    @FXML
    private ImageView undergraduate_photo;
    @FXML
    private Button go_back_btn;

    @FXML
    private Label welcome_Name;

     //String username = LoginController.lecTg;



    @FXML
    void handleAllprofile(MouseEvent event) {
        if (event.getSource() == profile) {

            all_profile_window.setVisible(false);
            profile_window.setVisible(true);

            courses_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);



        }
        else if (event.getSource() == courses) {
            all_profile_window.setVisible(false);
            courses_window.setVisible(true);

            profile_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);

        }
        else if (event.getSource() == exam_mark) {
            all_profile_window.setVisible(false);
            exam_window.setVisible(true);

            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);



        }

        else if (event.getSource() == undergraduate_photo) {
            all_profile_window.setVisible(false);
            undergraduate_window.setVisible(true);


            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }
        else if (event.getSource() == eligibility_photo) {
            all_profile_window.setVisible(false);
            eligibility_window.setVisible(true);


            undergraduate_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }

        else if (event.getSource() == grade_gpa_photo) {
            all_profile_window.setVisible(false);
            grade_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }

        else if (event.getSource() == notice_photo) {
            all_profile_window.setVisible(false);
            notice_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            attenfance_window.setVisible(false);
            grade_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }
        else if (event.getSource() == attendeance_photo) {
            all_profile_window.setVisible(false);
            attenfance_window.setVisible(true);


            eligibility_window.setVisible(false);
            undergraduate_window.setVisible(false);
            grade_window.setVisible(false);
            notice_window.setVisible(false);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);



        }





    }


    @FXML
    void backtoALLprofile(ActionEvent event) {



            all_profile_window.setVisible(true);
            profile_window.setVisible(false);
            courses_window.setVisible(false);
            exam_window.setVisible(false);
            undergraduate_window.setVisible(false);
            eligibility_window.setVisible(false);
            grade_window.setVisible(false);
            attenfance_window.setVisible(false);
            notice_window.setVisible(false);

    }

    public ObservableList<LectureInformation> getLecture(){
        ObservableList<LectureInformation> lecList = FXCollections.observableArrayList();
        Connection conn = Config.getConfig();
        String sql = "SELECT * FROM lecture l " +
                     "JOIN user u ON l.lecture_id = u.userId " +
                     "LEFT JOIN user_contact uc ON u.userId = uc.userId " +
                     "INNER JOIN department d ON d.dep_id = l.dep_id " +
                     "WHERE u.userId = '"+username+"'";
        Statement stmt = null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            LectureInformation lecDetails;
            while(rs.next()){
                lecDetails = new LectureInformation(rs.getString("userId"),rs.getString("nic"),
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getDate("bod"),
                        rs.getString("contact_no"),
                        rs.getString("position"),
                        rs.getString("dep_name")
                );
                lecList.add(lecDetails);
                System.out.println("user id " + rs.getString("f_name"));
            }
        }catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }
        return lecList;
    }
    public void showLecDetails(){
        ObservableList<LectureInformation> lecList = getLecture();
        LectureInformation lec = lecList.get(0);
        first_name_textfield.setText(lec.getLecFname());
        last_name_textfield.setText(lec.getLecLname());
        contact_number_textfield.setText(lec.getLecContactNo());
        gmail_textfield.setText(lec.getLecEmail());
    }

    public void setLecName(){
        ObservableList<LectureInformation> lecList = getLecture();
        LectureInformation lec = lecList.get(0);
        welcome_Name.setText(lec.getLecFullName());
    }
    public void lecUpdate(){
        Connection conn = Config.getConfig();


        String lecFName = first_name_textfield.getText();
        String lecLName = last_name_textfield.getText();
        String leccontactNo = contact_number_textfield.getText();
        String lecEmail = gmail_textfield.getText();


//        String[] nameParts = lecFullName.split(" ");
//        String first_name = nameParts[0];
//        String last_name = nameParts.length > 1 ? nameParts[1] : "";

//        String ucUpdateSql = "UPDATE user_contact SET contact_no=? WHERE userId=?";
//        String lecUpdateSql = "UPDATE lecture SET position=?, dep_id=? WHERE lecture_id=?";
//        String userUpdateSql = "UPDATE user SET f_name = ?,l_name = ?, nic = ?, address = ?,email = ?,gender = ?,bod = ?, password = ? WHERE userId = ?";
               String userUpdateSql = "UPDATE user SET f_name = ? WHERE userId = '"+username+"'";
              String  userUpdateSql2 = "UPDATE user SET l_name = ? WHERE userId = '"+username+"'";
                String  userUpdateSql3 = "UPDATE user_contact SET contact_no  = ? WHERE userId = '"+username+"'";
                String  userUpdateSql4 = "UPDATE user SET email = ? WHERE userId = '"+username+"'";


        try{

//            PreparedStatement ucPs = conn.prepareStatement(ucUpdateSql);
//            ucPs.setString(1, lecContactNo);
//            ucPs.setString(2, lecId);
//            ucPs.executeUpdate();
//
//            PreparedStatement lecUpdateStmt = conn.prepareStatement(lecUpdateSql);
//            lecUpdateStmt.setString(1, lecPosition);
//            lecUpdateStmt.setString(2, ld);
//            lecUpdateStmt.setString(3, lecId);
//            lecUpdateStmt.executeUpdate();

            PreparedStatement userPs = conn.prepareStatement(userUpdateSql);
            userPs.setString(1, lecFName);

            PreparedStatement leclast = conn.prepareStatement(userUpdateSql2);
            leclast.setString(1, lecLName); // changed 2 -> 1

            PreparedStatement leccon = conn.prepareStatement(userUpdateSql3);
            leccon.setString(1, leccontactNo); // changed 3 -> 1

            PreparedStatement lecmail = conn.prepareStatement(userUpdateSql4);
            lecmail.setString(1, lecEmail); // changed 4 -> 1







//            userPs.setString(2, last_name);
//            userPs.setString(3, lecNIC);
//            userPs.setString(4, lecAddress);
//            userPs.setString(5, lecEmail);
//            userPs.setString(6, lecGender);
//            userPs.setString(7, lecBod.toString());
//            userPs.setString(8, lecPassword);
//            userPs.setString(9, lecId);

            String sql = "UPDATE user SET f_name = ?, l_name = ?, email = ? WHERE userId = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lecFName);
            ps.setString(2, lecLName);
            ps.setString(3, lecEmail);
            ps.setString(4, username);
            ps.executeUpdate();

//            userPs.executeUpdate();
//            leclast.executeUpdate();
//            leccon.executeUpdate();
//            lecmail.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("Lecture Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Lecture updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

        setLecName();
    }
//   GPA AND GRADE
    @FXML
    private TableColumn<GPARecord, Double> gpaMark;

    @FXML
    private TableColumn<GPARecord, String> gpaStdID;

    @FXML
    private TableView<GPARecord> gpaTable;

    public static double getPoint(String grade) {
        if (grade.equals("A+") || grade.equals("A")) {
            return 4.0;
        } else if (grade.equals("A-")) {
            return 3.7;
        } else if (grade.equals("B+")) {
            return 3.3;
        } else if (grade.equals("B")) {
            return 3.0;
        } else if (grade.equals("B-")) {
            return 2.7;
        } else if (grade.equals("C+")) {
            return 2.3;
        } else if (grade.equals("C")) {
            return 2.0;
        } else if (grade.equals("C-")) {
            return 1.7;
        } else if (grade.equals("D+")) {
            return 1.3;
        } else if (grade.equals("D")) {
            return 1.0;
        } else {
            return 0.0;
        }
    }

    public static double calculateSGPA(ArrayList<Double> gradePoints, ArrayList<Integer> credits) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradePoints.size(); i++) {
            totalPoints += gradePoints.get(i) * credits.get(i);
            totalCredits += credits.get(i);
        }

        if (totalCredits == 0) return 0.0;
        return totalPoints / totalCredits;
    }

    public static double calculateCGPA(ArrayList<Double> sgpas) {
        if (sgpas.isEmpty()) return 0.0;

        double total = 0;
        for (double sgpa : sgpas) {
            total += sgpa;
        }
        return total / sgpas.size();
    }

    private void gpaCal() {
        Connection con = Config.getConfig();
        HashMap<String, Integer> courseCredits = new HashMap<>();

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT course_code, course_credit FROM course")
        ) {
            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                int credit = rs.getInt("course_credit");
                if (!rs.wasNull()) {
                    courseCredits.put(courseCode, credit);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error loading course credits: " + e.getMessage());
            return;
        }

        String sql = "SELECT student_id, course_code, grade FROM final_mark";

        try (
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql)
        ) {
            HashMap<String, ArrayList<Double>> studentGradePoints = new HashMap<>();
            HashMap<String, ArrayList<Integer>> studentCredits = new HashMap<>();

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String courseCode = rs.getString("course_code");
                String grade = rs.getString("grade");

                double gradePoint = getPoint(grade);
                int credit = courseCredits.getOrDefault(courseCode, 0);

                studentGradePoints.computeIfAbsent(studentId, k -> new ArrayList<>()).add(gradePoint);
                studentCredits.computeIfAbsent(studentId, k -> new ArrayList<>()).add(credit);
            }

            // Create an ObservableList to add to the table
            ObservableList<GPARecord> gpaList = FXCollections.observableArrayList();

            for (String studentId : studentGradePoints.keySet()) {
                ArrayList<Double> grades = studentGradePoints.get(studentId);
                ArrayList<Integer> credits = studentCredits.get(studentId);

                double sgpa = calculateSGPA(grades, credits);
                ArrayList<Double> sgpaList = new ArrayList<>();
                sgpaList.add(sgpa);

                double cgpa = calculateCGPA(sgpaList);

                gpaList.add(new GPARecord(studentId, cgpa));
            }

            // Assign data to table
            gpaStdID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
            gpaMark.setCellValueFactory(new PropertyValueFactory<>("cgpa"));
            gpaTable.setItems(gpaList);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
// GRADE

    @FXML
    private TableColumn<Grade, String> gradeCId;

    @FXML
    private TableColumn<Grade, String> gradeSId;

    @FXML
    private TableColumn<Grade, String> gradeValue;
    @FXML
    private TableView<Grade> GradeTable;

    public ObservableList<Grade> getGreadslist() {
        ObservableList<Grade> Greads_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String courseCode = getCourseCode();
        System.out.println("course code " + courseCode);
        String query = "SELECT * FROM final_mark WHERE course_code = '" + courseCode + "'";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Grade gd;
            while (rs.next()) {
                gd = new Grade(
                        rs.getString("course_code"),
                        rs.getString("grade"),
                        rs.getString("student_id")
                );
                Greads_list.add(gd);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Greads_list;
    }

    public void showGreads() {
        ObservableList<Grade> Greads_list = getGreadslist();
        gradeCId.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        gradeSId.setCellValueFactory(new PropertyValueFactory<>("stuId"));
        gradeValue.setCellValueFactory(new PropertyValueFactory<>("grade"));
        GradeTable.setItems(Greads_list);

}

    // ELIGIBILITY

    @FXML
    private TableColumn<EligibilityRecord, String> elCaState;

    @FXML
    private TableColumn<EligibilityRecord, String> elCourseCode;

    @FXML
    private TableColumn<EligibilityRecord, String> elExamState;

    @FXML
    private TableColumn<EligibilityRecord, String> elStuID;

    @FXML
    private TableColumn<EligibilityRecord, String> elattState;

    private static ObservableList<EligibilityRecord> eligibilityList = FXCollections.observableArrayList();

    public void calculateFinalEligibility() {
        Connection con = Config.getConfig();

        eligibilityList.clear(); // Clear old data if any

        // Attendance eligibility
        HashMap<String, String> attendanceMap = new HashMap<>();
        String attendanceSql = "SELECT student_id, course_code, " +
                "CASE WHEN (SUM(CASE WHEN att_state IN ('Present', 'Medical') THEN 1 ELSE 0 END) / COUNT(*)) * 100 >= 80 " +
                "THEN 'EL' ELSE 'NE' END AS eligibility " +
                "FROM attendence " +
                "GROUP BY student_id, course_code";

        try (PreparedStatement ps = con.prepareStatement(attendanceSql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String key = rs.getString("student_id") + "_" + rs.getString("course_code");
                attendanceMap.put(key, rs.getString("eligibility"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching attendance eligibility.");
            return;
        }

        // CA eligibility
        String caSql = "SELECT * FROM mark";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(caSql)) {

            while (rs.next()) {
                String studentId = rs.getString("student_id");
                String courseCode = rs.getString("course_code");
                String key = studentId + "_" + courseCode;

                Integer aS1 = (int) rs.getFloat("assesment_1");
                Integer aS2 = (int) rs.getFloat("assesment_2");
                Integer q1 = (int) rs.getFloat("quiz_1");
                Integer q2 = (int) rs.getFloat("quiz_2");
                Integer q3 = (int) rs.getFloat("quiz_3");
                Integer q4 = (int) rs.getFloat("quiz_4");
                Integer mid = (int) rs.getFloat("mid_term");

                double caMark = CAMarkCalculator.calculateCAMark(courseCode, aS1, aS2, q1, q2, q3, q4, mid);
                String caEligibility;

                if (courseCode.equals("ICT2113") || courseCode.equals("ICT2133") || courseCode.equals("ICT2152")) {
                    caEligibility = caMark >= 15.0 ? "EL" : "NE";
                } else if (courseCode.equals("ICT2122") || courseCode.equals("ICT2142")) {
                    caEligibility = caMark >= 19.5 ? "EL" : "NE";
                } else {
                    caEligibility = "NE"; // Default if course not matched
                }

                String attendanceEligibility = attendanceMap.getOrDefault(key, "NE");

                String finalEligibility;
                if (attendanceEligibility.equals("EL") && caEligibility.equals("EL")) {
                    finalEligibility = "EL";
                } else {
                    finalEligibility = "NE (";
                    if (!attendanceEligibility.equals("EL") && !caEligibility.equals("EL")) {
                        finalEligibility += "Low Attendance & Low CA";
                    } else if (!attendanceEligibility.equals("EL")) {
                        finalEligibility += "Low Attendance";
                    } else {
                        finalEligibility += "Low CA";
                    }
                    finalEligibility += ")";
                }

                EligibilityRecord record = new EligibilityRecord(studentId, courseCode, attendanceEligibility, caEligibility, finalEligibility);
                eligibilityList.add(record);
            }

            eligibilityTablet.setItems(eligibilityList); // <-- Set data into the table

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error fetching CA eligibility.");

        }
    }


    public void showEligibility() {
        elStuID.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        elCourseCode.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        elattState.setCellValueFactory(new PropertyValueFactory<>("attendanceEligibility"));
        elCaState.setCellValueFactory(new PropertyValueFactory<>("caEligibility"));
        elExamState.setCellValueFactory(new PropertyValueFactory<>("finalEligibility"));
    }
    @FXML
    private TextField eligibilitySearch;

    @FXML
    private TableView<EligibilityRecord> eligibilityTablet;

    @FXML
    void eligibilitySearchAction(MouseEvent event) {
        FilteredList<EligibilityRecord> filteredData = new FilteredList<>(eligibilityList, e -> true);

        eligibilitySearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(record -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (record.getStudentId().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<EligibilityRecord> sortedList = new SortedList<>(filteredData);
        sortedList.comparatorProperty().bind(eligibilityTablet.comparatorProperty());
        eligibilityTablet.setItems(sortedList);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSecurity();
        getLecture();
        showLecDetails();
        setLecName();
        showNotice();
        showUndergraduate();
        ShowCourseDetils();
        showMatiriyaldetils();
        loadUserImage(username);
        showMark();
        showAttendance();
        showMedical();
        gpaCal();
        showGreads();
        calculateFinalEligibility();
        showEligibility();
    }

}
