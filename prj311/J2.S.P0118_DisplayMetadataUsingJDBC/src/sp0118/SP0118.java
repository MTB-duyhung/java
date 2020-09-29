/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp0118;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;


/**
 *
 * @author PC
 */
public class SP0118 {

    public static void main(String[] args) {
        try {
            DBInfo dbc = new DBInfo();
            DatabaseMetaData dbmd = dbc.getConnection().getMetaData();
            ResultSet rs = null;
            String table[]={"TABLE"};
            System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
            System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name: " + dbmd.getDriverName());
            System.out.println("Driver Version: " + dbmd.getDriverVersion());
            System.out.println("UserName: " + dbmd.getUserName());
            System.out.println("List table in database:");
            rs = dbmd.getTables(null,null, "%", table);
            while (rs.next()) {                
                System.out.println(rs.getString(3));
            }
            dbc.getConnection().close();
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
    }
}
