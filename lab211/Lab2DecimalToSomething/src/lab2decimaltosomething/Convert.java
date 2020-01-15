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
public class Convert {
    
    String decimal;
    String hexadecimal;
    String binary;

    public Convert(){
        
    }
    public Convert(String decimal, String hexadecimal, String binary) {
        this.decimal = decimal;
        this.hexadecimal = hexadecimal;
        this.binary = binary;
    }

    public String getDecimal() {
        return decimal;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public String getHexadecimal() {
        return hexadecimal;
    }

    public void setHexadecimal(String hexadecimal) {
        this.hexadecimal = hexadecimal;
    }

    public String getBinary() {
        return binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }
    
    public static final char[] hexDigits = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    public void convertFromBinary() {
        int choice = Manager.displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: " + convertBinaryToDecimal());
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertBinaryToHexa());
                break;

        }
    }

    public void convertFromDecimal() {
        int choice = Manager.displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertDecimalToBinary());
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertDecimalToHexa());
                break;

        }
    }

    public void convertFromHexa() {
        int choice = Manager.displayConvert("hexadecimal", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertHexaToBinary());
                break;
            case 2:
                System.out.println("Decimal: " + convertHexaToDecimal());
                break;

        }
    }

    public int convertBinaryToDecimal() {
        int decimal = Integer.parseInt(binary, 2);
        return decimal;
    }

    public String convertBinaryToHexa() {
        String hexadecimal = Integer.toHexString(convertBinaryToDecimal());
        return hexadecimal;
    }

    public int convertHexaToDecimal() {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }

    public String convertHexaToBinary() {
        String binary = Integer.toBinaryString(convertHexaToDecimal());
        return binary;
    }

    public String convertDecimalToBinary() {
        String binary = Integer.toBinaryString((Integer.parseInt(decimal)));
        return binary;
    }

    public String convertDecimalToHexa() {
        int dec = Integer.parseInt(decimal);
        String hexadecimal = Integer.toHexString(dec);
        return hexadecimal;
    }
}

