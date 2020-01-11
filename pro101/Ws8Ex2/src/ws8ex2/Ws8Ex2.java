package ws8ex2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ws8Ex2 {

    public static void main(String[] args) {
        try {
            String fileName = "D:/nhan/java/pro101/student.txt";
            String name;
            int age;
            String line;
            float mark;
            int op;
            FileWriter writer;
            FileReader read;
            BufferedReader bf;
            Scanner sc = new Scanner(System.in);
            System.out.println("Menu");
            System.out.println("------------------");
            System.out.println("1. Add a list of Students and save to File ");
            System.out.println("2. Loading list of Students from a File ");
            System.out.println("3. Exit");
            do {
                System.out.println("Your's choice:");
                op = sc.nextInt();
                switch (op) {
                    case 1:
                        writer = new FileWriter(fileName, true);
                        System.out.println("Enter student's name:");
                        sc.nextLine();
                        name = sc.nextLine();
                        System.out.println("Enter student's age:");
                        age = sc.nextInt();
                        System.out.println("Enter student's mark: ");
                        mark = sc.nextFloat();

                        Student A = new Student(name, age, mark);
                        writer.write(A.toString());
                        writer.close();
                        System.out.println("Write file success!");
                        break;
                    case 2:
                        System.out.println("File load success!");
                        System.out.println("Student list:");
                        read = new FileReader(fileName);
                        bf = new BufferedReader(read);
                        while ((line = bf.readLine()) != null) {
                            System.out.println(line);
                        }
                        System.out.println("--->Read from file<---");
                        bf.close();
                        read.close();
                        break;

                }

            } while (op > 0 && op < 3);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
