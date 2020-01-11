package employee;

import java.util.Date;

public class Manager extends Employee {

    protected String position;
    protected double positionAllowance;
    protected static double yearReward = 100000;

    public Manager(String employeeID, String fullName, double salaryCoefficient, Date workStartDate, boolean gender,String position, double positionAllowance) {
        super(employeeID, fullName, salaryCoefficient, workStartDate, gender);
    this.position =position;
    this.positionAllowance=positionAllowance;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPositionAllowance() {
        return positionAllowance;
    }

    public void setPositionAllowance(double positionAllowance) {
        this.positionAllowance = positionAllowance;
    }

    @Override
    public double reward() {
        return this.numberOfYear()
                * Manager.yearReward;
    }

    @Override
    public double salary() {
        return this.salaryCoefficient
                * Employee.basicSalary
                + this.seniorityAllowance()
                + this.positionAllowance;
    }
}
