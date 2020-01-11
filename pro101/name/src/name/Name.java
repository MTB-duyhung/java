package name;

import java.util.Scanner;

public class Name {

    public static void main(String[] args) {
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Your name: ");
        name = in.nextLine();
        StringBuffer initials = new StringBuffer();
        int len = name.length();
        for (int i = 0; i < len; i++) {
            if (Character.isUpperCase(name.charAt(i))) {
                initials.append(name.charAt(i));
            }
        }
        System.out.println("Your initials: " + initials);
    }
}
