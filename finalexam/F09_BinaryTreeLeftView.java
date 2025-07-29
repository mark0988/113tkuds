import java.util.*;

public class F09_BinaryTreeLeftView {

    
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    
    private static TreeNode buildTree(int[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == -1) return null;
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        queue.offer(root);
        
        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();
            
           
            if (arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            
            
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        
        return root;
    }

    
    private static void leftView(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                
                if (i == 0) {
                    System.out.print(current.val + " ");
                }
                
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 輸入層序序列
        String[] input = scanner.nextLine().split(" ");
        int[] arr = new int[input.length];
        // 將輸入的字串轉換為整數陣列
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        
       
        TreeNode root = buildTree(arr);
        
        
        System.out.print("LeftView: ");
        leftView(root);
        System.out.println();
        
        scanner.close();
    }
}
