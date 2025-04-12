package app.tecmis;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

       // FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("lecture_panel/lecture.fxml"));
       FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 450);
       // Scene scene = new Scene(fxmlLoader.load(), 707, 500);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}