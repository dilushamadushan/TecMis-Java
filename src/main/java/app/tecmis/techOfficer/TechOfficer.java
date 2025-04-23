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
    void logOutBtn(ActionEvent event) {

    }

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
        }
        else if (event.getSource() == Medical_edit_btn) {
            System.out.println("Medical edit button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(true);
            secondStage3.setVisible(false);
            secondstage4.setVisible(false);
        }
        else if (event.getSource() == Medical_btn) {
            System.out.println("Medical button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(true);
            secondstage4.setVisible(false);
        }
        else if (event.getSource() == Medical_notice_btn) {
            System.out.println("Medical notice button pressed");
            secondStage1.setVisible(false);
            secondStage2.setVisible(false);
            secondStage3.setVisible(false);
            secondstage4.setVisible(true);
        }

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
