// Number Analysis
// CC102.1 Lab
// 09/29/2026
import java.util.Scanner;

public class LabActivity_Siao_NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========== NUMBER ANALYSIS SYSTEM =============");

        System.out.print("Enter how many numbers you want to analyze: ");
        int numbers = scanner.nextInt();

        System.out.println();

        int sum = 0;

        int totalNumbers = 0;

        int totalPositives = 0;
        int totalNegatives = 0;
        int totalZeroes = 0;

        int totalEvens = 0;
        int totalOdds = 0;

        int totalDivisibleBy5 = 0;

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        
        for (int i = 1; i <= numbers; i++) {
            System.out.println("------------ NUMBER " + i + " -----------------");

            System.out.print("Enter Number: ");
            int number = scanner.nextInt();
            
            if (number > highest) {
                highest = number;
            }
            
            if (number < lowest) {
                lowest = number;
            }

            totalNumbers++;
            sum += number;
            
            // Sign
            System.out.print("Sign: ");

            if (number > 0) {
                System.out.println("POSITIVE");
                totalPositives++;
            }

            else if (number < 0) {
                System.out.println("NEGATIVE");
                totalNegatives++;
            }

            else {
                System.out.println("ZERO");
                totalZeroes++;
            }

            // Type
            System.out.print("Type: ");

            if (number % 2 == 0) {
                System.out.println("EVEN");
                totalEvens++;
            }

            else {
                System.out.println("ODD");        
                totalOdds++;    
            }

            // Division by 5
            System.out.print("Divisible by 5: ");

            if (number % 5 == 0) {
                System.out.println("YES");
                totalDivisibleBy5++;
            }

            else {
                System.out.println("NO");
            }
            
            System.out.println();
        }

        System.out.println("============ ANALYSIS SUMMARY ==============");
        System.out.println("Total Numbers: " + totalNumbers);
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + 1.0 * sum / totalNumbers + "\n");

        System.out.println("Positive Numbers: " + totalPositives);
        System.out.println("Negative Numbers: " + totalNegatives);
        System.out.println("Zero Values: " + totalZeroes + "\n");

        System.out.println("Even Numbers: " + totalEvens);
        System.out.println("Odd Numbers: " + totalOdds + "\n");

        System.out.println("Numbers Divisible by 5: " + totalDivisibleBy5 + "\n");

        System.out.println("Highest Number: " + highest);
        System.out.println("Lowest Number: " + lowest + "\n");

        System.out.print("Even vs Odd Result: ");
        
        if (totalEvens > totalOdds) {
            System.out.println("MORE EVEN NUMBERS");
        }

        else if (totalOdds > totalEvens) {
            System.out.println("MORE ODD NUMBERS");
        }

        else {
            System.out.println("EQUAL EVEN AND ODD VALUES");
        }

        System.out.print("Sign Result: ");

        if (totalPositives > totalNegatives) {
            System.out.println("MORE POSITIVE VALUES");
        }

        else if (totalNegatives > totalPositives) {
            System.out.println("MORE NEGATIVE VALUES");
        }

        else {
            System.out.println("EQUAL POSITIVE AND NEGATIVE VALUES");
        }

        System.out.println("============================");

        scanner.close();
    }
}
