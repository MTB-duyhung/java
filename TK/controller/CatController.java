package Controller;

import Model.Category;
import Model.CategoryDB;

import java.util.ArrayList;
import java.util.Vector;

public class CatController {
    CategoryDB catDB=new CategoryDB();   
    
    //Get Category by CatID
    public Category getCategory(String aCatID){
        Category c=catDB.getCat(aCatID);
        return c;
    }
    
    //Get all of Categories -> Vector
    public Vector<Category> getAllCategories(){  
        Vector cCats = new Vector();        
        ArrayList<Category> allCats=catDB.getAllCats();
        for (Category e: allCats){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getCatID());
            v.add(e.getCatName());            
            cCats.add(v);
        }              
        return cCats;
    } 
    
    //Add a new Category
    public int addNewCategory(String aCatID, String aCatName){
        int rc=catDB.addNewCat(aCatID, aCatName);
        return rc;
    }
    
    //Update a Category
    public int updateCategory(String aCatID, String aCatName){
        int rc=catDB.updateCat(aCatID, aCatName);
        return rc;
    }
    
    //Delete a Category
    public int deleteBook(String aCatID){
        int rc=catDB.deleteCat(aCatID);
        return rc;
    }
}
