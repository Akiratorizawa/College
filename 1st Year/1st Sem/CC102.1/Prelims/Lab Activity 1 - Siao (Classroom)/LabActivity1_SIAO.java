import java.util.Scanner;

public class LabActivity1_SIAO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("             CAMPUS CANTEEN BILL            ");
        System.out.println("============================================\n");

        System.out.print("Enter price of Item 1: ");
        double price1 = input.nextDouble();

        System.out.print("Enter quantity: ");
        double quantity1 = input.nextDouble();

        System.out.print("Enter price of Item 2: ");
        double price2 = input.nextDouble();

        System.out.print("Enter quantity: ");
        double quantity2 = input.nextDouble();

        System.out.print("Enter price of Item 3: ");
        double price3 = input.nextDouble();

        System.out.print("Enter quantity: ");
        double quantity3 = input.nextDouble();

        double item1Total= price1 * quantity1;
        double item2Total= price2 * quantity2;
        double item3Total= price3 * quantity3;

        double totalBill = item1Total + item2Total + item3Total;

        System.out.println("");

        System.out.println("Item 1 Total: " + item1Total);
        System.out.println("Item 2 Total: " + item2Total);
        System.out.println("Item 3 Total: " + item3Total);
        System.out.println("TOTAL BILL: " + totalBill);

        System.out.println("");

        System.out.print("Enter Amount Paid: ");
        double amountPaid = input.nextDouble();

        double change = amountPaid - totalBill;

        System.out.println("CHANGE: " + change);
        System.out.println("============================================");

        input.close();
    }
}
