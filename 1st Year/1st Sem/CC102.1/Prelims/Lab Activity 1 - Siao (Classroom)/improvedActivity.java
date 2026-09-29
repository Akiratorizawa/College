import java.util.Scanner;
import java.util.ArrayList;

public class improvedActivity {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("             CAMPUS CANTEEN BILL                  ");
        System.out.println("==================================================");

        System.out.print("How many items do u have gang? ");
        int numberOfItems = input.nextInt();

        ArrayList<Double> quantities = new ArrayList<>();
        ArrayList<Double> price = new ArrayList<>();
        ArrayList<Double> itemTotals = new ArrayList<>();

        double totalBill = 0;

        for (int i = 0; i < numberOfItems; i++) {
            System.out.print("Enter price of Item " + (i + 1) + ": ");
            price.add(input.nextDouble());

            System.out.print("Enter quantity: ");
            quantities.add(input.nextDouble());

            itemTotals.add((price.get(i) * quantities.get(i)));
        }

        for (int i = 0; i < numberOfItems; i++) {
            System.out.print("\nItem " + (i + 1) + " Total: " + itemTotals.get(i));
            totalBill += itemTotals.get(i);
        }

        System.out.println("\nTOTAL BILL: " + totalBill + "\n");

        System.out.print("Enter Amount Paid: ");

        double amountPaid = input.nextDouble();

        System.out.println("CHANGE: " + (amountPaid - totalBill));
        System.out.println("==================================================");

        input.close();
    }
}