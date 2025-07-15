// 時間複雜度：O(n)，每筆用電度數計算一次
// 空間複雜度：O(n)，儲存輸入用電量
import java.util.*;

public class Q4_TieredElectricBill {

    // 根據分級費率計算電費（傳入用電度數 kWh）
    public static double calc(int kWh) {
        double bill = 0;

        if (kWh > 1000) {
            bill += (kWh - 1000) * 8.46;
            kWh = 1000;
        }
        if (kWh > 700) {
            bill += (kWh - 700) * 6.24;
            kWh = 700;
        }
        if (kWh > 500) {
            bill += (kWh - 500) * 5.04;
            kWh = 500;
        }
        if (kWh > 330) {
            bill += (kWh - 330) * 3.70;
            kWh = 330;
        }
        if (kWh > 120) {
            bill += (kWh - 120) * 2.45;
            kWh = 120;
        }
        if (kWh >= 0) {
            bill += kWh * 1.68;
        }

        return bill;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] usage = new int[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            usage[i] = Integer.parseInt(sc.nextLine());
            double bill = calc(usage[i]);
            total += bill;
            System.out.printf("Bill: $%d\n", (int)Math.round(bill));
        }

        System.out.printf("Total: $%d\n", (int)Math.round(total));
        System.out.printf("Average: $%d\n", (int)Math.round(total / n));
    }
}
