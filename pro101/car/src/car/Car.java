package car;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Car {

    private String name, production;
    private double price;

    public Car(String name, String production, double price) {
        this.name = name;
        this.production = production;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "name=" + name + ", production=" + production + ", price=" + price + '}';
    }

    public static void main(String[] args) {
        Car c = null;
        Scanner in = new Scanner(System.in);
        GenericCar<Car> list = new GenericCar<>();
        int op;
        String name, production;
        double price;
        System.out.println("1. Add Car");
        System.out.println("2. Display Cars");
        System.out.println("3. Number of Cars");
        System.out.println("4. Check empty");
        System.out.println("5. Delete Car");
        System.out.println("6. Sort Cars");
        System.out.println("7. Search Car");
        System.out.println("8. Exit");
        do {
            System.out.print("\nEnter your choice: ");
            op = in.nextInt();
            switch (op) {
                case 1:

                    System.out.print("Enter Name: ");
                    name = in.next();
                    System.out.print("Enter Price: ");
                    price = in.nextDouble();
                    System.out.print("Enter Production: ");
                    production = in.next();
                    c = new Car(name, production, price);
                    list.Add(c);
                    System.out.println("Add successfully!");
                    break;
                case 2:
                    for (int i = 0; i < list.Display().size(); i++) {
                        System.out.println(list.Display().get(i));
                    }
                    System.out.println("This task has completed successfully!");
                    break;
                case 3:
                    System.out.println("There are " + list.getSize() + " item.");
                    break;
                case 4:
                    if (list.checkEmpty() == true) {
                        System.out.println("\nEmpty List!");
                    } else {
                        System.out.println("\nNot Empty List!");
                    }
                    break;
                case 5:
                    int pos;
                    System.out.println("Enter position :");
                    pos = in.nextInt();
                    list.Delete(pos);
                    System.out.println("This position has been removed successfully!");
                    break;
                case 6:
                    Comparator<Car> byPrice = Comparator.comparing(Car::getPrice);
                    Collections.sort(list.m, byPrice);
                    for (int i = 0; i < list.m.size(); i++) {
                        System.out.println(list.m.get(i));
                    }
                    System.out.println("This task has completed successfully!");
                    break;
                case 7:
                    System.out.print("Enter name: ");
                    name = in.next();
                    if (list.Search(name) !=0) {
                        System.out.println("This item is exits in list\n");
                    } else {
                        System.out.println("This item is not exits in list");
                    }
                    break;
            }
        } while (op > 0 && op < 8);
    }

}
