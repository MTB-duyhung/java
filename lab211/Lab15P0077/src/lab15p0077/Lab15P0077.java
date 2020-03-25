/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab15p0077;

/**
 *
 * @author Admin
 */
public class Lab15P0077 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileList ls = new FileList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    ls.countWord();
                    break;
                case 2:
                    ls.getFileNameContainsWordInDirectory();
                    break;
                case 3:
                    return;
            }
        }
    }

}
