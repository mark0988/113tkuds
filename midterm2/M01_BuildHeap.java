import java.util.*;

public class M01_BuildHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String type = sc.next();
        int n = sc.nextInt();
        int[] heap = new int[n];

        
        for (int i = 0; i < n; i++) {
            heap[i] = sc.nextInt();
        }

        
        buildHeap(heap, type.equals("max"));

        
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i]);
            if (i < n - 1) System.out.print(" ");
        }
    }

   
    private static void buildHeap(int[] heap, boolean isMaxHeap) {
        int n = heap.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDown(heap, n, i, isMaxHeap); 
        }
    }

    
    private static void heapifyDown(int[] heap, int n, int i, boolean isMaxHeap) {
        int largestOrSmallest = i;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int target = i;

            
            if (left < n && compare(heap[left], heap[target], isMaxHeap)) {
                target = left;
            }
            if (right < n && compare(heap[right], heap[target], isMaxHeap)) {
                target = right;
            }

            
            if (target != i) {
                swap(heap, i, target);
                i = target; 
            } else {
                break; 
            }
        }
    }

    
    private static boolean compare(int child, int parent, boolean isMaxHeap) {
        return isMaxHeap ? child > parent : child < parent;
    }

    
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
// 輸入讀取：O(n)
for (int i = 0; i < n; i++) {
    heap[i] = sc.nextInt();
}
for (int i = n / 2 - 1; i >= 0; i--) {
    heapifyDown(heap, n, i, isMaxHeap);
}
while (true) {
    ...
    if (target != i) {
        swap(heap, i, target);
        i = target; // 繼續往下調整
    } else {
        break;
    }
}
for (int i = 0; i < n; i++) {
    System.out.print(heap[i]);
    ...
}
