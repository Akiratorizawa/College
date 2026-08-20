package TerminalRPG;

import java.util.Scanner;
import static TerminalRPG.Play.play;

public class Helpers {
    
    static Scanner input = new Scanner(System.in);

    public static void mainMenu() {
        ASCIILogo();
        String mainMenu = """
                Welcome to Valorant, a 2D text-based Pokemon battle simulator!
                What would you like to do?
                1 - Play
                2 - About
                3 - Quit
                """;

        int choice = 0;

        System.out.println(mainMenu);

        choice = optionChoice(1, 3);

        if (choice == 2) {
            aboutPage();
        } else if (choice == 1) {
            try {
                play();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    public static int optionChoice(int start, int end) {
        int option = 0;

        while (true) {
            try {
                option = input.nextInt();
            }

            catch (java.util.InputMismatchException e) {
                optionError();
                input.nextLine();
                
            }

            if (option >= start && option <= end) {
                System.out.println("");
                return option;
            } else {
                optionError();
                input.nextLine();
            }
        }
    }

    public static void aboutPage() {
        System.out.println("""

                This is a 2D random Pokemon battle simulator I made to practice OOP and just Java in general.
                I have no clue where this project is going, but I'll try to make it great :D

                Enter any number to return to the main menu.
                
                """);

        boolean back = false;

        while (true) {
            try {
                input.nextInt();
                back = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Enter any number to return to the main menu.\n");
                input.nextLine();
            }

            if (back == true) {
                mainMenu();
            }
            
        }
    }

    public static void optionError() {
        System.out.println("Please input a valid option.");
    }


    public static void ASCIILogo() {
        String logo = """

█   █  ███  █      ███  ████   ███  █   █ █████ 
█   █ █   █ █     █   █ █   █ █   █ ██  █   █   
█   █ █████ █     █   █ ████  █████ █ █ █   █   
 █ █  █   █ █     █   █ █  █  █   █ █  ██   █   
  █   █   █ █████  ███  █   █ █   █ █   █   █   

                """;
                System.out.println(logo);
    }

}
