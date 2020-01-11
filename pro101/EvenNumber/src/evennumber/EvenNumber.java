//Le Thi Thanh Nhan
//SE1402
//De140100
package evennumber;

public class EvenNumber {

    public static void main(String[] args) {
        int i;
        // for loop
        System.out.println("for loop:");
        for (i = 2; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
        }
        // while loop
        System.out.println("while loop:");
        i = 2;
        while (i <= 10) {
            if (i % 2 == 0) {
                System.out.println(i + " ");
            }
            i++;
        }
    }
    
}
