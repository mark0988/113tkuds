import java.util.Scanner;


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class F10_BSTRangeSum {

    
    private static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        
        int sum = 0;

        
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }

        
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        }

       
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        }

        return sum;
    }

    
    private static TreeNode buildBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            insertBST(root, nums[i]);
        }
        return root;
    }

    
    private static void insertBST(TreeNode root, int val) {
        if (root == null) return;

        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertBST(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertBST(root.right, val);
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
        
        
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        
        
        TreeNode root = buildBST(nums);
        
       
        int result = rangeSumBST(root, L, R);
        
        
        System.out.println("Range Sum: " + result);
        
        scanner.close();
    }
}
