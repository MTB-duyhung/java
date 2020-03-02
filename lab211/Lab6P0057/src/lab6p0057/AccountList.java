/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0057;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class AccountList {

    public void createNewAccount() {
        if (!Validation.checkFileExist()) {
            return;
        }
        String username = Validation.checkInputUsername();
        if (!Validation.checkUsernameExist(username)) {
            System.err.println("Username exist.");
            return;
        }      
        String password = Validation.checkInputPassword();
        addAccountData(username, password);
    }

    public void loginSystem() {
        if (!Validation.checkFileExist()) {
            return;
        }
        String username = Validation.checkInputUsername();
        if (!Validation.checkUsernameExist(username)) {
            String password = Validation.checkInputPassword();
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Password incorrect.");
            } else {
                System.err.println("Login success.");
            }
        } else {
            System.err.println("Username incorrect.");
        }

    }

    public void addAccountData(String username, String password) {
        File file = new File("user.dat");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Create successly.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String passwordByUsername(String username) {
        File file = new File("user.dat");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
