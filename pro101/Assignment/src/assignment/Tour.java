package assignment;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.*;

public abstract class Tour implements ITour {

    protected String code;
    protected String title;
    protected double price;
    protected boolean transport;
    protected Date start, end;

    public Tour(String code, String title, double price, boolean transport, Date start, Date end) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.transport = transport;
        this.start = start;
        this.end = end;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTransport() {
        return transport;
    }

    public String getTransport() {
        return this.transport ? "aircraft" : "car";
    }

    public void setTransport(boolean transport) {
        this.transport = transport;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public int numberOfDate() {
        return this.end.getDay() - this.start.getDay();
    }

    public double tourCharge() {
        return surcharge() + price;
    }

    @Override
    public String toString() {
        return "Tour{" + "code=" + code + ", title=" + title + ", price=" + price + ", transport=" + getTransport() + ", start=" + start + ", end=" + end + '}';
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int type, op = 0, choice;
        String tCode = null;
        String tTitle;
        double tPrice = 0;
        boolean tTransport = false;
        Date tStart = null;
        Date tEnd = null;
        Tour t = null;
        String fileName;
        FileWriter save;
        FileReader load;
        BufferedReader bf;
        String line;
        TourMethod list = new TourMethod();
        System.out.println("1.Add new tours to the list");
        System.out.println("2.List all domestic tours in the system. ");
        System.out.println("3.Compute the average tour charge of all international tours");
        System.out.println("4.Search tour by tour’s code");
        System.out.println("5.Search tour by title");
        System.out.println("6.Search tour by start date");
        System.out.println("7.Search tour by transport");
        System.out.println("8.Search the first occurrence of the tour having minimum tour charge ");
        System.out.println("9.Remove the tour having given code");
        System.out.println("10.Remove tours with start date after the specified date");
        System.out.println("11.Sort all tours of list by multiple levels in descending order of tour’s price and then in ascending order of tour’s title");
        System.out.println("12.Update tour information");
        System.out.println("13.Save/ Load tours to/ from file");
        do {
            System.out.print("Your option:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Add a new tour:");
                    System.out.println("1-Domestic, 2-International");
                    type = in.nextInt();
                    System.out.print("Tour's code: ");
                    tCode = in.next();
                    System.out.print("Title: ");
                    tTitle = in.next();
                    System.out.print("Price: ");
                    tPrice = in.nextDouble();
                    System.out.print("Transport:(aircraft(a)/car(c) ");
                    tTransport = "a".equalsIgnoreCase(in.next());
                    DateFormat df = new SimpleDateFormat("yyyy/m/d");
                    System.out.println("Start Date: ");
                    try {
                        tStart = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("End Date: ");
                    try {
                        tEnd = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Tour.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    switch (type) {
                        case 1:
                            System.out.print("Tour guide tip: ");
                            double tip = in.nextDouble();
                            t = new Domestic(tCode, tTitle, tPrice, tTransport, tStart, tEnd, tip);
                            break;
                        case 2:
                            System.out.print("Aviation tax: ");
                            double tax = in.nextDouble();
                            System.out.print("Entry fee: ");
                            double fee = in.nextDouble();
                            t = new International(tCode, tTitle, tPrice, tTransport, tStart, tEnd, tax, fee);
                            break;
                    }
                    list.add(t);
                    break;
                case 2:
                    System.out.println("List all domestic tours:");
                    System.out.println(list.domesticList());
                    break;
                case 3:
                    System.out.println("Compute the average tour charge of all international tours:");
                    System.out.println(list.avgInternationalCharge());
                    break;
                case 4:
                    System.out.println("Search tour by tour’s code:");
                    System.out.println("Enter tour’s code:");
                    String sCode = in.next();
                    System.out.println(list.searchCode(sCode));
                    break;
                case 5:
                    System.out.println("Search tour by title:");
                    System.out.println("Enter title: ");
                    String sTitle = in.next();
                    System.out.println(list.searchTitle(sTitle));
                    break;
                case 6:
                    System.out.println("Search tour by start date:");
                    System.out.println("Enter start date");
                    Date sDate = null;
                    DateFormat dfff = new SimpleDateFormat("yyyy/m/d");
                    try {
                        sDate = dfff.parse(in.nextLine());
                    } catch (ParseException ex) {
                    }
                    System.out.println(list.searchStartDate(sDate));
                    break;
                case 7:
                    System.out.println("Search tour by transport:");
                    System.out.println("Enter transport");
                    in.nextLine();
                    String sTransport = in.nextLine();
                    for (Tour t1 : list.searchTransport(sTransport.equalsIgnoreCase("aircraft"))) {
                        System.out.println(t1.toString());
                    }
                    break;
                case 8:
                    System.out.println("Search the first occurrence of the tour having minimum tour charge ");
                    System.out.println(list.firstMinTour());
                    break;
                case 9:
                    System.out.println("Remove the tour having given code");
                    System.out.println("Enter tour code:");
                    String rmcode = in.next();
                    list.removeCode(rmcode);
                    System.out.println("Remove tour done!");
                    break;
                case 10:
                    System.out.println("Remove tours with start date after the specified date");
                    Date rmDate = null;
                    DateFormat dffff = new SimpleDateFormat("yyyy/m/d");
                    System.out.print("date: ");
                    try {
                        rmDate = dffff.parse(in.nextLine());
                    } catch (ParseException ex) {
                    }
                    list.removeStartDate(rmDate);
                    System.out.println("Remove tour done!");
                    break;
                case 11:
                    list.sort();
                    System.out.println(list);
                    break;
                case 12:
                    System.out.println("Update tour information");
                    System.out.println("Enter tour code:");
                    String upIndex = in.next();
                    list.updateTour(upIndex);
                    break;
                case 13:
                    try {
                        System.out.println("13.Save/ Load tours to/ from file");
                        System.out.println("1.Save");
                        System.out.println("2.Load");
                        choice = in.nextInt();
                        switch (choice) {
                            case 1:
                                System.out.println("Save file name(path to folder): ");
                                in.nextLine();
                                fileName = in.nextLine();
                                save = new FileWriter(fileName, true);

                                save.write(t.toString());
                                save.close();
                                System.out.println("File save success!");
                                break;
                            case 2:
                                System.out.println("Load file: ");
                                in.nextLine();
                                fileName = in.nextLine();
                                System.out.println("File load success!");
                                System.out.println("Tour list:");
                                load = new FileReader(fileName);
                                bf = new BufferedReader(load);
                                while ((line = bf.readLine()) != null) {
                                    System.out.println(line);
                                }
                                bf.close();
                                load.close();
                                break;
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }

        } while (op > 0 && op < 14);
    }

}
