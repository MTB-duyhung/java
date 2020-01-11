package dictionaryword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {

    public static void main(String[] args) {
        List<DictionaryWord> w = new ArrayList<DictionaryWord>();
        w.add(new DictionaryWord("bank robber", "Steals money from a bank"));
        w.add(new DictionaryWord("forger", "Makes an illegal copy of something"));
        w.add(new DictionaryWord("burglar", "Breaks into a home to steal things "));
        w.add(new DictionaryWord("hijacker", "Takes control of an airplane"));
        w.add(new DictionaryWord("kidnapper", "Holds someone for ransom money  "));
        w.add(new DictionaryWord("hacker", "Breaks into a computer system"));
        w.add(new DictionaryWord("murderer", "Kills another person "));
        w.add(new DictionaryWord("mugger", "Attacks and steals money from someone"));
        Collections.sort(w);
        for (int i = 1; i <= w.size(); i++) {
            System.out.println("" + i + " " + w.get(i-1));
        }
    }
}

