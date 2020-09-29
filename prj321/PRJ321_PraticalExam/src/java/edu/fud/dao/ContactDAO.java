/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fud.dao;

import edu.fud.connect.DBconnect;
import edu.fud.model.ContactInfo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Admin
 */

//Add user
public class ContactDAO {
     
     public boolean insert(String firstname, String lastname, String phonenumber, int groupId){
        
        String sql = "insert into [Contact] (FirstName, LastName, GroupID, Phone)"+"values(?,?,?,?)";
        try (Connection con = DBconnect.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql);)
            {
              stmt.setString(1, firstname);
              stmt.setString(2, lastname);
              stmt.setInt(3, groupId);
              stmt.setString(4, phonenumber);
              stmt.executeUpdate();  
              stmt.close();
              con.close();
              return true;
        } catch (SQLException ex) {
         }
        return false;
    }
    
//List all Contact
    public List<ContactInfo> getAll() throws Exception{
        List<ContactInfo> list = new ArrayList();
        String sql = "select Contact.ID, Contact.FirstName, Contact.LastName, GroupDB.GroupName, Contact.Phone from Contact inner join GroupDB on Contact.GroupID = GroupDB.ID ";
        try {
            Connection con = DBconnect.getConnection();
            PreparedStatement smt = con.prepareStatement(sql);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                ContactInfo User = new ContactInfo();
                User.setId(rs.getInt("ID"));
                User.setFirstname(rs.getString("FirstName"));
                User.setLastName(rs.getString("LastName"));
                User.setGroupName(rs.getString("GroupName"));   
                User.setPhone(rs.getString("Phone"));
                list.add(User);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }     
    
//Update a Contact
    public int updateContact(int ID, String fname, String lname, int grID, String phone) throws Exception{
        int rc=0;
        try {
            Connection con = DBconnect.getConnection();
            String sql = "Update [Contact] set FirstName=?, LastName=?, GroupID=?, Phone=? where ID='"+ID+"'";
            PreparedStatement stmt= con.prepareStatement(sql);
            stmt.setString(1, fname); 
            stmt.setString(2, lname); 
            stmt.setInt(3, grID);
            stmt.setString(4, phone); 
            rc=stmt.executeUpdate();          
            con.close();
            System.out.println("Updated User successfully!");            
        } catch (Exception ex) {
            System.out.println("Update User failed!");            
        }  
        return rc;
    }
    
//Delete a Contact
    public int delete(int id) throws Exception{
        int rc=0;
        try {
            Connection conn = DBconnect.getConnection();
            String sql = "Delete from [Contact] where ID='"+id+"'"; 
            Statement stmt= conn.createStatement();
            rc=stmt.executeUpdate(sql);                   
            conn.close();
            System.out.println("Delete Contact successfully!");            
        } catch (Exception ex) {
            System.out.println("Delete Contact failed!");            
        }  
        return rc;
    }
    
    //Search by ID
    public ContactInfo getContact(int ID){
        ContactInfo b=null;
        try {
            Connection conn = DBconnect.getConnection();
            String sql="Select * from [Contact] where ID='"+ID+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
               rs.getInt(1);
               String fname=rs.getString(2);
               String lname=rs.getString(3);
               int group = rs.getInt(4);
               String phone=rs.getString(5);
               
               b=new ContactInfo(ID, fname, lname, group, phone); 
            }            
            conn.close();
            System.out.println("Get User successfully!");
        } catch (Exception ex) {
            System.out.println("Get User failed!");            
        }  
        return b;
    } 
    
    public String getGroupName(int num){
        String g=null;
        try {
            Connection conn = DBconnect.getConnection();
            String sql="select GroupName from GroupDB where ID='"+num+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                g=rs.getString(1);
            }            
            conn.close();
            System.out.println("Get GroupName successfully!");
        } catch (Exception ex) {
            System.out.println("Get GroupName failed!");            
        }  
        return g;
    } 
}
