/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6p0058;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Admin
 */
public class WordList {

    public void addNewWord(HashMap<String, String> hm) {
        System.out.print("Enter English: ");
        String english = Validation.checkInputString();
        if (!Validation.checkKeywordExist(hm, english)) {
            System.err.print("Exist! Update meaning?(y/n): ");
            if (!Validation.checkInputYN()) {
                return;
            }
        }
        System.out.print("Enter Vietnamese: ");
        String vietnam = Validation.checkInputString();
        hm.put(english, vietnam);
        System.err.println("Add successful.");
    }

    public void deleteWord(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        if (Validation.checkKeywordExist(hm, english)) {
            System.err.println("Not found in data");
            return;
        } else {
            hm.remove(english);
            System.err.println("Delete successful.");
        }
    }

    public void translate(HashMap<String, String> hm) {
        System.out.print("Enter english: ");
        String english = Validation.checkInputString();
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getKey().equals(english)) {
                System.out.println("Vietnamese: " + entry.getValue());
                return;
            }
        }
        System.err.println("Not found in data");
    }

}
