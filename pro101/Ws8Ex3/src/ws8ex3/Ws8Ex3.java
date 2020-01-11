package ws8ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ws8Ex3 {
    
    public static void main(String[] args) {
        System.out.print("Input a file name: ");
        Scanner in = new Scanner(System.in);
        String f=in.nextLine();
        try{
            Scanner sc = new Scanner(new File(f));
            while(sc.hasNextLine())
                System.out.println(sc.nextLine());
            sc.close();
        }catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
