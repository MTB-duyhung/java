/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import static library.DatabaseInfo.dbURL;
import static library.DatabaseInfo.driverName;

/**
 *
 * @author Admin
 */
public class ConnectDB {

    public static Connection con = null;

    public static Connection getConnection() {
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL);
            System.out.println("Connect Successfully!");
        } catch (Exception e) {
            System.out.println("Connect Failure");
        }
        return con;
    }
}
