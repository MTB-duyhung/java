
package workwithstring;

import java.util.Scanner;
public class WorkWithString {

    public static boolean searchWord(String string, String word) {
        String temp[] = string.split(" ");
        int len = temp.length;

        for (int i = 0; i < len; i++)
            if (word.equals(temp[i]))
                return true;

        return false;
    }

    public static int countTimesWordAppearesInArray(String string, String word) {
        String temp[] = string.split(" ");
        int count = 0, len = temp.length;

        for (int i = 0; i < len; i++) {
            if (word.equals(temp[i]))
                count++;
        }

        return count;
    }
    
    public static String capitalizeString1(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = 0; i < chars.length; i++) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'')
                found = false;
        }
        return String.valueOf(chars);
    }

    public static String capitalizeString2(String string) {
        char[] chars = string.toLowerCase().toCharArray();
        boolean found = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!found && Character.isLetter(chars[i])) {
                chars[i] = Character.toUpperCase(chars[i]);
                found = true;
            } else if (Character.isWhitespace(chars[i]) || chars[i]=='.' || chars[i]=='\'')
                found = false;
        }
        return String.valueOf(chars);
    }

    public static void orderByIn(String string) {
        String temp[] = string.split(" ");
        int len = temp.length;

        for (int i = 0 ; i < len; i++)
            for(int j = 0; j  < len - i - 1; j++)
                if (temp[j].compareTo(temp[j + 1]) > 0) {
                    String t = temp[j];
                    temp[j] = temp[j + 1];
                    temp[j + 1] = t;
                }

        for (int i = 0; i < len; i++)
            System.out.println(temp[i]);
    }

    public static void remove(String string, char c) {
        int index = string.indexOf(c);
        if (index >= 0) {
            StringBuilder builder = new StringBuilder(string);
            builder.deleteCharAt(index);
            System.out.println("String after removed: " + builder.toString());
        }
        else
            System.out.println("Input character does not present in string.");
    }

    public static String countWords(String string) {
        String temp[] = string.split(" ");
        return temp.length == 0 ? "Empty string" : "String has " + String.valueOf(temp.length) + " words";
    }

    public static void  printAllLetters(String string) {
        int len = string.length();
        System.out.println("All letter of string:");
        for (int i = 0; i < len; i++)
            if(Character.isLetter(string.charAt(i)))
                System.out.println(string.charAt(i));
    }

    public static void reverseString(String string) {
        StringBuilder builder = new StringBuilder(string);
        builder = builder.reverse();
        System.out.println("String after reversed: " + builder);
    }

    public static String replaceLetter(String string) {
        String copy1 = string.replace('a', 'A');
        String copy2 = copy1.replace('b', 'B');
        return copy2;
    }

    public static int countUpper(String string) {
        int len = string.length(), count = 0;

        for (int i = 0; i < len; i++)
            if(Character.isUpperCase(string.charAt(i)))
                count++;
        return count;
    }

    public static void main(String[] args) {
        
        String string;
        Scanner scanner = new Scanner(System.in);
        char c;

        System.out.println("Enter string: ");
        string = scanner.nextLine();

        System.out.println("a- Search within @str string to conclude whether it contains the following words or NOT?  \"me\", \"why\", \"well\"");
        if(searchWord(string, "me"))
            System.out.println("String contains \"me\"");
        else
            System.out.println("String does not contain \"me\"");
        if(searchWord(string, "why"))
            System.out.println("String contains \"why\"");
        else
            System.out.println("String does not contain \"why\"");
        if(searchWord(string, "well"))
            System.out.println("String contains \"well\"");
        else
            System.out.println("String does not contain \"well\"");

        System.out.println("b- \"you\" word appear in @str how many times? ");
        System.out.println("\"you\" word appears in string " + countTimesWordAppearesInArray(string, "you") + " times.");

        System.out.println("c- Replace the first character of each word by its UPPER CASE");
        System.out.println(capitalizeString1(string));

        System.out.println("d- Replace the first character of each word by its LOWER CASE, and the last character of each word by its UPPER CASE ");
        System.out.println(capitalizeString2(string));

        System.out.println("e- Extract @str string to an array of words, then display those words by increasing order.");
        orderByIn(string);

        System.out.println("f- Give a character named c, remove from @str the first character which is equals to c. ");
        System.out.println("Enter character: ");
        c = scanner.next().charAt(0);
        remove(string, c);

        System.out.println("g- Count how many words in @str, display “empty string” if @str is an empty string.");
        System.out.println(countWords(string));

        System.out.println("h- Print all letters of @str only.");
        printAllLetters(string);

        System.out.println("i- Reserve @str.");
        reverseString(string);

        System.out.println("j- Replace all letter ‘a’ by ‘A’ and ‘b’ by ‘B’.");
        System.out.println("String after replaced: " + replaceLetter(string));

        System.out.println("k- How many upper letters in @str?");
        System.out.println("String have/has " + countUpper(string) + " uppercase letters.");
    }
}