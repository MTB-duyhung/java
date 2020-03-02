/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0057;

/**
 *
 * @author Admin
 */
public class Lab6P0057 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountList ls = new AccountList();
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    ls.createNewAccount();
                    break;
                case 2:
                    ls.loginSystem();
                    break;
                case 3:
                    return;
            }
        }
    }

}
