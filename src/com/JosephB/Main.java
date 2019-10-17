package com.JosephB;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    //TODO: Date?????
    private static ArrayList<Employee> myEmployees = new ArrayList<Employee>();

    public static void main(String[] args) {

        boolean quit = false;
        startProgram();
        displayActions();

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action) {
                case 0:
                    System.out.println("\nShutting down...");
                    quit = true;
                    break;

                case 1:
                    displayEmployee();
                    break;

                case 2:
                    addNewEmployee();
                    break;

                case 3:
                    queryEmployee();
                    break;

                case 4:
                    displayActions();;
                    break;
            }
        }
    }

    private static void startProgram() {
        System.out.println("Starting Program...");
    }

    private static void  displayActions() {
        System.out.println();
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to display employees payrolls\n" +
                "2  - to add a new employee pay\n" +
                "3  - query if an existing employee payroll exists"); //5
        System.out.println("Choose your action: ");
    }

    private static void addNewEmployee() {
        System.out.println("Enter Employee name: ");
        String name = scanner.nextLine();
        System.out.println("Enter employee hours ");
        double hours = scanner.nextDouble();
        System.out.println("Enter employee department (1)Restaurant (2)Maintenance (3)Landscapers (4)Sales");
        int department = scanner.nextInt();
        int sales = 0;
        if(department == 4){
            System.out.println("How much did the employee made in sales?");
            sales = scanner.nextInt();
        }

        Employee newEmployee = new Employee(name, department, hours, sales);
        newEmployee.calculateSalary();
        myEmployees.add(newEmployee);

      System.out.println("New employee pay added! \n" );
      System.out.println("********************************************** " );
      System.out.println("Press 4 to continue " );
    }

    private static void queryEmployee() {
        System.out.println();
    }

    public static void displayEmployee() {
        System.out.println("Employee List");
        for(int i=0; i< myEmployees.size(); i++) {

            System.out.println("|---------------------------------------------------------------");
            System.out.println("| EMPLOYEE #" + (i+1) + ":");
            System.out.println("| Name: " +  myEmployees.get(i).getName());
            System.out.println("| Department:  " + myEmployees.get(i).getDepartment());
            System.out.println("| Hours Worked:  " + myEmployees.get(i).getHours());
            System.out.println("| Gross Salary:   " + new DecimalFormat("##.##").format(myEmployees.get(i).getGrossSalary()));
            System.out.println("| Net Salary (After tax, Pension and Insurance):   " + (new DecimalFormat("##.##").format(myEmployees.get(i).calculateSalary())));
            System.out.println("|---------------------------------------------------------------");
        }
        System.out.println("****************************************************************");
        System.out.println("Press 4 to go back to the main menu");

    }

    public boolean addNewEmployee(Employee emp) {
        if(findEmployeeName(emp.getName()) >= 0){
            System.out.println("Employee is already on file!");
            return false;
        }
        myEmployees.add(emp);
        return true;
    }
    private int findEmployee(Employee emp) {
        return this.myEmployees.indexOf(emp);
    }

    private int findEmployeeName(String employeeName) {
        for(int i=0; i<this.myEmployees.size(); i++) {
            Employee emp = this.myEmployees.get(i);
            if(emp.getName().equals(employeeName)) {
                return i;
            }
        }
        return -1;
    }
}
