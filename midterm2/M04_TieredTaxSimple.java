import java.util.*;

public class M04_TieredTaxSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int totalTax = 0; 

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(sc.nextLine());
            int tax = calculateTax(income); 
            totalTax += tax;
            System.out.println("Tax: " + tax);
        }

        int average = totalTax / n; 
        System.out.println("Average: " + average);
    }

   
    private static int calculateTax(int income) {
        int tax = 0;

       
        if (income > 1_000_000) {
            tax += (income - 1_000_000) * 30 / 100;
            income = 1_000_000;
        }
        if (income > 500_000) {
            tax += (income - 500_000) * 20 / 100;
            income = 500_000;
        }
        if (income > 120_000) {
            tax += (income - 120_000) * 12 / 100;
            income = 120_000;
        }
        tax += income * 5 / 100;

        return tax;
    }
}
