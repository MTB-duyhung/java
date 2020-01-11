package patient;

import java.util.Date;

public class OutPatient extends Patient {

    protected double examinationFee, testingFee;

    public OutPatient(String code, String fullName, Date hospitalizedDate, boolean gender, double medicineCost,double examinationFee, double testingFee) {
        super(code, fullName, hospitalizedDate, gender, medicineCost);
        this.examinationFee = examinationFee;
        this.testingFee = testingFee;
    }

    public double getExaminationFee() {
        return examinationFee;
    }

    public void setExaminationFee(double examinationFee) {
        this.examinationFee = examinationFee;
    }

    public double getTestingFee() {
        return testingFee;
    }

    public void setTestingFee(double testingFee) {
        this.testingFee = testingFee;
    }

    @Override
    public double medicineFee() {
        return this.medicineCost;
    }

    @Override
    public double hospitalFee() {
        return this.examinationFee + this.testingFee + this.medicineFee();
    }

}
