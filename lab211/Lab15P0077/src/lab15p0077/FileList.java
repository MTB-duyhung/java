/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab15p0077;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class FileList {

    public int countWordInFile(String fileSource, String word) {
        FileReader fr = null;
        try {
            fr = new FileReader(fileSource);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] parts = line.split(" ");
                for (String w : parts) {
                    if (w.equalsIgnoreCase(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public void getFileNameContainsWordInDirectory() {
        System.out.print("Enter Path: ");
        String source = Validation.checkInputString();
        System.out.print("Enter Word: ");
        String word = Validation.checkInputString();
        File folder = new File(source);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String name=source+"\\"+file.getName();
                if (countWordInFile(name, word) != 0) {
                    System.out.println("file name: " + file.getName());
                }
            }
        }
    }

    public void countWord() {
        System.out.print("Enter Path: ");
        String pathCount = Validation.checkInputString();
        System.out.print("Enter Word: ");
        String wordCount = Validation.checkInputString();
        System.out.println("Bout: "+countWordInFile(pathCount, wordCount));
    }
}
