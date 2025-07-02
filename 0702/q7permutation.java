import java.util.Scanner;

public class q7permutation {
    static int n, ops = 0;
    static boolean[] used;
    static int[] perm;

    static void dfs(int d) {
        if (d == n) {
            for (int i = 0; i < n; i++)
                System.out.print(perm[i] + (i < n - 1 ? " " : ""));
            System.out.println();
            ops++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[d] = i;
                dfs(d + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        used = new boolean[n + 1];
        perm = new int[n];
        dfs(0);
        System.out.println(ops);
        sc.close();
    }
}