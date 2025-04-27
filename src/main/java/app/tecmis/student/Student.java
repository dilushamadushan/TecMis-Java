package app.tecmis.student;

import app.tecmis.App;
import app.tecmis.LoginController;
import app.tecmis.connection.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Student implements Initializable {
    public String attCCId;
    public String cd ;
    public static String username = LoginController.stuTg;

    @FXML
    void log_out(MouseEvent event) {
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


    @FXML
    private Label course_code;

    @FXML
    private AnchorPane Medical_details;


    @FXML
    private AnchorPane Time_table_panal;

    @FXML
    private AnchorPane aad_new_medical;

    @FXML
    private ImageView attendance_and_medical;

    @FXML
    private AnchorPane attendance_and_medical_panal;

    @FXML
    private AnchorPane attendence;

    @FXML
    private AnchorPane cour_dll;


    @FXML
    private ImageView courses;

    @FXML
    private AnchorPane courses_panal;

    @FXML
    private AnchorPane data;

    @FXML
    private AnchorPane display_profile_panal;

    @FXML
    private AnchorPane e_courmmerse;

    @FXML
    private AnchorPane edit_profile_panals;

    @FXML
    private Label gpa;

    @FXML
    private Label grade;

    @FXML
    private ImageView grade_abd_gpa;

    @FXML
    private AnchorPane grade_abd_gpa_panal;

    @FXML
    private AnchorPane home;

    @FXML
    private ImageView image_d;

    @FXML
    private ImageView image_e;

    @FXML
    private ImageView image_ooa;

    @FXML
    private ImageView image_oop;

    @FXML
    private ImageView image_oopp;

    @FXML
    private Label name;

    @FXML
    private AnchorPane newprofile;

    @FXML
    private ImageView notice;

    @FXML
    private AnchorPane notice_panal;

    @FXML
    private AnchorPane ooa;

    @FXML
    private AnchorPane oopp;

    @FXML
    private AnchorPane oops;

    @FXML
    private ImageView profile;

    @FXML
    private AnchorPane profile_image_panal;

    @FXML
    private AnchorPane profile_panal;

    @FXML
    private ImageView time_table;

    @FXML
    private AnchorPane viwe_attendence;


    @FXML
    private Button back_btn;
    private String pdf_path;


    @FXML
    void gowindow(MouseEvent event) {
        if (event.getSource() == profile) {
            home.setVisible(false);
            profile_panal.setVisible(true);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            notice_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            display_profile_panal.setVisible(true);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            newprofile.setVisible(true);

        } else if (event.getSource() == attendance_and_medical) {
            attendance_and_medical_panal.setVisible(true);
            home.setVisible(false);
            profile_panal.setVisible(false);
            courses_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            notice_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            attendence.setVisible(true);

        } else if (event.getSource() == grade_abd_gpa) {
            home.setVisible(false);
            profile_panal.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(true);
            notice_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);

        } else if (event.getSource() == notice) {
            home.setVisible(false);
            profile_panal.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            notice_panal.setVisible(true);
            Time_table_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);

        } else if (event.getSource() == courses) {
            home.setVisible(false);
            profile_panal.setVisible(false);
            courses_panal.setVisible(true);
            attendance_and_medical_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            notice_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);

        } else if (event.getSource() == time_table) {
            home.setVisible(false);
            profile_panal.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            notice_panal.setVisible(false);
            Time_table_panal.setVisible(true);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);

        }

    }

    @FXML
    void back(ActionEvent event) {
        profile_panal.setVisible(false);
        home.setVisible(true);
        courses_panal.setVisible(false);
        attendance_and_medical_panal.setVisible(false);
        Time_table_panal.setVisible(false);
        notice_panal.setVisible(false);
        grade_abd_gpa_panal.setVisible(false);
        display_profile_panal.setVisible(false);
        profile_image_panal.setVisible(false);
        edit_profile_panals.setVisible(false);
    }

    @FXML
    void back_p(ActionEvent event) {
        profile_panal.setVisible(true);
        home.setVisible(false);
        courses_panal.setVisible(false);
        attendance_and_medical_panal.setVisible(false);
        Time_table_panal.setVisible(false);
        notice_panal.setVisible(false);
        grade_abd_gpa_panal.setVisible(false);
        display_profile_panal.setVisible(true);
        profile_image_panal.setVisible(false);
        edit_profile_panals.setVisible(false);

    }

    @FXML
    void Editprofile(ActionEvent event) {
        display_profile_panal.setVisible(false);
        edit_profile_panals.setVisible(true);
        profile_image_panal.setVisible(true);

    }

    @FXML
    void back_course(ActionEvent event) {
        profile_panal.setVisible(true);
        home.setVisible(false);
        courses_panal.setVisible(true);
        attendance_and_medical_panal.setVisible(false);
        Time_table_panal.setVisible(false);
        notice_panal.setVisible(false);
        grade_abd_gpa_panal.setVisible(false);
        display_profile_panal.setVisible(false);
        profile_image_panal.setVisible(false);
        edit_profile_panals.setVisible(false);
        cour_dll.setVisible(false);


    }

    @FXML
    void gocourse_delails(MouseEvent event) {
        if (event.getSource() == image_d) {
            profile_panal.setVisible(false);
            home.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            notice_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            cour_dll.setVisible(true);

             cd = "ICT2152";




        } else if(event.getSource() == image_e){
            profile_panal.setVisible(false);
            home.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            notice_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            cour_dll.setVisible(true);
            cd= "ICT2142";



        } else if (event.getSource() == image_ooa) {
            profile_panal.setVisible(false);
            home.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            notice_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            cour_dll.setVisible(true);
            cd= "ICT2133";


        }else if (event.getSource() == image_oopp) {
            profile_panal.setVisible(false);
            home.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            notice_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            cour_dll.setVisible(true);
            cd= "ICT2122";



        }else if(event.getSource() == image_oop ){
            cd= "ICT2113";
            profile_panal.setVisible(false);
            home.setVisible(false);
            courses_panal.setVisible(false);
            attendance_and_medical_panal.setVisible(false);
            Time_table_panal.setVisible(false);
            notice_panal.setVisible(false);
            grade_abd_gpa_panal.setVisible(false);
            display_profile_panal.setVisible(false);
            profile_image_panal.setVisible(false);
            edit_profile_panals.setVisible(false);
            cour_dll.setVisible(true);
            course_metirials.setVisible(true);







    }
        ShowmyCourseDetils();
        showSession();
    }


            @FXML
    void Go_Medical(ActionEvent event) {
        profile_panal.setVisible(false);
        home.setVisible(false);
        courses_panal.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        Time_table_panal.setVisible(false);
        notice_panal.setVisible(false);
        grade_abd_gpa_panal.setVisible(false);
        display_profile_panal.setVisible(false);
        profile_image_panal.setVisible(false);
        edit_profile_panals.setVisible(false);
        cour_dll.setVisible(false);
        Medical_details.setVisible(true);
        attendence.setVisible(false);


    }

    @FXML
    void aad_medical(ActionEvent event) {
        Medical_details.setVisible(false);
        attendence.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(true);


    }

    @FXML
    void back_add_medical(ActionEvent event) {
        Medical_details.setVisible(true);
        attendence.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);

    }

    @FXML
    void back_attendance(ActionEvent event) {
        Medical_details.setVisible(false);
        attendence.setVisible(true);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);


    }

    @FXML
    void view(ActionEvent event) {
        attCCId = seach.getText();
        calAttPresent(attCCId);
        Medical_details.setVisible(false);
        attendence.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);
        viwe_attendence.setVisible(true);
        getattendancelist();

        ObservableList<attendance> list = getattendancelist();


        attendance_Course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        attendance_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        attendance_Attendance_State.setCellValueFactory(new PropertyValueFactory<>("att_state"));
        attendance_new.setItems(list);


    }

    @FXML
    void backto_attendance(ActionEvent event) {
        Medical_details.setVisible(false);
        attendence.setVisible(true);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);
        viwe_attendence.setVisible(false);

    }

    @FXML
    private TextField student_email;

    @FXML
    private TextField student_first_name;

    @FXML
    private TextField student_last_name;

      //start to update

    @FXML
    private Label profile_name;



    public ObservableList<studentInformation>getstudent() {
        ObservableList<studentInformation> stuList = FXCollections.observableArrayList();
        Connection con= Config.getConfig();
        String sql = "select * from user where userId = '" + username + "'";
        Statement st;
        ResultSet rs;

        try {
        st = con.createStatement();
        rs = st.executeQuery(sql);
        studentInformation StudentInformation;
        while (rs.next()) {
            StudentInformation = new studentInformation(rs.getString("f_name"),rs.getString("l_name"),rs.getString("email"));
            stuList.add(StudentInformation);
            System.out.println("user id " + rs.getString("f_name"));
        }
        }catch (Exception ex){
            ex.printStackTrace();

        }
        return stuList;

    }


    public void showStudentDetails(){
        ObservableList<studentInformation> stuList = getstudent();
        studentInformation stu = stuList.get(0);
        student_first_name.setText(stu.getF_name());
        student_last_name.setText(stu.getL_name());
        student_email.setText(stu.getEmail());

}







    public void SetStuname(){
        ObservableList<studentInformation> stuList = getstudent();
        studentInformation stu = stuList.get(0);
        name.setText(stu.getstuFullName());
        profile_name.setText(stu.getstuFullName());

    }




    @FXML
    void studentUpdate(ActionEvent event) {   // update
        studentUpdate();

    }

    public void studentUpdate(){
        Connection con = Config.getConfig();
        String f_name = student_first_name.getText();
        String l_name = student_last_name.getText();
        String email = student_email.getText();



        String stUpdateSql = "UPDATE user SET f_name = ?,l_name = ? ,email = ? WHERE userId = '"+username+"'";

        try{



            PreparedStatement userst = con.prepareStatement(stUpdateSql);
            userst.setString(1, f_name);
            userst.setString(2, l_name );
            userst.setString(3, email);

            userst.executeUpdate();

            Alert updatedAlert = new Alert(Alert.AlertType.INFORMATION);
            updatedAlert.setTitle("student Updated");
            updatedAlert.setHeaderText(null);
            updatedAlert.setContentText("Student updated successfully!");
            updatedAlert.showAndWait();
        } catch (Exception e){
            System.out.println("Error " + e.getMessage());
        }

        SetStuname();



    } //end update

