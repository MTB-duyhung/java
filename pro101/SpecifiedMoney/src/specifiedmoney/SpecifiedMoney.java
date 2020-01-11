//Le Thi Thanh Nhan
//SE1402
//De140100
package specifiedmoney;

import java.util.Scanner;

public class SpecifiedMoney {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money, numOne, numTwo, numFive;
        System.out.println("Enter specified money: ");
        money = in.nextInt();

        for (numOne = 0; numOne <= money; numOne++) {
            for (numTwo = 0; numTwo <= money / 2; numTwo++) {
                for (numFive = 0; numFive <= money / 5; numFive++) {
                    if (numOne + 2 * numTwo + 5 * numFive == money) {
                        System.out.println("there are " + numOne + " $1 notes, " + numTwo + " $2 notes and " + numFive + " $5 notes");
                    }
                }
            }
        }
    }
}
