/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package feereport;

/**
 *
 * @author Admin
 */
public class FeeReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AccountantList lac = new AccountantList();
        StudentList lst = new StudentList(lac);
        int id = 0, idst = 0;
        while (true) {
            Manager.menu();
            int choice = Validation.checkInputIntLimit(1, 3);
            switch (choice) {
                case 1:
                    int choice1 = 0;
                    if (lac.loginAdmin() != false) {
                            lac.readObjectFile("account.txt");
                        do {
                            Manager.menuAdmin();
                            choice1 = Validation.checkInputIntLimit(1, 4);
                            switch (choice1) {
                                case 1:
                                    lac.addAccountant(id);
                                    id++;
                                    break;
                                case 2:
                                    lac.viewAccountant();
                                    break;
                            }
                        } while (choice1 != 3);
                        lac.writeObjectFile("account.txt");
                        break;
                    }
                    break;

                case 2:
                    int choice2 = 0;
                    lac.readObjectFile("account.txt");
                    if (lst.loginAcc()!= false) {
                        lst.readObjectFile("student.txt");
                        do {
                            Manager.menuAccountant();
                            choice2 = Validation.checkInputIntLimit(1, 6);
                            switch (choice2) {
                                case 1:
                                    lst.addStudent(idst);
                                    idst++;
                                    break;
                                case 2:
                                    lst.viewStudent();
                                    break;
                                case 3:
                                    lst.editStudent();
                                    break;
                                case 4:
                                    lst.dueFee();
                                    break;
                            }
                        } while (choice2 != 5);
                        lst.writeObjectFile("student.txt");
                        break;
                    }
                    break;

                case 3:
                    return;
            }
        }
    }

}

