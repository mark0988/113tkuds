import java.util.*;

public class M09_AVLValidate {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static final int INVALID = Integer.MIN_VALUE; // 特別值，表示不合法高度

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            System.out.println("Valid");
            return;
        }

        String[] values = sc.nextLine().split(" ");
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(values[i]);
            if (v != -1) nodes[i] = new TreeNode(v);
        }

        // 建樹（同前題）
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                if (leftIdx < n) nodes[i].left = nodes[leftIdx];
                if (rightIdx < n) nodes[i].right = nodes[rightIdx];
            }
        }

        TreeNode root = nodes[0];
        if (!isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            System.out.println("Invalid BST");
            return;
        }

        if (checkAVL(root) == INVALID) {
            System.out.println("Invalid AVL");
            return;
        }

        System.out.println("Valid");
    }

    // 遞迴判斷是否 BST（帶上下界）
    private static boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    // 後序遞迴，回傳子樹高度，若不平衡或子樹不合法回 INVALID
    private static int checkAVL(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkAVL(node.left);
        if (leftHeight == INVALID) return INVALID;

        int rightHeight = checkAVL(node.right);
        if (rightHeight == INVALID) return INVALID;

        if (Math.abs(leftHeight - rightHeight) > 1) return INVALID;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
