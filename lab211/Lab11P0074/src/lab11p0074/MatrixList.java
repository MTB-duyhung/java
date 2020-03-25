/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11p0074;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MatrixList {

    public final Scanner in = new Scanner(System.in);

    public int[][] inputMatrix() {
        System.out.print("Enter Row Matrix: ");
        int row = Validation.checkInputInt();
        System.out.print("Enter Colum Matrix: ");
        int col = Validation.checkInputInt();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + (i+1) + "]" + "[" + (j+1) + "]:");
                matrix[i][j] = Validation.checkInputInt();
            }
        }
        return matrix;
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public void addition() {
        System.out.println("Enter matrix 1:");
        int[][] matrix1 = inputMatrix();
        System.out.println("Enter matrix 2:");
        int[][] matrix2 = inputMatrix();
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (row1 == row2 && col1 == col2) {
            System.out.println("Addition:");
            displayMatrix(matrix1);
            System.out.println("+");
            displayMatrix(matrix2);
            System.out.println("=");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print("[" + (matrix1[i][j] + matrix2[i][j]) + "]");
                }
                System.out.println();
            }
        } else {
            System.err.println("Can't multiple.");
            return;
        }
    }

    public void subtraction() {
        System.out.println("Enter matrix 1:");
        int[][] matrix1 = inputMatrix();
        System.out.println("Enter matrix 2:");
        int[][] matrix2 = inputMatrix();
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (row1 == row2 && col1 == col2) {
            System.out.println("Subtraction:");
            displayMatrix(matrix1);
            System.out.println("-");
            displayMatrix(matrix2);
            System.out.println("=");
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col1; j++) {
                    System.out.print("[" + (matrix1[i][j] - matrix2[i][j]) + "]");
                }
                System.out.println();
            }
        } else {
            System.err.println("Can't multiple.");
            return;
        }
    }

    public void multiplication() {
        System.out.println("Enter matrix 1:");
        int[][] matrix1 = inputMatrix();
        System.out.println("Enter matrix 2:");
        int[][] matrix2 = inputMatrix();
        System.out.println("Multiplication:");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if (col1 != row2) {
            System.err.println("Can't multiple.");
            return;
        }
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        displayMatrix(matrixResult);
    }
}
