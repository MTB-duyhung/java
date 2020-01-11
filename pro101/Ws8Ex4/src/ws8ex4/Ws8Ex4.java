package ws8ex4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ws8Ex4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input the file name: ");
        Scanner in = new Scanner(System.in);
        String src = in.nextLine();
        String[] srcs = src.split("/");
        String fileName=srcs[srcs.length-1];
        File f1 = new File(src);
        System.out.print("Input the folder name: ");
        String dest = in.nextLine();
        String dests=dest+"/"+fileName;
        File f2 = new File(dests);
        try {
            FileInputStream fis = new FileInputStream(f1);
            FileOutputStream fos = new FileOutputStream(f2);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException ex) {
            System.out.println("File not found!");
        }
    }
}
