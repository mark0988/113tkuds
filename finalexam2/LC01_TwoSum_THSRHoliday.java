import java.util.*;

public class LC01_TwoSum_THSRHoliday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int target = sc.nextInt();
        
        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> map = new HashMap<>(); 

        for (int i = 0; i < n; i++) {
            int seat = seats[i];

            if (map.containsKey(seat)) {
                System.out.println(map.get(seat) + " " + i);
                return;
            }

            int need = target - seat;
            map.put(need, i);
        }

       
        System.out.println("-1 -1");
    }
}
