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
        DoctorList ls = new DoctorList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    ls.addDoctor(ld);
                    break;
                case 2:
                    ls.updateDoctor(ld);
                    break;
                case 3:
                    ls.deleteDoctor(ld);
                    break;
                case 4:
                    ls.searchDoctor(ld);
                    break;
                case 5:
                    return;
            }

        }

    }

}
