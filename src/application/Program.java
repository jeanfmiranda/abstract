package application;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Person> list = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char opc = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            Double annualIncome = sc.nextDouble();

            if(opc == 'i') {
                System.out.print("Health expenditures: ");
                double healthCost = sc.nextDouble();
                list.add(new PhysicalPerson(name, annualIncome, healthCost));
            }
            else {
                System.out.print("Number of employees: ");
                int nEmployees = sc.nextInt();
                list.add(new LegalPerson(name, annualIncome, nEmployees));
            }
        }

        System.out.println();
        System.out.println("TAXES PAID:");

        for (Person p:list) {
            System.out.println(p.getName() + ": $ " + String.format("%.2f", p.taxAmount()));
        }
        double totalTaxes = 0;
        for (Person p:list) {
            totalTaxes += p.taxAmount();
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));

        sc.close();
    }
}