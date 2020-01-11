package patient;

import java.util.ArrayList;
import java.util.Date;

public class PatientList {

    private ArrayList<Patient> m = new ArrayList<>();

    public ArrayList<Patient> getM() {
        return m;
    }

    public Patient getPatient(int i) {
        return m.get(i);
    }

    public void addPatient(Patient p) {
        getM().add(p);
    }

    public double hospitalFeeAverage() {
        double sum = 0, count = 0;
        for (Patient v : m) {
            if (v instanceof InPatient) {
                sum += v.hospitalFee();
                count++;
            }
        }
        return (double) sum / count;
    }

    public ArrayList<Patient> outPatientList() {
        ArrayList<Patient> list = new ArrayList<>();
        for (Patient v : m) {
            if (v instanceof OutPatient) {
                list.add(v);
            }
        }
        return list;
    }

    public Patient searchCode(String code) {
        for (Patient v : m) {
            if (code.equals(v.getCode())) {
                return v;
            }
        }
        return null;
    }

    public Patient lastSalaryMax() {
        double min = m.get(1).hospitalFee();
        for (Patient v : m) {
            if (v.hospitalFee() <= min) {
                return v;
            }
        }
        return m.get(1);
    }

//    public void removeDate(Date d) {
//        for (Patient v : m) {
//            
//                if ((v instanceof InPatient) && d.compareTo(v.getDischargedDate()) > 0)
//                m.remove(v);
//            
//        }
//    }

}
