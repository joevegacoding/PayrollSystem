package com.JosephB;

import java.util.ArrayList;

public class Employee {


    private String name;
    private int department;
    private double grossSalary;
    private double wage;
    private double hours;
    private double netSalary;
    private int sales;
    private double commission;


    public Employee(String name, int department, double hours, int sales) {
        this.name = name;
        this.department = department;
        this.sales = sales;
        this.hours = hours;
    }

    public double calculateSalesCommission() {


        if((sales > 2500) && (sales <= 4250)) {
            commission = ((sales / 100) * 1.5);
        } else if((sales > 4250) && (sales <= 7000)) {
            commission = ((sales / 100) * 2.5);
        } else if(sales > 7000) {
            commission = ((sales / 100) * 5.0);
        }
        return commission;
    }

    public double calculateSalary() {

        double firstHalfGrossSalary = 35000.00;
        double secondHalfGrossSalary = (grossSalary - 35000.00);
        double fedFirstTax = ((grossSalary / 100) * 16);
        double fedSecondTax = ((grossSalary - 35000.00) - ((grossSalary - 35000.00) / 100 * 22));
        double provFirstTax = ((grossSalary / 100) * 6.05);
        double provSecondTax = ((grossSalary - 35000.00) - ((grossSalary - 35000.00) / 100 * 7.25));
        double pensionFundCanada = ((grossSalary / 100) * 4.95);
        double employmentInsurance = ((grossSalary / 100) * 1.98);

        setWage();
        setGrossSalary();
        calculateSalesCommission();

        if ((grossSalary) <= 35000.00){
            netSalary = grossSalary - (fedFirstTax + provFirstTax + pensionFundCanada + employmentInsurance);
        } else if(((grossSalary) > 35000.00) && grossSalary <= 70000.00) {
            netSalary =  ((firstHalfGrossSalary - (fedFirstTax + provFirstTax)) + (secondHalfGrossSalary - (fedSecondTax + provSecondTax)) - (pensionFundCanada + employmentInsurance));
        }

        if(department == 1 || department == 2 || department == 3){
            return netSalary;

        } else if(department == 4) {

                return netSalary + commission;
            }

        return netSalary;
   }

    public void setName(String name) {
        this.name = name;
    }

   public String getDepartment() {
        String dep = "";
        if(department == 1) {
            dep = "Restaurant";
        }
        if(department == 2) {
           dep =  "Maintenance";
        }
        if(department == 3) {
            dep = "Landscapers";
        }
        if(department == 4) {
            dep = "Sales";
        }
        return dep;
    }

    public void setGrossSalary() {

        if (hours <= 44) {
            grossSalary = hours * wage * 52;
        } else if(hours > 44) {
            grossSalary = (((hours * wage) + ((hours - 44) * (wage * 1.5))) * 52);
        }

    }

    public void setWage() {
        if(department == 1) {
            wage = 8.50;
        } else if(department == 2) {
            wage = 12.50;
        } else if(department == 3) {
            wage = 15.75;
        } else if(department == 4) {
            wage = 15.00;
        }
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getWage() {
        return wage;
    }

    public double getHours() {
        return hours;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

}
