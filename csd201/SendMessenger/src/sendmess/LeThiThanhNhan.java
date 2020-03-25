/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendmess;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LeThiThanhNhan {

    char Q[];
    int MAX;
    int f, l;

    LeThiThanhNhan(int M) {
        MAX = M;
        Q = new char[MAX];
        f = -1;
        l = 0;
    }

    int Numcount() {
        if (f == l) {
            return 0;
        } else {
            return ((MAX - f) + l) % MAX;
        }
    }

    void enqueue(char x) {
        if (Numcount() == MAX - 1) {
            System.out.print("Queue is full.");
        } else {
            Q[l] = x;
            l = (l + 1) % MAX;
            if (f == -1) {
                f = 0;
            }
        }
    }

    char dequeue() {
        char x = ' ';
        if (Numcount() == 0) {
            System.out.print("Queue is empty.");
        } else {
            x = Q[f];
            f = (f + 1) % MAX;
        }
        return x;
    }

    String transfer(String s1) {
        String s2 = "";
        int i = 0, count = 0;
        if (s1.length() == 0) {
            System.out.println("The string is empty.");
            return "";
        } else if (s1.length() > 250) {
            System.out.println("The string has more than 250 character.");
            return "";
        } else {
            System.out.println("Length of String: " + s1.length());
            try {
                while (i < s1.length()) {
                    while (Numcount() < MAX - 1) {
                        char c = s1.charAt(i);
                        enqueue(c);
                        i++;
                        if (i >= s1.length()) {
                            break;
                        }
                    }
                    while (Numcount() > 0) {
                        char c = dequeue();
                        s2 += c;
                    }
                    count++;
                }
                while (Numcount() > 0) {
                    char c = dequeue();
                    s2 += c;
                }
                System.out.println("number of times use buffer: " + count);
                return s2;
            } catch (Exception e) {
                System.out.println("error");
                return "";
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LeThiThanhNhan q = new LeThiThanhNhan(5);
        System.out.println("Enter s1:");
        String s1 = in.nextLine();
        long begin, end, time;
        begin = System.currentTimeMillis();
        String s2 = q.transfer(s1);
        System.out.println("s2: " + s2);
        end = System.currentTimeMillis();
        time = end - begin;
        System.out.println(time + "ms");
    }

}
