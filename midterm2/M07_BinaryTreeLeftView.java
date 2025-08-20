import java.util.*;

public class M07_BinaryTreeLeftView {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            System.out.println("LeftView:");
            return;
        }

        String[] values = sc.nextLine().split(" ");
        
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(values[i]);
            if (v != -1) nodes[i] = new TreeNode(v);
        }

        
        
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                if (leftIdx < n) nodes[i].left = nodes[leftIdx];
                if (rightIdx < n) nodes[i].right = nodes[rightIdx];
            }
        }

        TreeNode root = nodes[0];
        if (root == null) {
            System.out.println("LeftView:");
            return;
        }

        
        List<Integer> leftView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                
                if (i == 0) leftView.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        System.out.print("LeftView:");
        for (int val : leftView) {
            System.out.print(" " + val);
        }
        System.out.println();
    }
}
