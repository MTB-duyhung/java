package Controller;

import Model.Book;
import Model.BookDB;

import java.util.ArrayList;
import java.util.Vector;
import java.util.Collections;

public class BookController {
    BookDB bookDB=new BookDB();   
    
    //Get Book by BookID
    public Book getBook(String aBookID){
        Book b=bookDB.getBook(aBookID);
        return b;
    }
    
    //Get all of Books -> Vector
    public Vector<Book> getAllBooks(){  
        Vector vBooks = new Vector();        
        ArrayList<Book> allBooks=bookDB.getAllBooks();
        for (Book e: allBooks){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getBookID());
            v.add(e.getTitle());
            v.add(e.getAuthor());
            v.add(e.getCategory());
            v.add(e.getKeyword());
            vBooks.add(v);
        }              
        return vBooks;
    }
    
    //Add a new Book
    public int addNewBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        int rc=bookDB.addNewBook(aBookID, aTitle, aAuthor, aCategory, aKeyword);
        return rc;
    }
    
    //Update a Book
    public int updateBook(String aBookID, String aTitle, String aAuthor, String aCategory, String aKeyword){
        int rc=bookDB.updateBook(aBookID, aTitle, aAuthor, aCategory, aKeyword);
        return rc;
    }
    
    //Delete a Book
    public int deleteBook(String aBookID){
        int rc=bookDB.deleteBook(aBookID);
        return rc;
    }
    
    //Search Book by Title -> Vector
    public Vector<Book> searchByTitle(String aTitle){             
        Vector vBooks = new Vector();        
        ArrayList<Book> tBooks=bookDB.searchByTitle(aTitle);
        for (Book e: tBooks){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getBookID());
            v.add(e.getTitle());
            v.add(e.getAuthor());
            v.add(e.getCategory());
            v.add(e.getKeyword());
            vBooks.add(v);
        }              
        return vBooks;
    }
    
    //Search Book by Author -> Vector
    public Vector<Book> searchByAuthor(String aAuthor){       
        Vector vBooks = new Vector();        
        ArrayList<Book> aBooks=bookDB.searchByAuthor(aAuthor);
        for (Book e: aBooks){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getBookID());
            v.add(e.getTitle());
            v.add(e.getAuthor());
            v.add(e.getCategory());
            v.add(e.getKeyword());
            vBooks.add(v);
        }              
        return vBooks;
    }
    
    //Search Book by Author -> Vector
    public Vector<Book> searchByCategory(String aCategory){             
        Vector vBooks = new Vector();        
        ArrayList<Book> cBooks=bookDB.searchByCategory(aCategory);
        for (Book e: cBooks){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getBookID());
            v.add(e.getTitle());
            v.add(e.getAuthor());
            v.add(e.getCategory());
            v.add(e.getKeyword());
            vBooks.add(v);
        }              
        return vBooks;
    }
    
     //Search Book by Keyword -> Vector
    public Vector<Book> searchByKeyword(String aKeyword){     
        Vector vBooks = new Vector();        
        ArrayList<Book> kBooks=bookDB.searchByKeyword(aKeyword);
        for (Book e: kBooks){             
            Vector<String> v=new Vector<>(); 
            v.add(e.getBookID());
            v.add(e.getTitle());
            v.add(e.getAuthor());
            v.add(e.getCategory());
            v.add(e.getKeyword());
            vBooks.add(v);
        }              
        return vBooks;
    }
}
