import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter your grade: ");
        double grade = input.nextDouble();

        System.out.print("Enter your hobbies: ");
        String hobbies = input.next();

        System.out.println("");

        System.out.println("------------ STUDENT INFORMATION --------------");

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Hobbies: " + hobbies);

        System.out.println("");

        input.close();
    }
}
