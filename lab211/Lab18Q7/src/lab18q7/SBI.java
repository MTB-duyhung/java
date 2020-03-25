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
public class SBI implements Bank{
    private final String BNAME;

    public SBI() {
        this.BNAME = "SBI BANK";
    }

    @Override
     public String getBankName() {
        return BNAME;
    }
    
}
