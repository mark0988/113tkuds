// 時間複雜度：O(log n) — 使用二分搜尋找班次
// 空間複雜度：O(n) — 儲存所有班次時間
import java.util.*;

public class Q2_NextTHSRDeparture {
    
    public static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());  

        int[] times = new int[n];                 
        String[] originalTimes = new String[n];   

        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            times[i] = toMinutes(t);
            originalTimes[i] = t;
        }

        int query = toMinutes(sc.nextLine());

        
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (times[mid] <= query) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (left == n) {
            System.out.println("No train");
        } else {
            System.out.println(originalTimes[left]);
        }
    }
}

