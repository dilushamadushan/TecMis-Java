package app.tecmis.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
    private static final  String _url = "jdbc:mysql://localhost:3306/tecmis";
    private static final  String _user = "root";
    private static final  String _password = "";

    private static Connection con = null;

    public static Connection getConfig() {
        if (con == null) {
            try{
                con = DriverManager.getConnection(_url,_user,_password);
                System.out.println("Connection established");
            }catch (SQLException e){
                System.out.println("Connection failed " + e.getMessage());
                e.printStackTrace();
            }
        }
        return con;
    }
}
