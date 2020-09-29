/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0116;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class DBInfo {
        public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://localhost:1433;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    private final String userID = "sa";
    private final String password = "7415963";
}
