/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab18q7;

/**
 *
 * @author Admin
 */
public class ICICI implements Bank{
    private final String BNAME;

    public ICICI() {
        this.BNAME = "ICICI BANK";
    }

    @Override
     public String getBankName() {
        return BNAME;
    }
    
}
