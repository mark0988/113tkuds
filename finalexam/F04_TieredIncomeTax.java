import java.util.*;

public class F04_TieredIncomeTax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        double totalTax = 0; 
        
        
        for (int i = 0; i < n; i++) {
            double income = scanner.nextDouble();
            double tax = calculateTax(income);
            totalTax += tax;
            System.out.printf("Tax: $%.0f\n", tax);
        }
        
        
        double averageTax = totalTax / n;
        System.out.printf("Average: $%.0f\n", averageTax);
        
        scanner.close();
    }
    
    
    private static double calculateTax(double income) {
        double tax = 0;
        
        
        if (income <= 540000) {
            tax = income * 0.05;
        } else if (income <= 1210000) {
            tax = 540000 * 0.05 + (income - 540000) * 0.12;
        } else if (income <= 2420000) {
            tax = 540000 * 0.05 + (1210000 - 540000) * 0.12 + (income - 1210000) * 0.2;
        } else if (income <= 4530000) {
            tax = 540000 * 0.05 + (1210000 - 540000) * 0.12 + (2420000 - 1210000) * 0.2 + (income - 2420000) * 0.3;
        } else {
            tax = 540000 * 0.05 + (1210000 - 540000) * 0.12 + (2420000 - 1210000) * 0.2 + (4530000 - 2420000) * 0.3 + (income - 4530000) * 0.4;
        }
        
        return tax;
    }
}
// 計算複雜度分析：
// 1. 讀取每一個收入並計算其稅額的過程是 O(n)，因為每個收入只需要一次的計算。
// 2. 計算每個人的稅額是 O(1)，對每個收入進行分級計算，不需要進行多次的遍歷。
// 3. 輸出每一個人的稅額及平均稅額的過程是 O(n)，每個人的稅額都會被輸出一次，最後再計算平均稅額。
// 因此，整個程式的時間複雜度是 O(n)，其中 n 是收入的數量。
// 空間複雜度是 O(1)，因為我們只需要記錄每個人的稅額和總稅額，並不需要額外的存儲結構。
