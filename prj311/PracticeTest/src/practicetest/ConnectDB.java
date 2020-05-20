package practicetest;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB implements DatabaseInfo{
    public static Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");            
        }
        return conn;
    }    
}