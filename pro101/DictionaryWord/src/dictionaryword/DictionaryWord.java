package dictionaryword;

import java.util.Objects;

public class DictionaryWord implements Comparable<DictionaryWord> {

    private String word;
    private String meanings;

    public DictionaryWord() {
    }

    public DictionaryWord(String word, String meanings) {
        this.word = word;
        this.meanings = meanings;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeanings() {
        return meanings;
    }

    public void setMeanings(String meanings) {
        this.meanings = meanings;
    }

    @Override
//    public int compareTo(DictionaryWord o) {
//        return this.word.compareTo(o.word);
//    }

    public String toString() {
        return "" + word + "\n" + meanings;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final DictionaryWord other = (DictionaryWord) obj;
//        if (!Objects.equals(this.word, other.word)) {
//            return false;
//        }
//        if (!Objects.equals(this.meanings, other.meanings)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public int compareTo(DictionaryWord o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
