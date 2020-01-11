package phonenumber;

import java.util.Scanner;

public abstract class PhoneNumber {

    protected int area;
    protected String number;

    public PhoneNumber() {
    }

    public PhoneNumber(int a, String n) {
        this.area = a;
        this.number = n;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public abstract void display();

    public static void main(String[] args) {
        int type;
        int a;
        String n, cc;
        int size = 0;
        PhoneNumber phonelist[] = new PhoneNumber[1000];
        System.out.println("Enter list of phone numbers");
        System.out.println("------------------------------------");
        do {
            System.out.print("Type of phone number ? (1-localphone, "
                    + "2 - Inter phone number, 0 - exit):  ");
            Scanner in = new Scanner(System.in);
            type = in.nextInt();
            switch (type) {
                case 1:
                    System.out.print("Enter area code: ");
                    a = in.nextInt();
                    System.out.print("Enter number: ");
                    n = in.next();
                    phonelist[size] = new LocalPhoneNumber(a, n);
                    size++;
                    break;
                case 2:
                    System.out.print("Enter country code: ");
                    cc = in.next();
                    System.out.print("Enter area code: ");
                    a = in.nextInt();
                    System.out.print("Enter number: ");
                    n = in.next();
                    phonelist[size] = new IntPhoneNumber(cc, a, n);
                    size++;
                    break;
            }
        } while (type < 3 && type > 0);
        System.out.println("List of phone number:");
        System.out.println("-----------------------------");
        for (int i = 0; i < size; i++) {
            phonelist[i].display();
        }
    }
}

