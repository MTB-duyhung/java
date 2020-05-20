/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab20p0076;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CSVList {

    ArrayList<CSV> ls = new ArrayList<>();

    public ArrayList<CSV> getLs() {
        return ls;
    }

    public void setLs(ArrayList<CSV> ls) {
        this.ls = ls;
    }

    private final static Scanner in = new Scanner(System.in);
    private static final String COMMA_DELIMITER = ",";

    public void addinput() {
//        ls.add(new CSV(1, "pham ", "xxx@gmail.com", "'12345678", "AAA - BBB - CCC"));
        FileWriter fileWriter = null;
        System.out.print("Enter Path to input: ");
        String fileName = in.nextLine().trim();
        try {
        fileWriter = new FileWriter(fileName);
        fileWriter.append(String.valueOf(1));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf("pham"));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf("xxx@gmail.com"));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf("12345678"));
        fileWriter.append(COMMA_DELIMITER);
        fileWriter.append(String.valueOf("AAA - BBB - CCC"));
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void formatName() {
        for (int i = 0; i < ls.size(); i++) {
            String name = ls.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = name.split(COMMA_DELIMITER);
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0))).append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void formatAddress() {
        for (int i = 0; i < ls.size(); i++) {
            String address = ls.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String[] arr = address.split(",");
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < arr.length; j++) {
                sb.append(Character.toUpperCase(arr[j].charAt(0))).append(arr[j].substring(1)).append(" ");
            }
            ls.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void importFile() {
        String line = "";
        BufferedReader fileReader = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine().trim();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            while ((line = fileReader.readLine()) != null) {
                String[] splitCSV = line.split(COMMA_DELIMITER);               
                CSV csv = new CSV(Integer.parseInt(splitCSV[0]), splitCSV[1], splitCSV[2], splitCSV[3], splitCSV[4]);
                ls.add(csv);
            }
            System.err.println("Import: Done");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void exportFile() {
        FileWriter fileWriter = null;
        System.out.print("Enter Path: ");
        String fileName = in.nextLine();
        try {
            fileWriter = new FileWriter(fileName);
            for (CSV listCSV : ls) {
                fileWriter.append(String.valueOf(listCSV.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getEmail()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getPhone()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(listCSV.getAddress()));
            }
            System.err.println("Export Done!!!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
