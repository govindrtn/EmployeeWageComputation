package com.bridgelabz;

public class EmployeeWage {
	
	public static void main(String args[]) {
		
        final int PART_TIME = 1;
        final int FULL_TIME = 2;
        final int WAGE_PER_HR = 20;
        final int MAX_WORKING_DAYS = 20;
        final int MAX_WORKING_HRS = 100;

        int totalWage = 0;
        int workingHrs = 0;
        
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS
                && totalWorkingHrs < MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {

            int empType = (int) (Math.random() * 100) % 3;
            switch (empType)
            {
            case FULL_TIME:
                workingHrs = 8;
                break;
            case PART_TIME:
                workingHrs = 4;
                break;
            default:
                workingHrs = 0;
                break;
            }
            int wage = workingHrs * WAGE_PER_HR;
            totalWage += wage;
            System.out.println("Employee Daily wages is as per working hour "+workingHrs+ "  Wage  " + wage);
        }
        System.out.println("Total wage for a month is " + totalWage);
    }
}
