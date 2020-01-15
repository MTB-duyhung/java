/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2decimaltosomething;

/**
 *
 * @author Admin
 */
public class Lab2DecimalToSomething {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Convert convert=new Convert();
        while (true) {
            int choice = Manager.menu();
            switch (choice) {
                case 1:
                    String binary = Validation.checkInputBinary();
                    convert.setBinary(binary);
                    convert.convertFromBinary();
                    break;
                case 2:
                    String decimal = Validation.checkInputDecimal();
                    convert.setDecimal(decimal);
                    convert.convertFromDecimal();
                    break;
                case 3:
                    String hexadecimal = Validation.checkInputHexaDecimal();
                    convert.setHexadecimal(hexadecimal);
                    convert.convertFromHexa();
                    break;
                case 4:
                    return;
            }
        }
    }

}
