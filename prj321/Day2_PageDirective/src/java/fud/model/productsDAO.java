/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.model;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class productsDAO {

    public productsDAO() {
    }

    public List<Product> showProduct(String tenSP) {
        try {
            String connectionUrl = "jdbc:sqlserver://NHANLTTDE140100\\YETSQLSERVER:1433;databaseName=NHANLTT;User=sa;Password=7415963";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(connectionUrl);
            String sql = "Select * from Products";
            if (tenSP.length()>0) {
                sql += "where Name like '%" + tenSP + "%'";
            }
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Product> list = new ArrayList<Product>();
            while (rs.next()) {
                String code = rs.getString("Code");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                Product sp = new Product(code, name, price);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
   
}
