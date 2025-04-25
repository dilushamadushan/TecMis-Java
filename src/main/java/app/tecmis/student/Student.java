package app.tecmis.student;

import app.tecmis.admin.StudentDetails;
import app.tecmis.connection.Config;
import app.tecmis.student.Notice;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;




import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.Date;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class Student implements Initializable {
    public String attCCId;

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
        if (event.getSource() == image_d || event.getSource() == image_e || event.getSource() == image_ooa || event.getSource() == image_oop || event.getSource() == image_oopp) {
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
        }

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

        Medical_details.setVisible(false);
        attendence.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);
        viwe_attendence.setVisible(true);
        getattendancelist();

        ObservableList<attendance> list = getattendancelist();

        // Example: you may want to call showattendance() or directly set items
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

   String username = "TG001";   //start to update

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
//                System.out.println(rs.getString("course_name"));
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
        String query = "SELECT * FROM medical";
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





    //-----------profile detailes-------------//

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

    String course_code  ="ICT2152";

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
        String sql = "select * from course where course_code   = '" + course_code + "'" ;
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
        Course_detailes course = courseList.get(0);
        courses_detalse_course_code.setText(course.getCourse_code());
        course_name.setText(course.getCourse_name());
        course_cradit.setText(course.getCourse_credit());
        course_hours.setText(course.getCourse_houre());
        course_type.setText(course.getCourse_type());


    }

//    @FXML
//    void handleNotice(MouseEvent event) {
//
//
//        NoticeInformation notice = notice_table.getSelectionModel().getSelectedItem();
//        lbl_notice_title.setText("" + notice.getNoticeTitle());
//        lbl_date.setText(""+notice.getDate());
//        lbl_Description.setText(""+notice.getDescription());
//
//    }






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showattendance_coures();
        showNotice();
        showmedical_details();
        showattendance();
        SetStuname();
        showStudentDetails();
        ShowCourseDetils();
        ShowmyCourseDetils();
    }

}
