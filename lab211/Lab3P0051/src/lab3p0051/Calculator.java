/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0051;

/**
 *
 * @author Admin
 */
public class Calculator {

    public double inputNumber() {
        System.out.print("Enter number: ");
        double number = Validation.checkInputDouble();
        return number;
    }

    public void normalCalculator() {
        double memory;
        System.out.print("Enter number: ");
        memory = Validation.checkInputDouble();
        while (true) {
            System.out.print("Enter operator: ");
            String operator = Validation.checkInputOperator();
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory: " + memory);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }
    }

    public String BMIStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - shouls lose weight immediately";
        }
    }

    public void BMICalculator() {
        System.out.print("Enter Weight(kg): ");
        double weight = Validation.checkInputDouble();
        System.out.print("Enter Height(kg): ");
        double height = Validation.checkInputDouble();
        double bmi = weight * 10000 / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + BMIStatus(bmi));
    }
}
