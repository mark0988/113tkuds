import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 站數
        String[] stations = new String[n];
        
        
        for (int i = 0; i < n; i++) {
            stations[i] = scanner.next();
        }
        
        
        String start = scanner.next();
        String end = scanner.next();
        
        
        int startIdx = -1, endIdx = -1;
        
        
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) startIdx = i;
            if (stations[i].equals(end)) endIdx = i;
        }
        
        
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            
            int stopCount = Math.abs(startIdx - endIdx) + 1;
            System.out.println(stopCount);
        }
        
        scanner.close();
    }
}
// 計算複雜度分析：
// 1. 讀取輸入車站代碼的過程是 O(n)，因為我們需要讀取 n 個車站代碼。
// 2. 查找起站和終站索引的過程是 O(n)，因為我們要遍歷整個車站列表一次。
// 3. 計算停靠站數（即計算兩者索引的差距並加 1）是 O(1)。
// 因此，整個程式的時間複雜度為 O(n)，其中 n 是捷運的站數。
// 空間複雜度是 O(n)，因為我們需要存儲車站代碼序列。
