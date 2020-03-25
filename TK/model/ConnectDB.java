package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB implements DatabaseInfo{
    public static Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            conn = DriverManager.getConnection(dbURL, userDB, passDB);
            //conn = DriverManager.getConnection(dbURL);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");            
        }
        return conn;
    }    
}
