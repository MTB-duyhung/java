/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.connect;
import java.sql.DriverManager;
import java.sql.Connection;
/**
 *
 * @author Admin
 */
public class DBconnect implements DatabaseInfo{
    public static Connection conn = null;
    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(URL,user,pass);
//            System.out.println("Connect successfully");
        } catch (Exception e) {
//            System.out.println("Connect failure!");
        }
        return conn;
    }
    
    public static void main(String[] args) {
        DBconnect.getConnection();
    }
}
