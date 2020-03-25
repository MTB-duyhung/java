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
public class Lab16P007XX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibrarianList lib = new LibrarianList();
        BooksList bl = new BooksList(lib);
        IssueBooksList isl = new IssueBooksList(bl);
        int id = 0, idlib = 0, issid = 0;
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    int choice1 = 0;
                    if (lib.loginAdmin() != false) {
                        do {
                            Manager.menuAdmin();
                            choice1 = Validation.checkInputIntLimit(1, 4);
                            switch (choice1) {
                                case 1:
                                    lib.addLibrarian(id);
                                    id++;
                                    break;
                                case 2:
                                    lib.viewLibrarian();
                                    break;
                                case 3:
                                    lib.deleteLibrarian();
                                    break;
                            }
                        } while (choice1 != 4);
                        break;
                    }
                    break;

                case 2:
                    int choice2 = 0;
                    if (bl.loginLib() != false) {
                        do {
                            Manager.menuLibrarian();
                            choice2 = Validation.checkInputIntLimit(1, 6);
                            switch (choice2) {
                                case 1:
                                    bl.addBooks(idlib);
                                    idlib++;
                                    break;
                                case 2:
                                    bl.viewBooks();
                                    break;
                                case 3:
                                    isl.issueBook(issid);
                                    issid++;
                                    break;
                                case 4:
                                    isl.viewIssueBooks();
                                    break;
                                case 5:
                                    isl.returnBook();
                                    break;
                            }
                        } while (choice2 != 6);
                        break;
                    }
                    break;

                case 3:
                    return;
            }
        }
    }

}
