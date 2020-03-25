
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
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
