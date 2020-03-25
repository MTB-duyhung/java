package Model;

public class Category {
    private String catID,catName;

    //Constructor method
    public Category() {
    }

    public Category(String catID, String catName) {
        this.catID = catID;
        this.catName = catName;
    }
    
    //Get method
    public String getCatID() {
        return catID;
    }

    public String getCatName() {
        return catName;
    }
    
    //Set method
    public void setCatID(String catID) {
        this.catID = catID;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    } 
    
    //toString method
    @Override
    public String toString() {
        return "Category{" + "catID=" + catID + ", catName=" + catName + '}';
    }
    
}
