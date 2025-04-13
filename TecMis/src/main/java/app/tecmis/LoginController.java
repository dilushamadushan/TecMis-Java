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
        loginController.lecturerWindow();
    }

    public void adminWindow(){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin-panel/admin-panel.fxml"));
            Scene scene = null;
            try {
                scene = new Scene(loader.load(),1200,700);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
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

    public void lecturerWindow(){
        FXMLLoader loaderTO = new FXMLLoader(getClass().getResource("lecture_panel/lecture.fxml"));
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

    @FXML
    void loginCloseBtn(MouseEvent event) {
        Platform.exit();
    }

}
