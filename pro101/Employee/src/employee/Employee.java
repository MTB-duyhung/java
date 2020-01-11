package employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Employee implements NewInterface {

    protected String employeeID, fullName;
    protected double salaryCoefficient;
    protected Date workStartDate;
    protected boolean gender;

    public Employee(String employeeID, String fullName, double salaryCoefficient, Date workStartDate, boolean gender) {
        this.employeeID = employeeID;
        this.fullName = fullName;
        this.salaryCoefficient = salaryCoefficient;
        this.workStartDate = workStartDate;
        this.gender = gender;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalaryCoefficient() {
        return salaryCoefficient;
    }

    public void setSalaryCoefficient(double salaryCoefficient) {
        this.salaryCoefficient = salaryCoefficient;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("yyyy/m/d");
        return "Employee{" + "employeeID=" + employeeID + ", fullName=" + fullName + ", salaryCoefficient="
                + salaryCoefficient + ", workStartDate=" + df.format(workStartDate) + ", gender=" + gender + '}';
    }

    public long numberOfYear() {
        return (Calendar.getInstance().getTime().getTime()
                - this.workStartDate.getTime()) / 1000 / 60 / 60 / 24 / 365;
    }

    public double seniorityAllowance() {
        return this.numberOfYear() * Employee.yearSeniorityAllowance;
    }

    public abstract double reward();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int type, op = 0;
        String id = null, name = null;
        double sc = 0;
        Date da = null;
        boolean gen = false;
        Employee e = null;
        EmployeeList list = new EmployeeList();
        do {
            System.out.println("1.Add new employees to the ArrayList");
            System.out.println("2.List all managers in the ArrayList");
            System.out.println("3.Compute the average salary of all technicians");
            System.out.println("4.Search employee by employee index");
            System.out.println("5.Search employee by fullname");
            System.out.println("6.Search employee by gender");
            System.out.println("7.Search employee by working start date");
            System.out.println("8.Remove employee having specified employee index");
            System.out.println("9.Remove employees with working start date after the specified date");
            System.out.println("10.Search the last occurrence of the employee having maximum salary ");
            System.out.println("11.Update employee information");
            System.out.print("Your option:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Add a new employee:");
                    System.out.println("1-Technician,2-Manager");
                    type = in.nextInt();
                    System.out.print("Employee ID: ");
                    id = in.next();
                    System.out.print("Full name: ");
                    name = in.next();
                    System.out.print("Salary Coefficient: ");
                    sc = in.nextDouble();
                    DateFormat df = new SimpleDateFormat("yyyy/m/d");
                    System.out.println("Start Date: ");
                    try {
                        da = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("Gender:(f=0/m=1) ");
                    int gd = in.nextInt();
                    if (gd == 0) {
                        gen = true;
                    }
                    if (gd == 1) {
                        gen = false;
                    }

                    switch (type) {
                        case 1:
                            System.out.print("Work: ");
                            String w = in.next();
                            e = new Technician(id, name, sc, da, gen, w);

                            break;
                        case 2:
                            System.out.print("Position: ");
                            String p = in.next();
                            System.out.print("Position Allowance: ");
                            double pA = in.nextDouble();
                            e = new Manager(id, name, sc, da, gen, p, pA);
                            break;
                    }
                    list.addEmployee(e);
                    break;

                case 2:
                    System.out.println("List all managers:");
                    System.out.println(list.managerList());
                    break;
                case 3:
                    System.out.println("Compute the average salary of all technicians:");
                    System.out.println(list.technicalSalaryAverage());
                    break;
                case 4:
                    System.out.println("Search employee by employee index:");
                    System.out.println("Enter employee index:");
                    String index = in.next();
                    System.out.println(list.searchID(index));
                    break;
                case 5:
                    System.out.println("Search employee by fullname:");
                    System.out.println("Enter employee fullname");
                    String fullName = in.next();
                    System.out.println(list.searchName(fullName));
                    break;
                case 6:
                    System.out.println("Search employee by gender/(male=1,female=0/):");
                    System.out.println("Enter employee gender");
                    int gender = in.nextInt();
                    if (gender == 0) {
                        System.out.println(list.searchGender(0));
                    } else if (gender == 1) {
                        System.out.println(list.searchGender(1));
                    }
                    break;
                case 7:
                    System.out.println("Search employee by working sart date:");
                    System.out.println("Enter employee working start date");
                    Date wsDate = null;
                    DateFormat dfff = new SimpleDateFormat("yyyy/m/d");
                    System.out.print("birthday: ");
                    try {
                        wsDate = dfff.parse(in.nextLine());
                    } catch (ParseException ex) {
                    }
                    System.out.println(list.searchDate(wsDate));
                    break;
                case 8:
                    System.out.println("Remove employee having specified employee index");
                    System.out.println("Enter employee index:");
                    String rmIndex = in.next();
                    list.removeID(rmIndex);
                    System.out.println("Remove employee done!");
                    break;
                case 9:
                    System.out.println("Remove employees with working start date after the specified date");
                    Date rmDate = null;
                    DateFormat dffff = new SimpleDateFormat("yyyy/m/d");
                    System.out.print("birthday: ");
                    try {
                        rmDate = dffff.parse(in.nextLine());
                    } catch (ParseException ex) {
                    }
                    list.searchDate(rmDate);
                    System.out.println("Remove employee done!");
                    break;
                case 10:
                    System.out.println("Search the last occurrence of the employee having maximum salary ");
                    System.out.println(list.lastSalaryMax());
                    break;
                case 11:
                    System.out.println("Update employee information");
                    System.out.println("Enter employee index:");
                    String upIndex = in.next();
                    list.updateEmployee(upIndex);
            }
            System.out.println("---------------------");
        } while (0 < op && op < 12);

        //System.out.println("Salary: " + e.salary());
        //System.out.println("Reward: " + e.reward());
    }
}
