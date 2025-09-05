import java.util.*;

public class LC19_RemoveNth_Node_Clinic {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }
        int k = sc.nextInt();
        sc.close();

        ListNode newHead = removeNthFromEnd(dummy.next, k);
        printList(newHead);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        
        slow.next = slow.next.next;

        return dummy.next;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" ");
            head = head.next;
        }
    }
}
