import java.util.Scanner;

public class LabActivity_Siao_NestedLoops {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of square: ");
        int size = scanner.nextInt();

        System.out.println();

        for (int i = 0; i < size; i++) {
            if (i == 0 || i == size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("* ");
                }
            }

            else {
                System.out.print("* ");

                for (int j = 0; j < size - 2; j++) {
                    
                    if (j == i - 1 || j == size - i - 2) {
                        System.out.print("* ");
                    }
                    
                    else if (size % 2 == 1 && j == (size - 2) / 2) {
                        System.out.print("* ");
                    }

                    else if (size % 2 == 1 && i == ((size) / 2)) {
                        System.out.print("* ");
                    }

                    else if (size % 2 == 0 && (j == (size - 2) / 2 || j == ((size - 2) / 2) - 1)) {
                        System.out.print("* ");
                    }

                    else if (size % 2 == 0 && (i == (size - 2) / 2 || i == ((size - 2) / 2) + 1)) {
                        System.out.print("* ");
                    }

                    else {
                        System.out.print("  ");
                    }

                    Thread.sleep(10);

                }

                System.out.print("*");
                
            }

            System.out.println();

            Thread.sleep(10);
        }

        scanner.close();
    }
}
