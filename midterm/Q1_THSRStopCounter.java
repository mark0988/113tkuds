// 時間複雜度：O(n) — 線性掃描站點陣列一次
// 空間複雜度：O(n) — 儲存站點陣列（最多 12 個站）
import java.util.*;

public class Q1_THSRStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());  
        String[] stations = sc.nextLine().split(" ");
        String[] startEnd = sc.nextLine().split(" ");
        String start = startEnd[0];
        String end = startEnd[1];

        int startIdx = -1;
        int endIdx = -1;

        
        for (int i = 0; i < n; i++) {
            if (stations[i].equals(start)) {
                startIdx = i;
            }
            if (stations[i].equals(end)) {
                endIdx = i;
            }
        }

        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            System.out.println(Math.abs(startIdx - endIdx) + 1);
        }
    }
}

