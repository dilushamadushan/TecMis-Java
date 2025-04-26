package app.tecmis.lecture;

import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.sql.PreparedStatement;




//========================

//notice window
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;


//======================


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class Lecture implements Initializable {



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
        String id = "LEC001";
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


                String userId = "LEC001"; // your target user

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

                rs.close();
                checkPs.close();

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

            rs.close();
            ps.close();
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
    String username = "LEC003";
    String password ="pass1";

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
                                    String lec_name = "LEC001";
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
        String sql = "SELECT * FROM lecture_matrials WHERE lecture_id = 'LEC001'";

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
    public ObservableList<Exam_Mark_Information> getMark(){
    Connection conn = Config.getConfig();

            ObservableList<Exam_Mark_Information> markList = FXCollections.observableArrayList();


        String lectureId = "LEC001"; // example: user login lecture id

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
                System.out.println(rs.getFloat("assesment_1"));
            }


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
        COL_Mark_id.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,String>("markId"));
        COL_AS1.setCellValueFactory(new PropertyValueFactory<>("aS1"));
        COL_AS2.setCellValueFactory(new PropertyValueFactory<>("aS2"));
        COL_Q1.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("q1"));
        COL_Q2.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("q2"));
        COL_Q3.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("q3"));
        COL_Q4.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("q4"));


        COL_mid.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("mid"));
        COL_end_T.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("end_T"));
        COL_ENd_P.setCellValueFactory(new PropertyValueFactory<Exam_Mark_Information,Float>("end_P"));

        Mark_table.setItems(markList);
    }

    void handle_mark(MouseEvent event) {


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
        loadUserImage("LEC001");
        showMark();

    }

}
