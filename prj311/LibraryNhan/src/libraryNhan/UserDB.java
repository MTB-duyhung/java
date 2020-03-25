/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryNhan;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB implements DatabaseInfo {
 //-------------------------------------------------------------------------------
    public static boolean updateUser(String userID, String fullName, String email, String password, String status, int userRight){
        try {
            Connection con;
            con=ConnectDB.getConnection();
            PreparedStatement stmt= con.prepareStatement("Update Users set fullName=?,password=?,email=?,status=?, userright=? where userid=?");
            stmt.setString(1, fullName);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, status);
            stmt.setInt(5, userRight);
            stmt.setString(6, userID); 
            int rc=stmt.executeUpdate();
            con.close();
            return rc==1;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
 //-------------------------------------------------------------------------------   
    public static int doBookOrder(String uid, String bid){
        try {
            Connection con;
            con=ConnectDB.getConnection();
            CallableStatement stmt=con.prepareCall("{call MuonSach(?,?,?)}");
            stmt.setString(1,bid);
            stmt.setString(2,uid);
            stmt.registerOutParameter(3, 5);
            stmt.execute();
            int logid= stmt.getInt(3);
            con.close();
            return logid;
        } catch (Exception ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
   }
 //-------------------------------------------------------------------------------   
    public static User getUser(String uid){
        User s=null;
        try {
            Connection con;
            con=ConnectDB.getConnection();
            Statement stmt = ConnectDB.con.createStatement();
            ResultSet rs=stmt.executeQuery("Select fullName,email,password,status,userright from Users where userID='"+uid+"'");
            if(rs.next()){
                String fullName=rs.getString(1);
                String email=rs.getString(2);
                String password=rs.getString(3);
                String status=rs.getString(4);
                int userRight=rs.getInt(5);
                String userID=uid;
                s=new User(userID, fullName, email, password, status, userRight);
            }
            ConnectDB.con.close();
            return s;
        } catch (Exception ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
 //--------------------------------------------------------------------------------------------
    public static String addNewUser(String fName, String email, String pass, String status, String uRight){
        return null;
    }
 //--------------------------------------------------------------------------------------------   

    static boolean updateUser(User aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
