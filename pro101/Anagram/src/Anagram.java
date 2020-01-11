
import java.util.Scanner;
public class Anagram {

    public static boolean areAnagrams(String string1,
                                      String string2) {

        String workingCopy1 = removeJunk(string1);
        String workingCopy2 = removeJunk(string2);

	workingCopy1 = workingCopy1.toLowerCase();
	workingCopy2 = workingCopy2.toLowerCase();

	workingCopy1 = sort(workingCopy1);
	workingCopy2 = sort(workingCopy2);

        return workingCopy1.equals(workingCopy2);
    }

    protected static String removeJunk(String string) {
        int i, len = string.length();
  	StringBuffer dest = new StringBuffer(len);
	char c;

	for (i = (len - 1); i >= 0; i--) {
	    c = string.charAt(i);
	    if (Character.isLetterOrDigit(c)) {
		dest.append(c);
	    }
	}

        return dest.toString();
    }

    protected static String sort(String string) {
	int length = string.length();
        char[] charArray = new char[length];

	string.getChars(0, length, charArray, 0);

	java.util.Arrays.sort(charArray);

        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("String 1:");
        String string1 = in.next();
        System.out.println("String 2:");
        String string2 = in.next();

        if (areAnagrams(string1, string2)) {
            System.out.println("They ARE anagrams!");
        } else {
            System.out.println("They are NOT anagrams!");
        }
    }
}
