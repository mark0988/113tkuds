import java.util.*;

public class M05_GCD_LCM_Recursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // O(1)：讀取輸入
        long a = sc.nextLong();
        long b = sc.nextLong();

        // O(log min(a, b))：計算 GCD
        long gcd = recursiveGCD(a, b);

        // O(1)：先除後乘以避免溢位，計算 LCM
        long lcm = (a / gcd) * b;

        // O(1)：輸出結果
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

    // 遞迴實作歐幾里得演算法 — O(log min(a, b))
    private static long recursiveGCD(long x, long y) {
        if (y == 0) {
            return x;
        }
        return recursiveGCD(y, x % y);
    }
}
