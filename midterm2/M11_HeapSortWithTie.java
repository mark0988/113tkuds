import java.util.*;

public class M11_HeapSortWithTie {
    static class Student implements Comparable<Student> {
        int score, index;
        Student(int s, int i) { score = s; index = i; }

        // 比較規則：分數高優先；分數同則 index 小優先
        public int compareTo(Student o) {
            if (this.score != o.score) return this.score - o.score; // 小到大排序，heap用Max-heap故稍後反轉
            return o.index - this.index;  // 索引小優先，MaxHeap時取反
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Student[] arr = new Student[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            arr[i] = new Student(s, i);
        }

        heapSort(arr);

        // 輸出分數遞增序
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i].score);
            if (i < n - 1) System.out.print(" ");
        }
    }

    static void heapSort(Student[] arr) {
        int n = arr.length;

        // 建 Max-Heap，自底向上調整
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 依序將最大元素交換到尾端，並調整 Heap
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    // Max-Heapify，維護 heap 性質
    static void heapify(Student[] arr, int size, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < size && compare(arr[left], arr[largest]) > 0) largest = left;
        if (right < size && compare(arr[right], arr[largest]) > 0) largest = right;

        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, size, largest);
        }
    }

    // 自訂比較：依分數高低，分數相同 index 小者優先
    // Max-Heap用此函數判斷是否左子節點更大
    static int compare(Student a, Student b) {
        if (a.score != b.score) return a.score - b.score;
        return b.index - a.index; // index 小優先，反轉寫法
    }

    static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
