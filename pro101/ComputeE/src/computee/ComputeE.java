//Le Thi Thanh Nhan
//SE1402
//De140100
package computee;
import java.util.Scanner;
public class ComputeE {
    public static int Factorial(int k){
        int fac=1;
        for (int i=1;i<=k;i++)
            fac*=i;
        return fac;
    }
    public static int Exponent (int x, int k){
        int exp=1;
        for (int i=1;i<=k;i++)
            exp*=x;
        return exp;
    }
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n,x;
    float result=1;
        System.out.print("n=");
        n=in.nextInt();
        System.out.print("x=");
        x=in.nextInt();
        for (int i=1;i<=n;i++){
            result+=(float)Exponent(x,i)/Factorial(i);
        }
        System.out.println("e^"+x+"="+result);
    }
    
}
