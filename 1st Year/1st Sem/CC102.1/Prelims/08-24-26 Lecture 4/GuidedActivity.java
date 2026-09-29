import java.util.Scanner;

public class GuidedActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final double BW_PAGE_COST = 3.0;
        final double COLORED_PAGE_COST = 10.0;

        System.out.print("Enter number of B&W pages: ");
        int bwPages = input.nextInt();

        System.out.print("Enter number of colored pages: ");
        int coloredPages = input.nextInt();

        input.close();

        System.out.println("____________________________________");

        System.out.println("");

        double bwCost = bwPages * BW_PAGE_COST;
        double coloredCost = coloredPages * COLORED_PAGE_COST;

        System.out.println("B&W Printing Cost: " + bwCost);
        System.out.println("Colored Printing Cost: " + coloredCost);

        System.out.println("");

        System.out.println("Total Printing Cost: " + (bwCost + coloredCost));

        
    }
}