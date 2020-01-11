import java.util.Scanner; 
public class RankByGrade{ 
    
    public static void main(String []args) { 
       
       Scanner in = new Scanner(System.in);
       double grade;
       do
       {
           System.out.println("Input your average grade (min=0, max=10)"); 
           grade = in.nextDouble();
           if (0>grade || grade>10) System.out.println("Wrong!");
       } while (0>grade || grade>10);
           if (grade<5) System.out.println("Bad");
           else if (grade<7) System.out.println("Average");
           else if (grade<8) System.out.println("Good");
           else if (grade<9) System.out.println("Very good");
           else System.out.println("Excellent");
    }
}  
