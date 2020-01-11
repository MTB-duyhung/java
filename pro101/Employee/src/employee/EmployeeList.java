package employee;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeList {

    private ArrayList<Employee> m = new ArrayList<>();

    public ArrayList<Employee> getList() {
        return m;
    }

    public Employee getEmployee(int i) {
        return m.get(i);
    }

    void addEmployee(Employee e) {
        getList().add(e);
    }

    public ArrayList<Employee> managerList() {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee v : m) {
            if (v instanceof Manager) {
                list.add(v);
            }
        }
        return list;
    }

    public double technicalSalaryAverage() {
        double sum = 0, count = 0;
        for (Employee v : m) {
            if (v instanceof Technician) {
                sum += v.salary();
                count++;
            }
        }
        return (double) sum / count;
    }

    public Employee searchID(String id) {
        for (Employee v : m) {
            if (id.equals(v.getEmployeeID())) {
                return v;
            }
        }
        return null;
    }

    public ArrayList<Employee> searchName(String name) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee v : m) {
            if (name.compareTo(v.getFullName()) == 0) {
                list.add(v);
            }
        }
        return list;
    }

    /**
     *
     * @param gender
     * @return
     */
    public ArrayList<Employee> searchGender(int gender) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee v : m) {
            if (gender == 0) {
                if (v.isGender() == true) {
                    list.add(v);
                }
            } else if (v.isGender() == false) {
                list.add(v);
            }

        }
        return list;
    }

    public ArrayList<Employee> searchDate(Date date) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee v : m) {
            if (date.compareTo(v.getWorkStartDate()) <= 0) {
                list.add(v);
            }
        }
        return list;
    }

    public void removeID(String id) {

        for (Employee v : m) {
            if (id.equals(v.getEmployeeID())) {
                m.remove(v);
                break;
            }
        }
    }

    public void removeDate(Date d) {
        for (Employee v : m) {
            if (v.getWorkStartDate().compareTo(d) > 0) {
                m.remove(v);
            }
        }
    }

    public Employee lastSalaryMax() {
        double max = m.get(1).salary();
        for (Employee v : m) {
            if (v.salary() >= max) {
                return v;
            }
        }
        return m.get(1);
    }

    public void updateEmployee(String id) {
        String name = null;
        double sc = 0;
        Date da = null;
        boolean gen = false;
        Scanner in = new Scanner(System.in);
        for (Employee v : m) {
            if (id.equals(v.getEmployeeID())) {
                System.out.print("Full name: ");
                name = in.next();
                v.setFullName(name);
                System.out.print("Salary Coefficient: ");
                sc = in.nextDouble();
                v.setSalaryCoefficient(sc);
                DateFormat df = new SimpleDateFormat("yyyy/m/d");
                System.out.println("Start Date: ");
                try {
                    da = df.parse(in.next());
                } catch (ParseException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
                v.setWorkStartDate(da);
                System.out.print("Gender:(f=0/m=1) ");
                int gd = in.nextInt();
                if (gd == 0) {
                    gen = true;
                } else {
                    gen = false;
                }
                v.setGender(gen);
            }
        }
    }
}
