/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ptb2;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Ptb2 {

    private float a, b, c, delta;

    public void input() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("a=");
            a = sc.nextFloat();
        } while (a <= -99 || a > 100);
        do {
            System.out.print("b=");
            b = sc.nextFloat();
        } while (b <= -99 || b > 100);
        do {
            System.out.print("c=");
            c = sc.nextFloat();
        } while (c <= -99 || c > 100);
    }

    public void output(){
        if(a==0){
            if(b==0)
                if(c==0) System.out.println("ptvsn");
                else System.out.println("ptvn");
            else System.out.println("pt co 1 nghiem x="+(-c/b));
        }
        else{
            delta=(b*b-4*a*c);
            if(delta<0) System.out.println("ptvn");
            else if(delta==0) System.out.println("pt co 1 nghiem x="+(float)(-b/(2*a)));
            else System.out.println("pt co 2 ngiem x1="+(float)((-b-sqrt(delta))/(2*a))+" va x2="+(float)((-b+sqrt(delta))/(2*a)));
        }
    }
    public static void main(String[] args) {
        Ptb2 p=new Ptb2();
        p.input();
        p.output();
    }

}
