package app.tecmis.lecture;

import app.tecmis.connection.Config;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx .scene.layout.Pane;

//profile window

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;




//========================


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Lecture implements Initializable {


//profile
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
    private AnchorPane profile_part2_infor_panel;

    @FXML
    private AnchorPane profile_window_inside_part1;

    @FXML
    private AnchorPane profile_part2_Securitiy_panel;



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





    //===================


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



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



    }

}
