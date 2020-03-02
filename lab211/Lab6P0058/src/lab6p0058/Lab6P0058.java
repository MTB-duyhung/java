/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0058;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Lab6P0058 {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        WordList ls = new WordList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    ls.addNewWord(hm);
                    break;
                case 2:
                    ls.deleteWord(hm);
                    break;
                case 3:
                    ls.translate(hm);
                    break;
                case 4:
                    return;
            }
        }
    }

}
