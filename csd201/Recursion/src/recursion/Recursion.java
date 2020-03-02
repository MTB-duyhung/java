/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursion;

/**
 *
 * @author Admin
 */
public class Recursion {
    
    int fac(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fac(n - 1);
        }
    }

    int fibo(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
    void printFibo(int n){
        for (int i = 1; i <= n; i++) {
            System.out.println(fibo(i));
        }
    }

    public static void main(String[] args) {
        Recursion R = new Recursion();
//        int x=R.fac(6);
//        System.out.println("6!="+x);
        System.out.println("fibo(6)=" + R.fibo(6));
        R.printFibo(6);
    }
    
}
