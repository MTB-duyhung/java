package employee;

import java.util.Date;

public class Technician extends Employee {

    protected String work;
    protected static double yearReward = 50000;

    public Technician(String employeeID, String fullName, double salaryCoefficient, Date workStartDate, boolean gender, String work) {
        super(employeeID, fullName, salaryCoefficient, workStartDate, gender);
        this.work=work;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
    
    @Override
    public String toString() {
        return "Technician{" + super.toString()
                + ", work: " + work + "}\n";
    }

    @Override
    public double reward() {
        return this.numberOfYear() 
                * Technician.yearReward;
    }

    @Override
    public double salary() {
        return this.salaryCoefficient
                * Employee.basicSalary
                + this.seniorityAllowance();
    }

}
