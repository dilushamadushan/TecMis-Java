module app.tecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.tecmis to javafx.fxml;
    exports app.tecmis;
}