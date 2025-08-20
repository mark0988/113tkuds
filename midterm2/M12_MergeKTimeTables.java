import java.util.*;

public class M12_MergeKTimeTables {
    static class Entry implements Comparable<Entry> {
        int time, listIdx, elemIdx;
        Entry(int t, int l, int e) {
            time = t; listIdx = l; elemIdx = e;
        }

        public int compareTo(Entry o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int[][] lists = new int[K][];

        for (int i = 0; i < K; i++) {
            int len = sc.nextInt();
            lists[i] = new int[len];
            for (int j = 0; j < len; j++) {
                lists[i][j] = sc.nextInt();
            }
        }

        PriorityQueue<Entry> minHeap = new PriorityQueue<>();

        // 將每個列表第一個元素推入堆中
        for (int i = 0; i < K; i++) {
            if (lists[i].length > 0) {
                minHeap.offer(new Entry(lists[i][0], i, 0));
            }
        }

        List<Integer> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            Entry cur = minHeap.poll();
            merged.add(cur.time);

            int nextIdx = cur.elemIdx + 1;
            if (nextIdx < lists[cur.listIdx].length) {
                minHeap.offer(new Entry(lists[cur.listIdx][nextIdx], cur.listIdx, nextIdx));
            }
        }

        // 輸出合併結果
        for (int i = 0; i < merged.size(); i++) {
            System.out.print(merged.get(i));
            if (i != merged.size() - 1) System.out.print(" ");
        }
    }
}
