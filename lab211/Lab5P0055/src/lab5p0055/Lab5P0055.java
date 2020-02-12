/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5p0055;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Lab5P0055 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Doctor> ld = new ArrayList<>();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:

                    break;

            }

        }

    }

}
