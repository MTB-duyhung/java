/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Admin
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CourseList sl = new CourseList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 6);
            switch (choice) {
                case 1:
                    sl.report();
                    break;
                case 2:
                    sl.searchAndDisplay();
                    break;
                case 3:
                    sl.add();
                    break;
                case 4:
                    sl.sortAscending();
                    break;
                case 5:
                    sl.update();
                    break;
                case 6:
                    return;
            }
        }

    }

}
