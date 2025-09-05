import java.util.*;

public class LC04_Median_QuakeFeeds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        double[] A = new double[n];
        double[] B = new double[m];
        for (int i = 0; i < n; i++) A[i] = sc.nextDouble();
        for (int i = 0; i < m; i++) B[i] = sc.nextDouble();
        sc.close();

        
        if (n > m) {
            double[] temp = A; A = B; B = temp;
            int tmp = n; n = m; m = tmp;
        }

        int left = 0, right = n;
        int totalLeft = (n + m + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = totalLeft - i;

            double A_left = (i == 0) ? Double.NEGATIVE_INFINITY : A[i - 1];
            double A_right = (i == n) ? Double.POSITIVE_INFINITY : A[i];
            double B_left = (j == 0) ? Double.NEGATIVE_INFINITY : B[j - 1];
            double B_right = (j == m) ? Double.POSITIVE_INFINITY : B[j];

            if (A_left <= B_right && B_left <= A_right) {
                double maxLeft = Math.max(A_left, B_left);
                double minRight = Math.min(A_right, B_right);
                if ((n + m) % 2 == 1) {
                    System.out.printf("%.1f\n", maxLeft);
                } else {
                    System.out.printf("%.1f\n", (maxLeft + minRight) / 2);
                }
                return;
            } else if (A_left > B_right) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }
}
