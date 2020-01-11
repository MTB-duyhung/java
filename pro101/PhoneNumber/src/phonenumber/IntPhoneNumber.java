package phonenumber;

public class IntPhoneNumber extends PhoneNumber {

    protected String countryCode;

    protected IntPhoneNumber() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public IntPhoneNumber(String cc, int a, String n) {
        super(a, n);
        this.countryCode = cc;
    }

    @Override
    public void display() {
        System.out.println(this.countryCode + "-" + this.area + "-" + this.number);

    }

}
