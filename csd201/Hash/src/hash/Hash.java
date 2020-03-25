/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hash;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Hash {

    int M;//Size of hash table
    int A[];//Hash table

    Hash() {
    }

    Hash(int m) {
        M = m;
        A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = -1;
        }
    }

    int HF(int x) {
        return x % M;//i=x%M
    }

    void Hashing(int x) {
        int i = HF(x);
        A[i] = x;
    }

    void linearProbingHashing(int x) {
        int i = HF(x);
        int j = 0;
        while (j < M && A[i] != -1) {
            j++;
            i = (HF(x) + j) % M;
        }
        if (j == M) {
            System.out.println("Hash table is overflow");
            return ;
        } else {
            A[i] = x;
        }
    }

    void quadraticHashing(int x) {
        int i = HF(x);
        int j = 0;
        while (j < M && A[i] != -1) {
            j++;
            i = (HF(x) + j * j) % M;
        }
        if (j == M) {
            System.out.println("Hash table is overflow");
            return ;
        } else {
            A[i] = x;
        }

    }

    void input() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            int x = in.nextInt();
            if (x == -1) {
                break;
            } else {
                quadraticHashing(x);
            }
        }
    }

    void ouput() {
        for (int i = 0; i < M; i++) {
            System.out.println(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        Hash h = new Hash(5);
//        h.Hashing(4);
//        h.Hashing(7);
//        h.Hashing(6);
//        h.Hashing(5);
        h.input();
        h.ouput();
    }

}
