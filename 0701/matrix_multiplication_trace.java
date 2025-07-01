public class matrix_multiplication_trace {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        
        int[][] c = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    System.out.print("計算位置 c[" + i + "][" + j + "]：" + a[i][k] + "*" + b[k][j]);
                    if (k < 1) {
                        System.out.print(" + ");
                    }
                    System.out.println(" = " + a[i][k] * b[k][j]);
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("\n結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//此算法的時間複雜度為 O(n³)，因為有三層迴圈：
//第一層迴圈遍歷矩陣 a 的行（n次）。
//第二層迴圈遍歷矩陣 b 的列（n次）。
//第三層迴圈遍歷行列點乘的元素（n次）。
//總操作次數是 n * n * n，因此時間複雜度是 O(n³)。