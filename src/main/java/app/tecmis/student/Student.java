package app.tecmis.student;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;




import java.net.URL;
import java.util.ResourceBundle;

public class Student implements Initializable {


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
    private Label course_code;

    @FXML
    private Label course_cradit;

    @FXML
    private Label course_hours;

    @FXML
    private Label course_name;

    @FXML
    private Label course_type;

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
        if(event.getSource()==profile)
        {
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

        } else if (event.getSource()==attendance_and_medical) {
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

        }else if (event.getSource()==grade_abd_gpa) {
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

        }else if (event.getSource()==notice){
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

        } else if (event.getSource()==courses) {
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

        } else if (event.getSource()==time_table) {
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
        home.setVisible(false );
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
        home.setVisible(false );
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
        if(event.getSource()==image_d || event.getSource()==image_e || event.getSource()==image_ooa || event.getSource()==image_oop || event.getSource()==image_oopp )
        {
            profile_panal.setVisible(false);
            home.setVisible(false );
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
        home.setVisible(false );
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
        Medical_details.setVisible(false);
        attendence.setVisible(false);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);
        viwe_attendence.setVisible(true);


    }

    @FXML
    void backto_attendance(ActionEvent event) {
        Medical_details.setVisible(false);
        attendence.setVisible(true);
        attendance_and_medical_panal.setVisible(true);
        aad_new_medical.setVisible(false);
        viwe_attendence.setVisible(false);

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
