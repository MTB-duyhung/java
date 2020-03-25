/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryNhan;

import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Library {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        BookDB bdb=new BookDB();
        System.out.println(""+bdb.printAll());
//        String bid="Java";
//        System.out.println(""+bdb.searchByKeyword(bid));
;

    }
    
}
