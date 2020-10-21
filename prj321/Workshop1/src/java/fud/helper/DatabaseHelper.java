/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class DatabaseHelper {

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        String connectionUrl = "jdbc:sqlserver://NHANLTTDE140100\\YETSQLSERVER:1433;databaseName=PRJ321_Nhanllt_DE140100;User=sa;Password=7415963";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }
}
