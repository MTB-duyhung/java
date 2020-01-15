/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0052;

/**
 *
 * @author Admin
 */
public class Lab3P0052 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EastAsiaCountriesList ls = new EastAsiaCountriesList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    ls.inputCountry();
                    break;
                case 2:
                    ls.printCountry();
                    break;
                case 3:
                    ls.searchByName();
                    break;
                case 4:
                    ls.printCountrySorted();
                    break;
                case 5:
                    return;
            }
        }
    }
}
