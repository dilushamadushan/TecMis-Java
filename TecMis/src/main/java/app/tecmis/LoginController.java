package app.tecmis;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    }

    @FXML
    void loginCloseBtn(MouseEvent event) {
        Platform.exit();
    }

}
