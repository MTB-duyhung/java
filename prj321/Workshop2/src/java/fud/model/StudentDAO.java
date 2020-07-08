/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fud.model;

import fud.helper.DatabaseHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class StudentDAO {

    public StudentDAO() {
    }
    List<Student> list = new ArrayList<Student>();

    public List<Student> getAll() {
        try {
            Connection con = DatabaseHelper.openConnection();
            String sql = "select * from info";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                boolean gender = rs.getBoolean("Gender");
                Date dob = rs.getDate("DOB");
                Student s = new Student(id, name, gender, dob);
                list.add(s);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Student s) throws Exception {
        int rc=0;
        Connection con = DatabaseHelper.openConnection();
        String sql = "Update [info] set Name=?, Gender=?, DOB=? where ID=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, s.getName());
        stmt.setBoolean(2, s.isGender());
        stmt.setDate(3, (java.sql.Date) s.getDOB());
        stmt.setInt(4, s.getID());
        rc=stmt.executeUpdate();
        System.out.println("Update success");
        return stmt.executeUpdate() > 0;
    }

    public boolean add(Student s) throws Exception {
        Connection con = DatabaseHelper.openConnection();
        String sql = "insert into [info] (Name,Gender,DOB) values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, s.getName());
        stmt.setBoolean(2, s.isGender());
        stmt.setDate(3, (java.sql.Date) s.getDOB());
        return stmt.executeUpdate() > 0;
    }
    public boolean delete(int id) throws Exception {
        Connection con = DatabaseHelper.openConnection();
        String sql = "delete from [info] where id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        
        return stmt.executeUpdate() > 0;
    }

    public Student findByID(int ID) {
        try {
            Connection con = DatabaseHelper.openConnection();
            String sql = "select * from [info] where ID=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, ID);
            try (ResultSet rs = stm.executeQuery();) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setID(rs.getInt("ID"));
                    s.setName(rs.getString("Name"));
                    s.setGender(rs.getBoolean("Gender"));
                    s.setDOB(rs.getDate("DOB"));
                    return s;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
