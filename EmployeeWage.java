package com.bridgelabz;

public class EmployeeWage {
	
    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;
    
    final String COMPANY_NAME;
    final int WAGE_PER_HR;
    final int MAX_WORKING_DAYS;
    final int MAX_WORKING_HRS;
 
    int totalWage;

    EmployeeWage(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
    	
       this.COMPANY_NAME = companyName;
       this.WAGE_PER_HR = wagePerHr;
       this.MAX_WORKING_DAYS = maxWorkingDays;
       this.MAX_WORKING_HRS = maxWorkingHrs;
       this.totalWage = 0;
    }

    int generateEmployeeType() {
    	
        return (int) (Math.random() * 100) % 3;
    }

    int getWorkingHrs(int empType) {
    	
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

    void calculateTotalWage() {
    	
        System.out.println("Computation of total wage of " + COMPANY_NAME + " employee");
        int workingHrs;
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHrs <= MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {
            int empType = generateEmployeeType();
            workingHrs = getWorkingHrs(empType);
            int wage = workingHrs * WAGE_PER_HR;
            totalWage += wage;
            System.out.println("Employee Daily wages is as per working hour "+workingHrs+ "  Wage  " + wage);
        }
    }

    @Override
    public String toString()
    {
        System.out.println("Details of " + COMPANY_NAME + " employee");
        System.out.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        System.out.println();
        return "Total wage for a month of " + COMPANY_NAME + " employee is " + totalWage ;
    }

    public static void main(String args[])
    {
        EmployeeWage google = new EmployeeWage("Google", 8, 20, 100);
        EmployeeWage Bridgelabz = new EmployeeWage("Bridgelabz", 4, 30, 150);
        EmployeeWage Dmart = new EmployeeWage("Dmart", 4, 30, 150);

        google.calculateTotalWage();
        System.out.println(google);

        Bridgelabz.calculateTotalWage();
        System.out.println(Bridgelabz);
        
       Dmart.calculateTotalWage();
       System.out.println(Dmart);
    }
	
}
