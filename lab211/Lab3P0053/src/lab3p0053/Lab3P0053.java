/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0053;

/**
 *
 * @author Admin
 */
public class Lab3P0053 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
            Array array = new Array();
            array.n=array.inputSizeOfArray();
            array.m = new int[array.n];
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    array.inputValueOfArray();
                    break;
                case 2:
                    array.sortArrayAscending();
                    break;
                case 3:
                    array.sortArrayDescending();
                    break;
                case 4:
                    return;
            }
        }
    }
}