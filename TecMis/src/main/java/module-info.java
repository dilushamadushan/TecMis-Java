module app.tecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens app.tecmis to javafx.fxml;
    exports app.tecmis;
    exports app.tecmis.admin;
    exports app.tecmis.student;
    exports app.tecmis.techOfficer;
    exports app.tecmis.lecture;


    opens app.tecmis.admin to javafx.fxml;
    opens app.tecmis.student to javafx.fxml;
    opens app.tecmis.techOfficer to javafx.fxml;
    opens app.tecmis.lecture to javafx.fxml;

    exports app.tecmis.connection;
    opens app.tecmis.connection to javafx.fxml;

}