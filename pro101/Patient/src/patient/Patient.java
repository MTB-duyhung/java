package patient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Patient implements IPatient {

    protected String code;
    protected String fullName;
    protected Date hospitalizedDate;
    protected boolean gender;
    protected double medicineCost;

    public Patient(String code, String fullName, Date hospitalizedDate, boolean gender, double medicineCost) {
        this.code = code;
        this.fullName = fullName;
        this.hospitalizedDate = hospitalizedDate;
        this.gender = gender;
        this.medicineCost = medicineCost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getHospitalizedDate() {
        return hospitalizedDate;
    }

    public void setHospitalizedDate(Date hospitalizedDate) {
        this.hospitalizedDate = hospitalizedDate;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public double getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(double medicineCost) {
        this.medicineCost = medicineCost;
    }

    @Override
    public String toString() {
        return "Patient{" + "code=" + code + ", fullName=" + fullName + ", hospitalizedDate=" + hospitalizedDate + ", gender=" + gender + ", medicineCost=" + medicineCost + '}';
    }

    public abstract double medicineFee();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pCode = null;
        String pFullName = null;
        Date pHospitalizedDate = null;
        boolean pGender = false;
        double pMedicineCost = 0;
        Patient p = null;
        PatientList list = new PatientList();
        int op, type;
        
            System.out.println("1.Add new patients to the ArrayList");
            System.out.println("2.Compute the hospital’s fee average of all the in-patients");
            System.out.println("3.List out-patient information including hospital’s fee");
            System.out.println("4.Search the patient by specified patient code");
            System.out.println("5.Search the last occurrence of the patient having minimum hospital’s fee");
            System.out.println("6.Remove the in-patients released from hospital after specified date");
            do {
            System.out.print("Your option:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Add a new patient:");
                    System.out.println("1-Out-Patient,2-In-Patient");
                    type = in.nextInt();
                    System.out.print("Patient Code: ");
                    pCode = in.next();
                    System.out.print("Full name: ");
                    pFullName = in.next();
                    DateFormat df = new SimpleDateFormat("yyyy/m/d");
                    System.out.println("Hopitalized Date: ");
                    try {
                        pHospitalizedDate = df.parse(in.next());
                    } catch (ParseException ex) {
                        Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("Gender:(f=0/m=1) ");
                    int gen = in.nextInt();
                    if (gen == 0) {
                        pGender = true;
                    }
                    if (gen == 1) {
                        pGender = false;
                    }
                    System.out.println("Medicine Cost: ");
                    pMedicineCost=in.nextDouble();

                    switch (type) {
                        case 1:
                            System.out.print("Examination Fee: ");
                            Double pExaminationFee = in.nextDouble();
                            System.out.println("Testing Fee: ");
                            Double pTestingFee = in.nextDouble();
                            p = new OutPatient(pCode, pFullName, pHospitalizedDate, pGender, pMedicineCost, pExaminationFee, pTestingFee);
                            break;
                        case 2:
                            System.out.print("Daily Fee: ");
                            Double pDailyFee = in.nextDouble();
                            System.out.println("Discharged Date: ");
                            Date pDischargedDate=null;
                            try {
                                pDischargedDate = df.parse(in.next());
                            } catch (ParseException ex) {
                                Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            p = new InPatient(pCode, pFullName, pHospitalizedDate, pGender, pMedicineCost, pDailyFee, pDischargedDate);
                            break;
                    }
                    list.addPatient(p);
                    break;
                case 2:
                    System.out.println("The hospital’s fee average of all the in-patients:");
                    System.out.println(list.hospitalFeeAverage());
                    break;
                case 3:
                    System.out.println("List out-patient:");
                    System.out.println(list.outPatientList());
                    break;
                
                case 4:
                    System.out.println("Search the patient by specified patient code:");
                    System.out.println("Enter patient code:");
                    String sCode = in.next();
                    System.out.println(list.searchCode(sCode));
                    break;
                case 5:
                    System.out.println("Search the last occurrence of the patient having minimum hospital’s fee:");
                    System.out.println(list.lastSalaryMax());
                    break;
                case 6:
//                    System.out.println("Remove the in-patients released from hospital after specified date:");
//                    System.out.println("Enter employee gender");
//                    int gender = in.nextInt();
//                    if (gender == 0) {
//                        System.out.println(list.searchGender(0));
//                    } else if (gender == 1) {
//                        System.out.println(list.searchGender(1));
//                    }
                    break;
                
            }
            System.out.println("---------------------");
        } while (0 < op && op < 12);
    }
}
