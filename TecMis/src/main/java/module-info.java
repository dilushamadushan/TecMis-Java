module app.tecmis {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.tecmis to javafx.fxml;
    exports app.tecmis;
}