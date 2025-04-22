package app.tecmis.techOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class TechOfficer {

    @FXML
    private Button add_attendence_btn;

    @FXML
    private Button attendence_btn;

    @FXML
    private Button attendence_btn11;

    @FXML
    private Button back_btn;

    @FXML
    private MenuButton course_selecte_btn;

    @FXML
    private Button details_btn;

    @FXML
    private Button details_btn11;

    @FXML
    private Button edit_btn;

    @FXML
    private Button edit_btn11;

    @FXML
    private Button logout_btn;

    @FXML
    private Button logout_btn11;

    @FXML
    private AnchorPane main_page1;

    @FXML
    private CheckBox mark_all_present_btn;

    @FXML
    private Button save_attendence_btn;

    @FXML
    private Pane stage1;

    @FXML
    private Pane stage2;

    @FXML
    private Pane stage3;

    @FXML
    private Pane stage4;

    @FXML
    private Button notice_btn;

    @FXML
    private Pane attendence_stage1;

    @FXML
    private Pane attendence_stage2;

    @FXML
    private Button submit_attendence_btn;

    @FXML
    void addAttendenceBtn(ActionEvent event) {

    }

    @FXML
    void attendenceBtn(ActionEvent event) {

    }

    @FXML
    void backBtn(ActionEvent event) {

    }

    @FXML
    void courseSelecteBtn(ActionEvent event) {

    }

    @FXML
    void detailsBtn(ActionEvent event) {

    }

    @FXML
    void editBtn(ActionEvent event) {

    }

    @FXML
    void logOutBtn(ActionEvent event) {

    }

    @FXML
    void markAllPresentBtn(ActionEvent event) {

    }

    @FXML
    void saveAttendenceBtn(ActionEvent event) {

    }

    @FXML
    void submitAttendenceBtn(ActionEvent event) {

    }

    @FXML
    void switchPage(ActionEvent event) {
        if(event.getSource() == details_btn) {
            System.out.println("Details button pressed");
            stage1.setVisible(true);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(false);

        }
        else if(event.getSource() == edit_btn) {
            System.out.println("Edit button pressed");
            stage1.setVisible(false);
            stage2.setVisible(true);
            stage3.setVisible(false);
            stage4.setVisible(false);


        }
        else if(event.getSource() == attendence_btn) {
            System.out.println("Attendence button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(true);
            stage4.setVisible(false);

        }
        else if(event.getSource() == notice_btn) {
            System.out.println("Notice button pressed");
            stage1.setVisible(false);
            stage2.setVisible(false);
            stage3.setVisible(false);
            stage4.setVisible(true);
        }

    }




}
