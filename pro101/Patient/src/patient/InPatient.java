package patient;

import java.util.Calendar;
import java.util.Date;

public class InPatient extends Patient {

    protected double dailyFee;
    protected Date dischargedDate;

    public InPatient(String code, String fullName, Date hospitalizedDate, boolean gender, double medicineCost, double dailyFee, Date dischargedDate) {
        super(code, fullName, hospitalizedDate, gender, medicineCost);
        this.dailyFee = dailyFee;
        this.dischargedDate = dischargedDate;
    }

    public double getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }

    public Date getDischargedDate() {
        return dischargedDate;
    }

    public void setDischargedDate(Date dischargedDate) {
        this.dischargedDate = dischargedDate;
    }

    public long numberOfDate() {
        return (this.dischargedDate.getTime()
                - this.hospitalizedDate.getTime()) / 1000 / 60 / 60 / 24;
    }

    @Override
    public double medicineFee() {
        return this.medicineCost * this.numberOfDate();
    }

    @Override
    public double hospitalFee() {
        return this.dailyFee * this.numberOfDate() + this.medicineFee();
    }

}
