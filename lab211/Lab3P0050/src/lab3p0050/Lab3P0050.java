/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0050;

/**
 *
 * @author Admin
 */
public class Lab3P0050 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        while (true) {
            Manager.menu();
            Check check = new Check();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    check.superlativeEquation();
                    break;
                case 2:
                    check.quadraticEquation();
                    break;
                case 3:
                    return;
            }
        }
    }
}
