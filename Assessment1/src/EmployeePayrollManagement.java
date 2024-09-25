import java.util.Scanner;

import static java.lang.System.*;


public class EmployeePayrollManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Initialisation (Permanent Employee):");
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Employee Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Enter Employee basic Salary: ");
        float basicSalary = sc.nextFloat();
        System.out.print("Enter Employee PF Amount: ");
        int pf = sc.nextInt();
/
        PermanentEmployee emp = new PermanentEmployee(id, name, basicSalary, pf);
        emp.calculateNetSalary();
        System.out.println("the details are:");
        emp.displayDetails();
        sc.close();
    }
}