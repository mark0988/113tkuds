// 時間複雜度：O(n) — 建立 prefix sum 陣列一次
// 空間複雜度：O(n) — 存 prefix sum 陣列及輸入結果
import java.util.*;

public class Q5_CPBLPrefixWins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] results = new int[n];
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            results[i] = Integer.parseInt(tokens[i]);
        }
        int k = Integer.parseInt(sc.nextLine());

        
        int[] ps = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ps[i] = ps[i - 1] + results[i - 1];
        }

        
        System.out.print("PrefixSum:");
        for (int i = 1; i <= k; i++) {
            System.out.print(" " + ps[i]);
        }
        System.out.println();
    }
}