//-------------------show notice--------------------//

    @FXML
    private TableColumn<Notice, String> N_Date;

    @FXML
    private TableColumn<Notice, String> N_Descreption;

    @FXML
    private TableColumn<Notice, String> N_Titale;

    @FXML
    private TableView<Notice> Notice_table;



    public ObservableList<Notice> getNoticeList() {
        ObservableList<Notice> noticeList = FXCollections.observableArrayList();
        Statement st;
        ResultSet rs;

        try {
            Connection con = Config.getConfig();
            String query = "SELECT * FROM notice";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                noticeList.add(new Notice(rs.getString("date"), rs.getString("notice_title"), rs.getString("description")));

            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return noticeList;
    }

    public void showNotice() {
        ObservableList<Notice> noticeList = getNoticeList();
        N_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        N_Titale.setCellValueFactory(new PropertyValueFactory<>("notice_title"));
        N_Descreption.setCellValueFactory(new PropertyValueFactory<>("description"));
        Notice_table.setItems(noticeList);

    }
//---------------------start to show course  attendanse--------------------//
    @FXML
    private TableView<attendance_course> course_attendance;

    @FXML
    private TableColumn<attendance_course, String> att_course_Course;

    @FXML
    private TableColumn<attendance_course, String> att_course_view;

    public ObservableList<attendance_course> getatt_course_list() {
        ObservableList<attendance_course> att_course_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String query = "SELECT * FROM course";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            attendance_course Attendence_course;
            while (rs.next()) {
                Attendence_course = new attendance_course(rs.getString("course_name"),rs.getString("course_code"));
                att_course_list.add(Attendence_course);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return att_course_list;
    }

    public void showattendance_coures() {
        ObservableList<attendance_course> att_course_list = getatt_course_list();
        att_course_Course.setCellValueFactory(new PropertyValueFactory<attendance_course,String>("course_name"));
        att_course_view.setCellValueFactory(new PropertyValueFactory<attendance_course,String>("course_code"));
        course_attendance.setItems(att_course_list);
    }


    //--------medical ditalse---------//

    @FXML
    private TableView<medical_detalse> medical_details_table;

    @FXML
    private TableColumn<medical_detalse, String> medical_Course_Code;

    @FXML
    private TableColumn<medical_detalse, String> medical_Desccription;

    @FXML
    private TableColumn<medical_detalse, String> medical_End;

    @FXML
    private TableColumn<medical_detalse, String> medical_Start_Date;

    @FXML
    private TableColumn<medical_detalse, String> medical_Student_Id;


    public ObservableList<medical_detalse> getmedicale_detalselist() {
        ObservableList<medical_detalse> medical_detalses_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String query = "SELECT * FROM medical where  student_id = '" + username + "'";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            medical_detalse md;
            while (rs.next()) {
                md = new medical_detalse(rs.getString("course_code"),
                        rs.getString("student_id"),
                        rs.getString("s_date"),
                        rs.getString("e_date"),
                        rs.getString("description"));
                medical_detalses_list.add(md);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return medical_detalses_list;
    }

    public void showmedical_details() {
        ObservableList<medical_detalse> medical_detalses_list = getmedicale_detalselist();
        medical_Course_Code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        medical_Student_Id.setCellValueFactory(new PropertyValueFactory<>("student_id"));
        medical_Start_Date.setCellValueFactory(new PropertyValueFactory<>("s_date"));
        medical_End.setCellValueFactory(new PropertyValueFactory<>("e_date"));
        medical_Desccription.setCellValueFactory(new PropertyValueFactory<>("description"));
        medical_details_table.setItems(medical_detalses_list);
    }


    //-------------attendance------------------//

    @FXML
    private TextField seach;

    @FXML
    private TableColumn<attendance, String> attendance_Attendance_State;

    @FXML
    private TableColumn<attendance, String> attendance_Course_code;

    @FXML
    private TableColumn<attendance, String> attendance_Date;

    @FXML
    private TableView<attendance> attendance_new;


    public ObservableList<attendance> getattendancelist() {
        ObservableList<attendance> attendances_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        System.out.println(attCCId);
        String query = "SELECT * FROM attendence WHERE student_id = '" + username + "' AND course_code = '" + attCCId + "'";


        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            attendance att;
            while (rs.next()) {
                att=new attendance(rs.getString("course_code"),rs.getString("date"),rs.getString("att_state") );
                attendances_list.add(att);
            }



        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return attendances_list;
    }

    public void showattendance() {
        ObservableList<attendance> attendances_list = getattendancelist();
        attendance_Course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        attendance_Date.setCellValueFactory(new PropertyValueFactory<>("date"));
        attendance_Attendance_State.setCellValueFactory(new PropertyValueFactory<>("att_state"));
        attendance_new.setItems(attendances_list);
    }

    @FXML
    private Label attendance_presentage;

    public void calAttPresent(String cID) {
        Connection con = Config.getConfig();
        String query = "SELECT COUNT(att_state) AS attCount FROM attendence WHERE student_id = '" + username + "' AND (att_state = 'Present' OR att_state='Medical') AND course_code = '" + cID + "'";
        Statement st = null;
        ResultSet rs = null;
        int q1 = 0;

        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            if (rs.next()) {
                q1 = Integer.parseInt(rs.getString("attCount"));
                System.out.println("Present count: " + q1);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String query2 = "SELECT COUNT(att_state) AS attCountm FROM attendence WHERE student_id = '" + username + "' AND course_code = '" + cID + "'";
        Statement stm = null;
        ResultSet rsm = null;
        int q2 = 0;

        try {
            stm = con.createStatement();
            rsm = stm.executeQuery(query2);
            if (rsm.next()) {
                q2 = Integer.parseInt(rsm.getString("attCountm"));
                System.out.println("Total count: " + q2);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        if (q2 != 0) {
            int percentage = (q1 * 100) / q2;
            attendance_presentage.setText(percentage + "%");
        } else {
            attendance_presentage.setText("0%");
        }
    }




    //-----------profile detailes-------------//

    @FXML
    private ImageView myprofile;

    @FXML
    private Label ad;

    @FXML
    private Label bod;

    @FXML
    private Label em;

    @FXML
    private Label fn;

    @FXML
    private Label ln;

    @FXML
    private Label nc;

    public  ObservableList<Profile_detailes> getProfile(){
        ObservableList<Profile_detailes> profileList = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String sql = "select * from user where userId = '" + username + "'";
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            Profile_detailes pro;
            while (rs.next()){
                pro = new Profile_detailes(
                        rs.getString("f_name"),
                        rs.getString("l_name"),
                        rs.getString("nic"),
                        rs.getString("bod"),
                        rs.getString("address"),
                        rs.getString("email")
                );
                profileList.add(pro);

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return profileList;
    }

    public void ShowCourseDetils() {
        ObservableList<Profile_detailes> profileList = getProfile();
        Profile_detailes profile = profileList.get(0);
        fn.setText(profile.getF_name());
        ln.setText(profile.getL_name());
        nc.setText(profile.getNic());
        bod.setText(profile.getBod());
        ad.setText(profile.getAddress());
        em.setText(profile.getEmail());


    }


    //-------course detailse-----------//

    @FXML
    private AnchorPane course_metirials;



    @FXML
    private Label courses_detalse_course_code;


    @FXML
    private Label course_cradit;

    @FXML
    private Label course_hours;

    @FXML
    private Label course_name;

    @FXML
    private Label course_type;


    public  ObservableList<Course_detailes> getcourse(){
        ObservableList<Course_detailes> courseList = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        System.out.println(cd);
        String sql = "select * from course where course_code   = '" + cd + "'" ;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            Course_detailes cor;
            while (rs.next()){
                cor = new Course_detailes(
                        rs.getString("course_code"),
                        rs.getString("course_name"),
                        rs.getString("course_credit"),
                        rs.getString("course_houre"),
                        rs.getString("course_type")
                );
                courseList.add(cor);

            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return courseList;
    }

    public void ShowmyCourseDetils() {
        ObservableList<Course_detailes> courseList = getcourse();

        if (!courseList.isEmpty()) {
            Course_detailes course = courseList.get(0);
            courses_detalse_course_code.setText(course.getCourse_code());
            course_name.setText(course.getCourse_name());
            course_cradit.setText(course.getCourse_credit());
            course_hours.setText(course.getCourse_houre());
            course_type.setText(course.getCourse_type());
        } else {
            System.out.println("⚠ No course data found for cd: " + cd);
            // You can also clear the fields or show an error label here
        }
    }




    //-------------downlod course metireails---------//

    @FXML
    private TextField sessionl;

    @FXML
    private TableView<Session> sesion_table;


    @FXML
    void downloadPdf(ActionEvent event) {

        Session selectedSession = sesion_table.getSelectionModel().getSelectedItem();

        if (selectedSession != null) {
            File sourceFile = new File(selectedSession.getFile_path());
            System.out.println("file :"+sourceFile);

                downloadPdf(sourceFile);

        } else {
            System.out.println("No session selected!");
        }
    }

    @FXML
    void handle_session(MouseEvent event) {
        Session mark = sesion_table.getSelectionModel().getSelectedItem();
        if (mark != null) {
            sessionl.setText(mark.getFile_path());

        }
    }

    private void downloadPdf(File sourceFile) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save PDF File");

            fileChooser.setInitialFileName(sourceFile.getName());

            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files (*.pdf)", "*.pdf"));

            File targetFile = fileChooser.showSaveDialog(new Stage());

            if (targetFile != null) {
                Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Downloaded to: " + targetFile.getAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
            e.printStackTrace();
        }
    }




    //----------Session desply-------------//





    @FXML
    private TableColumn<Session, String> session;
    @FXML
    private TableColumn<Session, String> file_path_course;

    public ObservableList<Session> getSession() {
        ObservableList<Session> Session_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        System.out.println("new"+cd);
        String query = "select * from lecture_matrials where course_code   = '" + cd + "'" ;
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Session se;
            while (rs.next()) {
                se = new Session(rs.getString("session_type"),rs.getString("file_path"));
                Session_list.add(se);
                System.out.println(rs.getString("session_type"));
                System.out.println(rs.getString("file_path"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Session_list;
    }

    public void showSession() {
        ObservableList<Session> Session_list = getSession();
        session.setCellValueFactory(new PropertyValueFactory<>("session_type"));
        file_path_course.setCellValueFactory(new PropertyValueFactory<>("file_path"));

        sesion_table.setItems(Session_list);
    }



//--------------------Profile image update-----------------------------------------------------------//

    @FXML
    private ImageView profile_image;

@FXML
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

                profile_image.setImage(new Image(destFile.toURI().toString()));
                myprofile.setImage(new Image(destFile.toURI().toString()));


 // your target user

                // check if user already has photo
                String checkSql = "SELECT user_img FROM user WHERE userId = ?";
                PreparedStatement checkPs = con.prepareStatement(checkSql);
                checkPs.setString(1, username);
                ResultSet rs = checkPs.executeQuery();

                if (rs.next()) {
                    // update photo
                    String updateSql = "UPDATE user SET user_img = ? WHERE userId = ?";
                    PreparedStatement updatePs = con.prepareStatement(updateSql);
                    updatePs.setString(1, String.valueOf(destFile));
                    updatePs.setString(2, username);
                    updatePs.executeUpdate();
                    updatePs.close();
                } else {
                    // insert user + photo (only if needed)
                    String insertSql = "INSERT INTO user (userId, user_img) VALUES (?, ?)";
                    PreparedStatement insertPs = con.prepareStatement(insertSql);
                    insertPs.setString(1, username);
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
                        profile_image.setImage(img);
                        myprofile.setImage(img);
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


    //-------------  Time table      ---------------------//

    @FXML
    private ComboBox<String> tdepartment;

    @FXML
    private ComboBox<String> tlevel;

    @FXML
    private ComboBox<String> tsemester;

    @FXML
    private ImageView timetableimage;

    @FXML
    void TimetableDetailsfind(ActionEvent event) {
        loadTimeImage();

    }

    public String levelType(){
        ObservableList<String> List = FXCollections.observableArrayList("Level 1","Level 2","Level 3","Level 4");
        tlevel.setItems(List);
        return String.valueOf(List);
    }
    public String semsterType(){
        ObservableList<String> List = FXCollections.observableArrayList("Semester 1","Semester 2");
        tsemester.setItems(List);
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
    public void setDepName(){
        ObservableList<String> dep = getDepartmentNameList();
        tdepartment.setItems(dep);
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
        String level = tlevel.getValue();
        String semester = tsemester.getValue();
        Object DepName = tdepartment.getSelectionModel().getSelectedItem();
        String ld = setDepId(DepName);
        try {
            Connection con = Config.getConfig();

            System.out.println("Selected Department: " + ld);
            System.out.println("Selected Level: " + level);
            System.out.println("Selected Semester: " + semester);

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
                        timetableimage.setImage(img);
                    } else {
                        System.out.println("Image file not found at: " + pdfPath);
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



    //------ GRADE and GPA ------------------//


    @FXML
    private TableColumn<Greads, String> g_course_code;

    @FXML
    private TableColumn<Greads, String> g_greads;

    @FXML
    private TableView<Greads> grades;

    public ObservableList<Greads> getGreadslist() {
        ObservableList<Greads> Greads_list = FXCollections.observableArrayList();
        Connection con = Config.getConfig();
        String query = "SELECT * FROM final_mark where  student_id = '" + username + "'";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Greads gd;
            while (rs.next()) {
                gd = new Greads(rs.getString("course_code"),
                        rs.getString("grade")
                       );
                Greads_list.add(gd);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Greads_list;
    }

    public void showGreads() {
        ObservableList<Greads> Greads_list = getGreadslist();
        g_course_code.setCellValueFactory(new PropertyValueFactory<>("course_code"));
        g_greads.setCellValueFactory(new PropertyValueFactory<>("final_mark"));

        grades.setItems(Greads_list);
    }

    //-------------GPA-------------------------------//


    public class SGPA_CGPACalculator {

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

        public void main(String[] args) {
            Connection con = Config.getConfig(); // Your DB connection

            // 1. Load course credits dynamically from 'course' table
            HashMap<String, Integer> courseCredits = new HashMap<>();
            try (
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT course_code, course_credit FROM course")
            ) {
                while (rs.next()) {
                    String courseCode = rs.getString("course_code");
                    int credit = rs.getInt("course_credit"); // course_credit is int
                    if (!rs.wasNull()) { // check if course_credit is NULL
                        courseCredits.put(courseCode, credit);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error loading course credits: " + e.getMessage());
                return;
            }

            // 2. Now read final marks and grades
            String sql = "SELECT student_id, course_code, grade FROM final_mark where student_id = '" + username + "'";

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

                    if (!studentGradePoints.containsKey(studentId)) {
                        studentGradePoints.put(studentId, new ArrayList<>());
                        studentCredits.put(studentId, new ArrayList<>());
                    }

                    studentGradePoints.get(studentId).add(gradePoint);
                    studentCredits.get(studentId).add(credit);
                }

                // 3. Calculate SGPA and CGPA
                System.out.printf("%-10s %-10s %-10s%n", "StudentID", "SGPA", "CGPA");
                System.out.println("-----------------------------------------");

                for (String studentId : studentGradePoints.keySet()) {
                    ArrayList<Double> grades = studentGradePoints.get(studentId);
                    ArrayList<Integer> credits = studentCredits.get(studentId);

                    double sgpa = calculateSGPA(grades, credits);
                    ArrayList<Double> sgpaList = new ArrayList<>();
                    sgpaList.add(sgpa);

                    double cgpa = calculateCGPA(sgpaList);

                    System.out.printf("%-10s %-10.2f %-10.2f%n", studentId, sgpa, cgpa);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void calculateGPA(String username) {
        Connection con = Config.getConfig();

        HashMap<String, Integer> courseCredits = new HashMap<>();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT course_code, course_credit FROM course")) {
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

        String sql = "SELECT student_id, course_code, grade FROM final_mark WHERE student_id = '" + username + "'";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ArrayList<Double> gradePoints = new ArrayList<>();
            ArrayList<Integer> credits = new ArrayList<>();

            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                String grade = rs.getString("grade");

                double gradePoint = SGPA_CGPACalculator.getPoint(grade);
                int credit = courseCredits.getOrDefault(courseCode, 0);

                gradePoints.add(gradePoint);
                credits.add(credit);
            }

            double sgpa = SGPA_CGPACalculator.calculateSGPA(gradePoints, credits);
            double cgpa = sgpa;


            gpa.setText(String.format("%.2f", cgpa));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showattendance_coures();
        showNotice();
        showmedical_details();
        showattendance();
        SetStuname();
        showStudentDetails();
        ShowCourseDetils();
        showGreads();
        setDepName();
        levelType();
        semsterType();
        calculateGPA(username);


        loadUserImage(username);

    }

}
