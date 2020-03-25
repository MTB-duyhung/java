/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab16p007xx;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LibrarianList {

    ArrayList<Librarian> ll = new ArrayList<>();

    public ArrayList<Librarian> getLl() {
        return ll;
    }
    
    public boolean loginAdmin(){
        System.out.print("Username(yet):");
        String username=Validation.checkInputString();
        System.out.print("Password(123456):");
        String password=Validation.checkInputString();
        if (username.equals("yet")&&password.equals("123456")){
            System.err.println("Login Admin successful.");
            return true;
        }else{
            System.err.println("Login Admin unsuccessful.");
            return false;
        }
    }
    public void addLibrarian( int id) {
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        System.out.print("Password: ");
        String password = Validation.checkInputString();
        System.out.print("Email: ");
        String email = Validation.checkInputString();
        System.out.print("Address: ");
        String address = Validation.checkInputString();
        System.out.print("City: ");
        String city = Validation.checkInputString();
        System.out.print("Contact No: ");
        String contact = Validation.checkInputString();
        ll.add(new Librarian(id, name, password, email, address, city, contact));
        System.err.println("Add successful.");
    }

    public void viewLibrarian() {
        System.out.printf("%-10s%-20s%-15s%-20s%-20s%-15s%-15s\n","id", "name", "password", "email", "address", "city", "contact");
        for (Librarian li : getLl()) {
        System.out.printf("%-10s%-20s%-15s%-20s%-20s%-15s%-15s\n",li.getId(), li.getName(),li.getPassword(),li.getEmail(),li.getAddress(),li.getCity(),li.getContact());
        }
    }

    public void deleteLibrarian() {
        System.out.print("Name: ");
        String name = Validation.checkInputString();
        Librarian librarianDelete = getLibrarianByName( name);
        ll.remove(librarianDelete);
        System.err.println("Delete successful.");
    }

    public Librarian getLibrarianByName( String name) {
        for (Librarian librarian : getLl()) {
            if (librarian.getName().equalsIgnoreCase(name)) {
                return librarian;
            }
        }
        return null;
    }
}
