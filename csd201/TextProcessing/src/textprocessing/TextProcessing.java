/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textprocessing;

/**
 *
 * @author Admin
 */
public class TextProcessing {

    int BruteForce(String s, String p) {
        for (int i = 0; i < (s.length() - p.length()); i++) {
            int j = 0;
            while (j < p.length() && s.charAt(i + j) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return i;
            }
        }
        return -1;
    }

    int[] lpsCompute(String p) {
        int m = p.length();
        int lps[] = new int[m];
        int len = 0, i = 1;
        lps[0] = 0;
        while (i < m) {
            if (p.charAt(i) == p.charAt(len)) {
                len++;
                i++;
                lps[len] = len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    void KMP(String s, String p) {
        int n = s.length();
        int m = p.length();
        int lps[] = new int[m];
        lps = lpsCompute(p);
        int i = 0, j = 0;
        while (i < n) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println(p + " is found at " + (i - j));
                j=lps[j-1];
            } else {
                if (i < n && s.charAt(i) != p.charAt(j)) {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TextProcessing T = new TextProcessing();
        String s = "acbdefsdefacbdef";
        String p = "def";
        int lps[] = T.lpsCompute(p);
//        for (int i = 0; i < lps.length; i++) {
//            System.out.print(lps[i] + " ");
//        }
//        System.out.print("\nBrute-force algorithm:\n");
//        int x = T.BruteForce(s, p);
//        if (x >= 0) {
//            System.out.print(p + " is found in " + s + " at: " + x);
//        } else {
//            System.out.print(p + " is not found in " + s);
//        }
        T.KMP(s, p);
    }
}
