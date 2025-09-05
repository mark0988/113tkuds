import java.util.*;

public class LC25_ReverseKGroup_Shifts {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        sc.nextLine(); 
        String line = sc.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println();
            return;
        }
        String[] parts = line.split("\\s+");

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (String p : parts) {
            curr.next = new ListNode(Integer.parseInt(p));
            curr = curr.next;
        }

        ListNode res = reverseKGroup(dummy.next, k);
        printList(res);
    }

    
    static ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        ListNode curr = start;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;  
    }

    static ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = groupPrev;
            
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }
            if (kth == null) break;  

            ListNode groupNext = kth.next;
            
            ListNode start = groupPrev.next;
            ListNode newHead = reverse(start, groupNext);

            
            groupPrev.next = newHead;
            start.next = groupNext;

            
            groupPrev = start;
        }
        return dummy.next;
    }

    static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
