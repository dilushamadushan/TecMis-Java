package app.tecmis;

import app.tecmis.admin.Admin;
import app.tecmis.connection.Config;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {

    private String _userName;
    private String _pass;
    private String user_type;

    private Stage stage;
    private Scene scene;
    private Parent root;

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

        if(_userName.equals("") || _pass.equals("")){
            loginError.setText("Username or Password is Empty");
        }

        Connection conn = Config.getConfig();
        LoginController loginController = new LoginController();

        String userQuery = "SELECT * FROM user";
        Statement st = null;
        ResultSet rs = null;

        try{
            st = conn.createStatement();
            rs = st.executeQuery(userQuery);

            while(rs.next()){
                user_type = rs.getString("user_type");
                uID = rs.getString("userId");
                uPass = rs.getString("password");

                if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("admin")){
                    alertMsg();
                    loginAdminDashBord(event);
                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("lecture")){
                    lecTg = _userName;
                    alertMsg();
                    loginLectureDashBord(event);
                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("tech") ){
                    techOfficerTg = _userName;
                    alertMsg();
                    if(techOfficerTg.equals("TEC001")) {
                        loginTechOfficerDashBordM(event);
                    } else if(techOfficerTg.equals("TEC004")) {
                        loginTechOfficerDashBordA(event);
                    }else{
                        loginTechOfficerDashBordA(event);
                    }
                }else if(_userName.equals(uID) && _pass.equals(uPass) && user_type.equals("student")){
                    stuTg = _userName;
                    alertMsg();
                    loginStudentDashBord(event);
                }
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        System.out.println("Login button pressed");
    }

    public void alertMsg(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login Successful");
        alert.setHeaderText("Welcome to the System!");
        DialogPane dialogPane = alert.getDialogPane();
        alert.showAndWait();
    }

    void loginAdminDashBord(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("admin-panel/admin-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,700);
        Stage stage = new Stage();
        stage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("media/user.png"));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    void loginLectureDashBord(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lecture_panel/lecture.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,700);
        Stage stage = new Stage();
        stage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("media/user.png"));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    void loginStudentDashBord(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("student-panel/student-panel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,700);
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle("Faculty of Technology, Management System");
        Image img = new Image(getClass().getResourceAsStream("media/user.png"));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    void loginTechOfficerDashBordM(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("techOfficer-panel/techofficer_medical.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,700);
        Stage stage = new Stage();
        stage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("media/user.png"));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    void loginTechOfficerDashBordA(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("techOfficer-panel/techofficer_Attendence.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),1200,700);
        Stage stage = new Stage();
        stage.setResizable(false);
        Image img = new Image(getClass().getResourceAsStream("media/user.png"));
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void loginCloseBtn(MouseEvent event) {
        Platform.exit();
    }

}
