/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfectnumber;


/**
 *
 * @author Admin
 */
public class PerfectNumber {

    /**
     * @param args the command line arguments
     */
    public static int isPerfect(int num){
        int sum=0;
        for (int i = 1; i <= num/2; i++) 
            if (num%i==0)sum+=i;
        if (sum==num) return 1;
        else return 0;
        
    }
    public static void main(String[] args) {
        System.out.println("Perfect number list:");
        for(int i=1;i<=1000;i++)
            if(isPerfect(i)==1) System.out.println(i);
    }
    
}
