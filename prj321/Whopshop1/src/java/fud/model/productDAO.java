/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.model;

import fud.helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class productDAO {

    public productDAO() {
    }

    public List<Product> getAll() {
        try {
            Connection con = DatabaseHelper.openConnection();
            String sql = "Select * from Product_DE140100";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            List<Product> list = new ArrayList<Product>();
            while (rs.next()) {
                String id = rs.getString("ProductID");
                String name = rs.getString("ProductName");
                String unit = rs.getString("Unit");
                float price = rs.getFloat("Price");
                Product sp = new Product(id, name, unit, price);
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean newProduct(Product p) throws Exception {
        Connection con = DatabaseHelper.openConnection();
        String sql = "Insert into Product_DE140100 values (?,?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, p.getId());
        stmt.setString(2, p.getName());
        stmt.setString(3, p.getUnit());
        stmt.setFloat(4, p.getPrice());
        return stmt.executeUpdate() > 0;
    }
}
