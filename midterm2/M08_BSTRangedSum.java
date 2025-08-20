import java.util.*;

public class M08_BSTRangedSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            System.out.println("Sum: 0");
            return;
        }

        String[] values = sc.nextLine().split(" ");
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(values[i]);
            if (v != -1) nodes[i] = new TreeNode(v);
        }

        ）
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                if (leftIdx < n) nodes[i].left = nodes[leftIdx];
                if (rightIdx < n) nodes[i].right = nodes[rightIdx];
            }
        }

        TreeNode root = nodes[0];

        
        String[] range = sc.nextLine().split(" ");
        int L = Integer.parseInt(range[0]);
        int R = Integer.parseInt(range[1]);

        int sum = rangeSumBST(root, L, R);
        System.out.println("Sum: " + sum);
    }

    
    private static int rangeSumBST(TreeNode node, int L, int R) {
        if (node == null) return 0;

        if (node.val < L) {
            
            return rangeSumBST(node.right, L, R);
        } else if (node.val > R) {
            
            return rangeSumBST(node.left, L, R);
        } else {
            
            return node.val + rangeSumBST(node.left, L, R) + rangeSumBST(node.right, L, R);
        }
    }
}
