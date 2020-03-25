/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11p0074;

import javax.swing.text.html.HTML;

/**
 *
 * @author Admin
 */
public class Lab11P0074 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MatrixList lm=new MatrixList();
        while (true) {
            Manager.menu();
            int choice=Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    lm.addition();
                    break;
                case 2:
                    lm.subtraction();
                    break;
                case 3:
                    lm.multiplication();
                    break;
                case 4:
                    return ;
            }
        }
    }
    
}
