import java.util.*;

public class F02_YouBikeNextFull {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        scanner.nextLine(); 
        
        
        String[] times = new String[n];
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextLine();
        }
        
        
        String query = scanner.nextLine();
        
        
        int queryMinutes = convertToMinutes(query);
        
        
        int resultIndex = binarySearch(times, queryMinutes);
        
        if (resultIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(times[resultIndex]);
        }
        
        scanner.close();
    }
    
    
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
    
    
    private static int binarySearch(String[] times, int queryMinutes) {
        int left = 0, right = times.length - 1;
        int resultIndex = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midMinutes = convertToMinutes(times[mid]);
            
            if (midMinutes > queryMinutes) {
                resultIndex = mid;
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }
        
        return resultIndex;
    }
}
// 計算複雜度分析：
// 1. 讀取時間表和查詢時間的過程是 O(n)，需要讀取 n 行時間。
// 2. 將查詢時間轉換為分鐘數的過程是 O(1)，因為只需要解析時間字符串。
// 3. 使用二分搜尋來查找第一個大於查詢時間的回補時間，時間複雜度是 O(log n)。
// 因此，整個程式的時間複雜度為 O(n + log n)，其中 n 是回補時間的數量。
// 空間複雜度是 O(n)，因為我們需要存儲時間表。
