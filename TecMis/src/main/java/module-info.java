module app.tecmis {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens app.tecmis to javafx.fxml;
    exports app.tecmis;
    exports app.tecmis.admin;
    exports app.tecmis.student;
    exports app.tecmis.techOfficer;



    opens app.tecmis.admin to javafx.fxml;
    opens app.tecmis.student to javafx.fxml;
    opens app.tecmis.techOfficer to javafx.fxml;









}