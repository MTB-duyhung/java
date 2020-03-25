/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab20p0076;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Lab20P0076 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CSVList lcsv = new CSVList();
        lcsv.addinput();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    lcsv.importFile();
                    break;
                case 2:
                    lcsv.formatAddress();
                    break;
                case 3:
                    lcsv.formatName();
                    break;
                case 4:
                    lcsv.exportFile();
                    break;
                case 5:
                    return;

            }
        }
    }
}
