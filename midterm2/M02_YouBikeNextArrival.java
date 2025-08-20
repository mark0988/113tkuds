import java.util.*;

public class M02_YouBikeNextArrival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        
        String[] timeStrs = new String[n];
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            timeStrs[i] = sc.nextLine().trim();
            times[i] = toMinutes(timeStrs[i]); 
        }

        String queryStr = sc.nextLine().trim();
        int query = toMinutes(queryStr);

        
        int idx = binarySearchFirstGreater(times, query);

        if (idx == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(timeStrs[idx]);
        }
    }

   
    private static int toMinutes(String time) {
        String[] parts = time.split(":");
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return hh * 60 + mm;
    }

    
    private static int binarySearchFirstGreater(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > target) {
                result = mid;       
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
