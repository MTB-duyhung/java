/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab19p0079;

import java.io.IOException;

/**
 *
 * @author Admin
 */
public class Lab19P0079 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Zip z=new Zip();
        while (true) {
            Manager.menu();
            int choice=Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    z.zipFile();
                    break;
                case 2:
                    z.unzipFile();
                    break;
                case 3:
                    return ;
            }
        }
    }
    
}
