/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import static connection.databaseInfo.dbURL;
import static connection.databaseInfo.driverName;
import static connection.databaseInfo.passDB;
import static connection.databaseInfo.userDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class DBUtil {

    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Connection con;
            Class.forName(driverName);
            con = DriverManager.getConnection(dbURL, userDB, passDB);
            return con;
    }

}
