/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4p0081;

/**
 *
 * @author Admin
 */
public class Lab4P0081 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Worker worker = new Worker();
        Queen queen = new Queen();
        Drone drone = new Drone();
        while (true) {
            Manager.menu();

            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    worker.createBeeList();
                    queen.createBeeList();
                    drone.createBeeList();
                    break;
                case 2:
                    worker.damage();
                    queen.damage();
                    drone.damage();
                    break;
                case 3:
                    return;
            }
        }
    }
}
