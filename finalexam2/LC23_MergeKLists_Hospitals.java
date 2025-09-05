import java.util.*;

public class LC23_MergeKLists_Hospitals {

    static class Node implements Comparable<Node> {
        int val;
        int listIndex;  
        int idx;        

        Node(int v, int l, int i) {
            val = v;
            listIndex = l;
            idx = i;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.val, other.val);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            List<Integer> curList = new ArrayList<>();
            while (true) {
                int val = sc.nextInt();
                if (val == -1) break;
                curList.add(val);
            }
            lists.add(curList);
        }
        sc.close();

        PriorityQueue<Node> pq = new PriorityQueue<>();

        
        for (int i = 0; i < k; i++) {
            if (!lists.get(i).isEmpty()) {
                pq.offer(new Node(lists.get(i).get(0), i, 0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            sb.append(cur.val).append(" ");

            int nextIdx = cur.idx + 1;
            if (nextIdx < lists.get(cur.listIndex).size()) {
                pq.offer(new Node(lists.get(cur.listIndex).get(nextIdx), cur.listIndex, nextIdx));
            }
        }

        
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
