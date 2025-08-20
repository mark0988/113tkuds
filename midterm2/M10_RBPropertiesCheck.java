import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node {
        int val;
        char color; // 'B' or 'R'
        Node left, right;
        Node(int v, char c) { val = v; color = c; }
    }

    static final int INVALID = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        if (n == 0) {
            System.out.println("RB Valid");
            return;
        }

        String[] inputs = sc.nextLine().split(" ");
        Node[] nodes = new Node[n];

       
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(inputs[2*i]);
            char c = inputs[2*i+1].charAt(0);
            if (val == -1) {
                
                nodes[i] = null;
            } else {
                nodes[i] = new Node(val, c);
            }
        }

        
        for (int i = 0; i < n; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2*i + 1;
                int rightIdx = 2*i + 2;
                if (leftIdx < n) nodes[i].left = nodes[leftIdx];
                if (rightIdx < n) nodes[i].right = nodes[rightIdx];
            }
        }

        Node root = nodes[0];

        
        if (root != null && root.color != 'B') {
            System.out.println("RootNotBlack");
            return;
        }

        
        int blackHeight = checkRB(root);
        if (blackHeight == INVALID) return;

        System.out.println("RB Valid");
    }

    
    private static int checkRB(Node node) {
        if (node == null) {
            
            return 1;
        }

        
        if (node.color == 'R') {
            if ((node.left != null && node.left.color == 'R') ||
                (node.right != null && node.right.color == 'R')) {
               
                System.out.println("RedRedViolation");
                
                return INVALID;
            }
        }

        int leftBH = checkRB(node.left);
        if (leftBH == INVALID) return INVALID;

        int rightBH = checkRB(node.right);
        if (rightBH == INVALID) return INVALID;

        
        if (leftBH != rightBH) {
            System.out.println("BlackHeightMismatch");
            return INVALID;
        }

        
        return leftBH + (node.color == 'B' ? 1 : 0);
    }
}
