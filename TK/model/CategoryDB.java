package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDB {
    
    //Get Category by CatID
    public Category getCat(String aCatID){
        Category c=null;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql="Select * from Category where CatID='"+aCatID+"'";
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
               String catID=rs.getString(1);
               String catName=rs.getString(2);               
               c=new Category(catID,catName);
            }            
            conn.close();
            System.out.println("Get Category successfully!");
        } catch (Exception ex) {
            System.out.println("Get Category failure!");            
        }  
        return c;
    }  
    
    //Get all of Categories -> ArrayList
    public ArrayList<Category> getAllCats(){
        ArrayList<Category> allCategories=new ArrayList<>();       
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery("Select * from Category");
            while(rs.next()){
               String castID=rs.getString(1);
               String castName=rs.getString(2);               
               Category c=new Category(castID,castName);
               c.toString();
               allCategories.add(c);
            }            
            conn.close();
            System.out.println("Get all of Categories successfully!");
        } catch (Exception ex) {
            System.out.println("Get all of Categories failure!");            
        }  
        return allCategories;
    }  
    
    //Add a new Category
    public int addNewCat(String aCatID, String aCatName){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "INSERT INTO Category(CatID, CatName) VALUES(?,?)";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1,aCatID);
            stmt.setString(2,aCatName);                       
            rc=stmt.executeUpdate();          
            conn.close();
            System.out.println("Add Category successfully!");            
        } catch (Exception ex) {
            System.out.println("Add Category failure!");            
        }  
        return rc;
    }
    
    //Update a Category
    public int updateCat(String aCatID, String aCatName){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "Update Category set CatName=? where CatID=?";
            PreparedStatement stmt= conn.prepareStatement(sql);
            stmt.setString(1,aCatName);    
            stmt.setString(5,aCatID);
            rc=stmt.executeUpdate();          
            conn.close();
            System.out.println("Update Category successfully!");            
        } catch (Exception ex) {
            System.out.println("Update Category failure!");            
        }  
        return rc;
    }
    
    //Delete a Category
    public int deleteCat(String aCatID){
        int rc=0;
        try {
            Connection conn;
            conn=ConnectDB.getConnection();
            String sql = "Delete from Category where CatID='"+aCatID+"'";
            Statement stmt= conn.createStatement();
            rc=stmt.executeUpdate(sql);                   
            conn.close();
            System.out.println("Delete Category successfully!");            
        } catch (Exception ex) {
            System.out.println("Delete Category failure!");            
        }  
        return rc;
    }
    
}
