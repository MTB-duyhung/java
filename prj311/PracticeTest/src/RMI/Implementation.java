/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import practicetest.ConnectDB;

/**
 *
 * @author Admin
 */
public class Implementation extends UnicastRemoteObject implements RemoteInterface{

    public static Connection conn = null;

    @Override
    public String list(String EmpID) throws RemoteException {
        try {
            conn = ConnectDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from Emp_DE140100 where Emp_id = '" + EmpID + "'");
            while (rs.next()) {
                String empID = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String gender = rs.getString(4);
                String email = rs.getString(5);
                return "Emp: " + empID + ", " + lastName + ", " + firstName + ", " + gender + ", " + email;
            }
        } catch (Exception ex) {
            System.err.println("failure!");
        }
        return null;
    }
}
