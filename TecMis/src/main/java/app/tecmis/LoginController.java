package app.tecmis;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label loginCloseBtn;

    @FXML
    private Label loginError;

    @FXML
    private Button login_btn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    void loginBtn(ActionEvent event){
        System.out.println("Login button pressed");
        LoginController loginController = new LoginController();
        //loginController.adminWindow();
        //loginController.studentWindow();
        //loginController.techOfficerWindow();
        loginController.lectureWindow();
    }

    public void adminWindow(){
            FXMLLoader loaderAdmin = new FXMLLoader(getClass().getResource("admin-panel/admin-panel.fxml"));
            Scene sceneAdmin = null;
            try {
                sceneAdmin = new Scene(loaderAdmin.load(),1200,700);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stageAdmin = new Stage();
            stageAdmin.setScene(sceneAdmin);
            stageAdmin.show();
    }

    public void studentWindow(){
        FXMLLoader loaderStu = new FXMLLoader(getClass().getResource("student-panel/student-panel.fxml"));
        Scene sceneStu = null;
        try {
            sceneStu = new Scene(loaderStu.load(),1200,700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stageStu = new Stage();
        stageStu.setScene(sceneStu);
        stageStu.show();
    }

    public void techOfficerWindow(){
        FXMLLoader loaderTO = new FXMLLoader(getClass().getResource("techOfficer-panel/techofficer_panel.fxml"));
        Scene sceneTO = null;
        try {
            sceneTO = new Scene(loaderTO.load(),1200,700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stageTO = new Stage();
        stageTO.setScene(sceneTO);
        stageTO.show();
    }

    public void lectureWindow(){
        FXMLLoader loaderLec = new FXMLLoader(getClass().getResource("lecture_panel/lecture.fxml"));
        Scene sceneLec = null;
        try {
            sceneLec = new Scene(loaderLec.load(),1200,700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stageLec = new Stage();
        stageLec.setScene(sceneLec);
        stageLec.show();
    }

    @FXML
    void loginCloseBtn(MouseEvent event) {
        Platform.exit();
    }

}
