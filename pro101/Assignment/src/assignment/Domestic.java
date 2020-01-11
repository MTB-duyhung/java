
package assignment;

import java.util.Date;

public class Domestic extends Tour{
protected double tourGuideTip;

    public Domestic(String code, String title, double price, boolean transport, Date start, Date end,double tourGuideTip) {
        super(code, title, price, transport, start, end);
        this.tourGuideTip=tourGuideTip;
    }
   
    @Override
    public double surcharge() {
        return this.tourGuideTip*numberOfDate();
    }
    
}
