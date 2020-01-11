package phonenumber;

public class LocalPhoneNumber extends PhoneNumber {

    public LocalPhoneNumber(int a, String n) {
        super(a, n);
    }

    @Override
    public void display() {
        System.out.println(this.area + "-" + this.number);
    }

}
