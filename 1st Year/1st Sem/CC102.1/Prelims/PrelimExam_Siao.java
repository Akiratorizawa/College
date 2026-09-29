import java.util.Scanner;
import java.util.ArrayList;

public class PrelimExam_Siao {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Student Information
        System.out.println("-------------NAME----------------");

        System.out.println("First Name:");
        String firstName = input.nextLine();

        System.out.println("Middle Initial: ");
        String middleInitial = input.nextLine();

        System.out.println("Last Name: ");
        String lastName = input.nextLine();

        String fullName = firstName + " " + middleInitial + ". " + lastName;

        // Grade inputting
        String[] terms = {"PRELIMS", "MIDTERMS", "FINALS"};

        ArrayList<Double> finalGrades = new ArrayList<>();
        
        for (int i = 0; i < terms.length; i++) {
            System.out.println("-------------" + terms[i] + "-----------------");
            System.out.println("Attendance Grade: ");
            double attendance = input.nextDouble();

            System.out.println("Class Participation Grade: ");
            double participation = input.nextDouble();
        
            System.out.println("Quiz Grade: ");
            double quiz = input.nextDouble();

            System.out.println("Exam Grade: ");
            double exam = input.nextDouble();

            double termGrade = (attendance * 0.05) + (participation * 0.15) + (quiz * 0.30) + (exam * 0.50);

            finalGrades.add(termGrade);
        }

        // Calculating final semester grade
        char semesterLetterGrade;

        double semesterGrade = (finalGrades.get(0) * 0.25) + (finalGrades.get(1) * 0.25) + (finalGrades.get(2) * 0.50);

        boolean passed = true;

        if (semesterGrade >= 95 && semesterGrade <= 100) {
            semesterLetterGrade = 'A';
        }

        else if (semesterGrade >= 90 && semesterGrade <= 94.99) {
            semesterLetterGrade = 'B';
        }

        else if (semesterGrade >= 85 && semesterGrade <= 89.99) {
            semesterLetterGrade = 'C';
        }

        else if (semesterGrade >= 80 && semesterGrade <= 84.99) {
            semesterLetterGrade = 'D';
        }

        else if (semesterGrade >= 75 && semesterGrade <= 79.99) {
            semesterLetterGrade = 'E';
        }

        else {
            semesterLetterGrade = 'F';
            passed = false;
        }
        
        
        // Summary
        System.out.println("------------SUMMARY-----------");
        System.out.println("Name: " + fullName);
        System.out.println("Prelim Grade: " + finalGrades.get(0));
        System.out.println("Midterm Grade: " + finalGrades.get(1));
        System.out.println("Final Grade: " + finalGrades.get(2));
        System.out.println("Semester Grade: " + semesterGrade + "(" + semesterLetterGrade + ")");

        if (passed) {
            System.out.println("Status: PASSED");
        }

        else {
            System.out.println("Status: FAILED");
        }

        System.out.println("----------------------------------");

        input.close();
        return;
    }


}
