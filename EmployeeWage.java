package com.bridgelabz;

class CompanyEmpWage
{
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;

    int totalEmpWage;

    CompanyEmpWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        COMPANY_NAME = companyName;
        WAGE_PER_HR = wagePerHr;
        MAX_WORKING_DAYS = maxWorkingDays;
        MAX_WORKING_HRS = maxWorkingHrs;
        totalEmpWage = 0;
    }

    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }

    public String toString()
    {
    	 System.out.println("Details of " + COMPANY_NAME + " employee");
         System.out.println("Wage per hour:" + WAGE_PER_HR);
         System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
         System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
         System.out.println();
        return "Total wage for a month of " + COMPANY_NAME + " employee total wages" + totalEmpWage + "\n";
    }
}

public class EmployeeWage
{
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
 
    int noOfCompanies, index;
    CompanyEmpWage[] companies;

    public EmployeeWage(int noOfCompanies)
    {
        this.noOfCompanies = noOfCompanies;
        companies = new CompanyEmpWage[noOfCompanies];
        index = 0;
    }

    void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
    }

    int generateEmployeeType()
    {
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType)
    {
        switch (empType)
        {
        case FULL_TIME:
            return 8;
        case PART_TIME:
            return 4;
        default:
            return 0;
        }
    }

    void calculateTotalWage()
    {
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }

    int calculateTotalWage(CompanyEmpWage companyEmpWage)
    {
      
        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            System.out.println("Employee Daily wages is as per working hour "+workingHrs+ "  Wage  " + wage);
        }
        return totalWage;
    }

    public static void main(String args[])
    {
        EmployeeWage employeeWageComputation = new EmployeeWage(3);
        employeeWageComputation.addCompany("BridgeLabz", 4, 30, 100);
        employeeWageComputation.addCompany("Google", 5, 40, 170);
        employeeWageComputation.addCompany("Dmart", 9, 10, 70);
        employeeWageComputation.calculateTotalWage();
    }
}
