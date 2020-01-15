/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3p0052;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Admin
 */
public class EastAsiaCountriesList {

    private ArrayList<EastAsiaCountries> ls = new ArrayList<EastAsiaCountries>();

    public void inputCountry() {
        System.out.print("Enter code of contry: ");
        String countryCode = Validation.checkInputString();
        if (!checkCountryExist(countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = Validation.checkInputString();
        System.out.print("Enter total Area: ");
        double totalArea = Validation.checkInputDouble();
        System.out.print("Enter terrain of country: ");
        String countryTerrain = Validation.checkInputString();
        ls.add(new EastAsiaCountries(countryTerrain, countryCode, countryName, totalArea));
        System.err.println("Add successful.");
    }

    public void printCountry() {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries country : ls) {
            country.display();
        }
    }

    public void searchByName() {
        System.out.print("Enter the name you want to search for: ");
        String countryName = Validation.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries country : ls) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    public void printCountrySorted() {
        Collections.sort(ls);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (EastAsiaCountries country : ls) {
            country.display();
        }
    }

    public boolean checkCountryExist(String countryCode) {
        for (EastAsiaCountries country : ls) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}
