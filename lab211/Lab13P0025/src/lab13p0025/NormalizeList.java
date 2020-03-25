/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13p0025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class NormalizeList {

    private String line;

    public NormalizeList() {
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public int getCountQuetes() {
        return countQuetes;
    }

    public void setCountQuetes(int countQuetes) {
        this.countQuetes = countQuetes;
    }

    public String formatOneSpaceSpecial(String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        //appen every word and character special distance is one space
        for (String oneWord : strings) {
            stringBuffer.append(oneWord + " " + character);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString().trim().substring(0, stringBuffer.length() - 3);
    }

    //only one space between words and all character lowercase
    public String formatOneSpace() {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(".");
        line = formatOneSpaceSpecial(",");
        line = formatOneSpaceSpecial(":");
        line = formatOneSpaceSpecial(";");
        return line.trim();
    }

    //only one space after comma (,), dot (.) and colon (:).
    public String formatSpecialCharacters() {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && (stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ';'
                    || stringBuffer.charAt(i + 1) == ':')) {
                stringBuffer.deleteCharAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }

    //first character of word after dot is in Uppercase and other words are in lower case.
    public String afterDotUpperCase() {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                char afterDot = stringBuffer.charAt(i + 2);
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuffer.toString().trim();
    }

    //there are no spaces before and after sentence or word phrases in quotes.
    int countQuetes = 0;

    public String noSpaceQuotes() {
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                countQuetes++;
            } else if (stringBuffer.charAt(i) == '"' && countQuetes % 2 == 1 && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                countQuetes++;
            }
        }
        return stringBuffer.toString().trim();
    }

    //first character of word in first line is in Uppercase
    public String firstUpercase() {
//        line = line.substring(3);
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }

    //must have dot at the end of text.
    public String lastAddDot() {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }

    //there are no blank line between lines
    public boolean isLineEmpty(String line) {
        if (line.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    //count line
    public int countLine() {
        int countLine = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("D:\\nhan\\java\\lab211\\input.txt")));
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("D:\\nhan\\java\\lab211\\output.txt", true)));
            String line;
            while ((line = br.readLine()) != null) {
                if (isLineEmpty(line)) {
                    continue;
                }
                countLine++;
            }
            br.close();
            pw.close();

        } catch (FileNotFoundException ex) {
            System.err.println("Can't found.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return countLine;
    }

    public void normalize() {
        BufferedReader br = null;
        NormalizeList n;
        try {
            int count = 1;
            int countLine = countLine();
            br = new BufferedReader(new FileReader(new File("D:\\nhan\\java\\lab211\\input.txt")));
            PrintWriter pw;
            try {
                pw = new PrintWriter(new BufferedWriter(new FileWriter("D:\\nhan\\java\\lab211\\output.txt", true)));
//                String line;
                while ((line = br.readLine()) != null) {
                    if (isLineEmpty(line)) {
                        System.out.println("ok");
                        continue;
                    }
                    line = formatOneSpace();
                    line = formatSpecialCharacters();
                    line = afterDotUpperCase();
                    line = noSpaceQuotes();
                    line = firstUpercase();
                    line = lastAddDot();
                    pw.print(line);
                    if (count < countLine) {
                        pw.print(System.getProperty("line.separator"));
                    }
                    count++;
                }
                br.close();
                pw.close();
                System.out.println("Normalize successful.");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can't found");
        }
    }
}
