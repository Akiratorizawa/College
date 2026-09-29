// Weekly Expense Tracker
// 09/28/26
// CC102.1 - Midterm

import java.util.Scanner;

public class LabActivity_Siao_DailyExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======= WEEKLY EXPENSE TRACKER =======");

        // Get information
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Weekly Allowance: ");
        double allowance = scanner.nextDouble();

        System.out.print("Enter Number of School Days: ");
        int schoolDays = scanner.nextInt();
        
        double totalExpenses = 0;

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Expense for Day " + i + ": ");
            int dayExpense = scanner.nextInt();

            totalExpenses += dayExpense;
        }
        
        double avgDailyExpense = totalExpenses / schoolDays;
        double remainingAllowance = allowance - totalExpenses;

        System.out.println("\n============ SUMMARY =============");
        System.out.println("Student: " + name);
        System.out.println("Weekly Allowance: " + allowance);
        System.out.println("Total Expense: " + totalExpenses);
        System.out.println("Average Daily Expense: " + avgDailyExpense);
        System.out.println("Remaining Allowance: " + remainingAllowance);
        System.out.print("Status: ");

        if (remainingAllowance >= 0) {
            System.out.println("WITHIN BUDGET");
        }

        else {
            System.out.println("OVER BUDGET");
        }

        System.out.println("==================================");

        scanner.close();
        return;
    }    
}
