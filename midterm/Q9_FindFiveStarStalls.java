import java.util.*;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] tokens = sc.nextLine().split(" ");
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(tokens[i]);
        }

        
        int count = 0;
        for (int score : scores) {
            if (score == 5) count++;
        }

        if (count == 0) {
            System.out.println("None");
            return;
        }

        
        int[] indices = new int[count];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                indices[idx++] = i;
            }
        }

        
        for (int i = 0; i < count; i++) {
            System.out.print(indices[i]);
            if (i < count - 1) System.out.print(" ");
        }
        System.out.println();
    }
}
