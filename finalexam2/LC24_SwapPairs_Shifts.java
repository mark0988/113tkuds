import java.util.*;

public class LC24_SwapPairs_Shifts {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
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

        ListNode swapped = swapPairs(dummy.next);
        printList(swapped);
    }

    
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode a = prev.next;
            ListNode b = a.next;

            
            prev.next = b;
            a.next = b.next;
            b.next = a;

            
            prev = a;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        if (sb.length() > 0) sb.setLength(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
