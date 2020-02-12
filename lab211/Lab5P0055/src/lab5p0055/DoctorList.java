/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5p0055;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DoctorList {

    public void addDoctor(ArrayList<Doctor> ld) {
        System.out.println("Enter code: ");
        String code = Validation.checkInputString();
        if (!Validation.checkCodeExist(ld, code)) {
            System.err.println("Doctor exist.");
            return;
        }
        System.out.println("Enter Name: ");
        String name = Validation.checkInputString();
        System.out.println("Enter Specialization: ");
        String specialization = Validation.checkInputString();
        System.out.println("Enter Availability: ");
        int availability = Validation.checkInputInt();
        ld.add(new Doctor(code, name, specialization, availability));
        System.err.println("Add successful.");
    }

    public void updateDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validation.checkInputString();
        if (Validation.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.out.print("Enter code: ");
        if (!Validation.checkChangeInfo(doctor, code, name, specialization, availability)) {
            System.err.println("No change");
            return;
        }
        doctor.setCode(codeUpdate);
        doctor.setName(name);
        doctor.setSpecialization(specialization);
        doctor.setAvailability(availability);
        System.err.println("Update successful");
    }

    public void deleteDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter code: ");
        String code = Validation.checkInputString();
        if (Validation.checkCodeExist(ld, code)) {
            System.err.println("Not found doctor");
            return;
        }
        System.err.println("Delete successful.");
    }

    public void searchDoctor(ArrayList<Doctor> ld) {
        System.out.print("Enter name: ");
        String nameSearch = Validation.checkInputString();
    }

    public Doctor getDoctorByCode(ArrayList<Doctor> ld, String code) {
        for (Doctor doctor : ld) {
            if (doctor.getCode().equalsIgnoreCase(code)) {
                return doctor;
            }
        }
        return null;
    }

    public ArrayList<Doctor> listFoundByName(ArrayList<Doctor> ld, String name) {
        ArrayList<Doctor> listFoundByName = new ArrayList<>();
        for (Doctor doctor : ld) {
            if (doctor.getName().contains(name)) {
                listFoundByName.add(doctor);
            }
        }
        return listFoundByName;
    }
}
