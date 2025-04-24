package app.tecmis;

import app.tecmis.connection.Config;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private String _userName;
    private String _pass;
    private String user_type;

    public static String uID,uPass,stuTg,lecTg,techOfficerTg;

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

        _userName = username.getText();
        _pass = password.getText();

        Connection conn = Config.getConfig();
        LoginController loginController = new LoginController();
//        loginController.studentWindow();
//        loginController.lectureWindow();
//        loginController.techOfficerWindow();
//       loginController.adminWindow();

        String userQuery = "SELECT * FROM user";
        Statement st = null;
        ResultSet rs = null;

//        try{
//            st = conn.createStatement();
//            rs = st.executeQuery(userQuery);
//
//            while(rs.next()){
//                user_type = rs.getString("user_type");
//                uID = rs.getString("userId");
//                uPass = rs.getString("password");
//
//                if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("admin")){
//                    loginController.adminWindow();
//                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("lecture")){
//                    lecTg = _userName;
//                    loginController.lectureWindow();
//                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("tech")){
//                    techOfficerTg = _userName;
//                    loginController.techOfficerWindow();
//                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("student")){
//                    stuTg = _userName;
//                    loginController.studentWindow();
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Error : " + e.getMessage());
//        }
//        System.out.println("Login button pressed");
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
