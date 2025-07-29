import java.util.Scanner;

public class F06_ArraySecondLargest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
       
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
       
        Pair result = findSecondLargest(arr, 0, n - 1);
        
        
        System.out.println("SecondMax: " + result.second);
        
        scanner.close();
    }
    
   
    private static Pair findSecondLargest(int[] arr, int left, int right) {
        
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }
        
       
        int mid = (left + right) / 2;
        Pair leftResult = findSecondLargest(arr, left, mid);
        Pair rightResult = findSecondLargest(arr, mid + 1, right);
        
        
        return merge(leftResult, rightResult);
    }
    
    
    private static Pair merge(Pair left, Pair right) {
        int max, second;
        
        
        if (left.max > right.max) {
            max = left.max;
            
            second = Math.max(left.second, right.max);
        } else {
            max = right.max;
            
            second = Math.max(right.second, left.max);
        }
        
        return new Pair(max, second);
    }
    
    
    static class Pair {
        int max, second;
        
        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }
}
// 計算複雜度分析：
// 1. 遞迴深度：我們每次都將陣列分成兩半，這樣每次遞迴深度是 log(n)，其中 n 是陣列的大小。
// 2. 每次遞迴進行的操作：每次遞迴會進行常數時間的比較和合併，因此每層遞迴的操作時間是 O(1)。
// 3. 總時間複雜度：每層遞迴需要做常數時間的操作，遞迴深度是 log(n)，因此總時間複雜度是 O(n)。
//    - 每次分解陣列後，都需要進行常數時間的合併，合併的次數與陣列長度成正比，因此總時間複雜度是 O(n)。
// 4. 空間複雜度：由於遞迴深度為 log(n)，所以空間複雜度為 O(log n)。
// 
// 因此，該算法的時間複雜度是 O(n)，空間複雜度是 O(log n)。
