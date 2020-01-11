
package assignment;

import java.util.Date;

public class International extends Tour{

    protected double aviationTax,entryFee;
    
    public International(String code, String title, double price, boolean transport, Date start, Date end,double aviationTax,double entryFee) {
        super(code, title, price, transport, start, end);
        this.aviationTax=aviationTax;
        this.entryFee=entryFee;
    }

    @Override
    public double surcharge() {
        return this.aviationTax+this.entryFee;
    }
    
}
