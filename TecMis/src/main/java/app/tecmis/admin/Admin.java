package app.tecmis.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Admin {

    @FXML
    private AnchorPane adminPanel;

    @FXML
    private Button courseBtn;

    @FXML
    private AnchorPane dashbord;

    @FXML
    private Button dashbordBtn;

    @FXML
    private AnchorPane lecture;

    @FXML
    private Button lectureBtn;

    @FXML
    private Button noticeBtn;

    @FXML
    private Button studentBtn;

    @FXML
    private Button techofficerBtn;

    @FXML
    private Button timeTableBtn;

    @FXML
    void logout(ActionEvent event) {

    }

    @FXML
    void navBar_link(ActionEvent event) {
        if(event.getSource()==dashbordBtn){
            dashbord.setVisible(true);
            lecture.setVisible(false);
        }else if(event.getSource()==lectureBtn){
            dashbord.setVisible(false);
            lecture.setVisible(true);
        }
    }

}
