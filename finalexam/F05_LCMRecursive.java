import java.util.Scanner;

public class F05_LCMRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        
        
        int gcd = gcdRecursive(a, b);
        int lcm = (a * b) / gcd;
        
        
        System.out.println("LCM: " + lcm);
        
        scanner.close();
    }
    
    
    private static int gcdRecursive(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            return gcdRecursive(a - b, b);
        } else {
            return gcdRecursive(a, b - a);
        }
    }
}
// 計算複雜度分析：
// 1. 遞迴輾轉相減法計算 GCD：
//    - 在每次遞迴中，兩數的差距會逐漸縮小，最終會達到 GCD。
//    - 每次遞迴的運算時間是常數 O(1)，但遞迴的深度取決於兩數之間的差距。
//    - 在最壞情況下，輾轉相減法的遞迴深度為 O(a)，其中 a 是兩數中較大的數。
//    - 這是因為每次遞迴僅進行一次數字的減法，最壞情況下需要進行最多 a 次遞迴。
//    - 因此，輾轉相減法的時間複雜度為 O(a)，其中 a 是較大的數。
// 
// 2. 計算 LCM：
//    - 計算 LCM 只需要常數時間 O(1)，因為已經有了 GCD，計算 LCM 是簡單的除法。
// 
// 因此，整個程式的時間複雜度為 O(a)，其中 a 是兩數中的較大數。
// 空間複雜度為 O(1)，因為遞迴函數不需要額外的空間來存儲中間結果。
