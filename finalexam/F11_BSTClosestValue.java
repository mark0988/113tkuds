import java.util.Scanner;


class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}

public class F11_BSTClosestValue {

   
    private static int closestValue(TreeNode root, int target) {
        int closest = root.val; 
        while (root != null) {
            
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            
            if (target < root.val) {
                root = root.left;  
            } else if (target > root.val) {
                root = root.right; 
            } else {
                break; 
            }
        }
        return closest;
    }

    ）
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
        
       
        int target = scanner.nextInt();
        
        
        TreeNode root = buildBST(nums);
        
        
        int result = closestValue(root, target);
        
       
        System.out.println("Closest Value: " + result);
        
        scanner.close();
    }
}
