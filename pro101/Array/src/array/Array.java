//Le Thi Thanh Nhan
//SE1402
//De140100
package array;
import java.util.Scanner;

public class Array {

    private int[] m = new int[100];
    private int n;
    Scanner in = new Scanner(System.in);
    
    public void input() {
        System.out.print("Enter number of elements: ");
        n = in.nextInt();
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("m[" + i + "]= ");
            m[i] = in.nextInt();
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(m[i]);
        }
    }

    public void addElement() {
        n++;
        m[n - 1] = in.nextInt();
    }

    public void averageofOdd() {
        int i, sumOdd = 0, numOdd = 0;
        for (i = 0; i < n; i++) {
            if (m[i] % 2 == 1) {
                sumOdd += m[i];
                numOdd++;
            }
        }
        System.out.println("The average of odd array elements: " + (float) sumOdd / numOdd);
    }

    public void maximunElement() {
        int i, max = m[0];
        for (i = 0; i < n; i++) {
            if (m[i] > max) {
                max = m[i];
            }
        }
        System.out.println("The last maximum element: " + max);
    }

    public void specifiedValue(int value) {
        int i, iValue = 101;
        for (i = 0; i < n; i++) {
            if (m[i] == value) {
                iValue = i;
            }
        }
        if (iValue != 101) {
            System.out.println("The last array element having specified value is m[" + iValue + "]");
        } else {
            System.out.println("Not found!");
        }
    }

    public void sortArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (m[i] < m[j]) {
                    int tmp = m[i];
                    m[i] = m[j];
                    m[j] = tmp;
                }
            }
        }
    }

    public int deleteElement(int index) {
        if (index >= n || index < 0) {
            System.out.print("Not Found!");
        } else {
            n--;
            for (int i = index; i < n; i++) {
                m[i] = m[i + 1];
            }
        }
        return n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Array arr = new Array();         
        arr.input();
        System.out.println("Add a element at the end of array:");
        arr.addElement();

        System.out.println("\nDisplay all elements :");
        arr.print();

        arr.averageofOdd();

        arr.maximunElement();

        int value;
        System.out.print("\nEnter specified value: ");
        value = sc.nextInt();
        arr.specifiedValue(value);

        arr.sortArray();
        System.out.println("\nArray after sorted: ");
        arr.print();

        int index;
        System.out.print("\nEnter specified index : ");
        index = sc.nextInt();
        arr.deleteElement(index);
        System.out.println("Array after deleted: \n");
        arr.print();
    }

}
