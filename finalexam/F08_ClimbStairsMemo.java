import java.util.Scanner;

public class F08_ClimbStairsMemo {

    
    static int[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int n = scanner.nextInt();
        
        
        memo = new int[n + 1];
        
        
        System.out.println("Ways: " + climbStairs(n));
        
        scanner.close();
    }

   
    private static int climbStairs(int n) {
       
        if (n == 0) return 1;  
        if (n == 1) return 1;  
        
        
        if (memo[n] != 0) {
            return memo[n];  
        }
        
        
        memo[n] = climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
        
        return memo[n]; 
    }
}
