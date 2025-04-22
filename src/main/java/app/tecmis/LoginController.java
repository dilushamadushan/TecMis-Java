package app.tecmis;

import app.tecmis.connection.Config;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    private String _userName ;
    private String _pass;
    private String _userType;

    private String tgOfficer;
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
        String u_name;
        String u_pwd;

        _userName = username.getText().trim();
        _pass = password.getText().trim();
        System.out.println(_userName + " " + _pass);

        String loginSql = "SELECT userId,password,user_type FROM user";
        LoginController loginController = new LoginController();

        if(_userName.equals("") || _pass.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }else{
            Connection con = Config.getConfig();
            try {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(loginSql);
                while(rs.next()){
                    u_name = rs.getString("userId").toLowerCase();
                    u_pwd = rs.getString("password");
                    _userType = rs.getString("user_type");

                    if(u_name.equals(_userName) && u_pwd.equals(_pass) && _userType.equals("admin")){
                        loginController.adminWindow();
                        break;
                    }else if(u_name.equals(_userName) && u_pwd.equals(_pass) && _userType.equals("student")){
                        loginController.studentWindow();
                        break;
                    }else if(u_name.equals(_userName) && u_pwd.equals(_pass) && _userType.equals("lecture")){
                        loginController.lectureWindow();
                        break;
                    }else if(u_name.equals(_userName) && u_pwd.equals(_pass) && _userType.equals("tech")){
                        loginController.techOfficerWindow();
                    }
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }catch (Exception e){
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }
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
