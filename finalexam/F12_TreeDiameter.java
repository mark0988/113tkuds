import java.util.Scanner;


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class F12_TreeDiameter {

    
    private static int maxDiameter = 0;

    
    private static int treeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        
        int leftHeight = treeHeight(root.left);
        
        int rightHeight = treeHeight(root.right);

        
        int diameterAtNode = leftHeight + rightHeight;

        
        maxDiameter = Math.max(maxDiameter, diameterAtNode);

        
        return Math.max(leftHeight, rightHeight) + 1;
    }

    
    private static TreeNode buildTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertNode(root, nums[i]);
        }
        return root;
    }

    
    private static void insertNode(TreeNode root, int val) {
        if (root == null) return;

        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertNode(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertNode(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        
        TreeNode root = buildTree(nums);

        
        treeHeight(root);

       
        System.out.println("Tree Diameter: " + maxDiameter);

        scanner.close();
    }
}
