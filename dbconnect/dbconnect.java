package dbconnect;

import java.sql.*;
import java.sql.DriverManager;
//import java.util.Scanner;

public class dbconnect {
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user ="system";
    String password = "cuvyma9q";
    private Connection connection;

    private static volatile dbconnect init;

    private dbconnect(){
        try {
            System.out.println("Connecting to Database");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println( connection.toString());
            System.out.println("Connection Success");
        } catch (Exception e) {
            e.printStackTrace();
        };
    }

    public static Connection getDBConnection() {
        if (init == null) {
            synchronized (dbconnect.class) {
                if (init == null) {
                    init = new dbconnect();
                }
            }
        }
        System.out.println(init.connection);
        return init.connection;
    }
}