/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5p0054;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Lab5P0054 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Contact> lc = new ArrayList<>();
        ContactList ls = new ContactList();
        lc.add(new Contact(1, "Iker Casillas", "Star", "Spain", "1234567890", "Iker", "Casillas"));
        lc.add(new Contact(2, "John Terry", "Star", "England", "1234567890", "John", "Terry"));
        lc.add(new Contact(3, "Raul Gonzalez", "Star", "Spain", "1234567890", "Raul", "Gonzalez"));
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ls.createContact(lc);
                    break;
                case 2:
                    ls.printAllContact(lc);
                    break;
                case 3:
                    ls.deleteContactd(lc);
                    break;
                case 4:
                    return;
            }
        }
    }
}
