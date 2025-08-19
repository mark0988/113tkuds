import java.util.*;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        String input = scanner.nextLine();
        
       
        if (canFormPalindrome(input)) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
        
        scanner.close();
    }

    
    private static boolean canFormPalindrome(String input) {
        
        int bitmask = 0;
        
        
        for (char c : input.toLowerCase().toCharArray()) {
           
            if (Character.isLetter(c)) {
                
                bitmask ^= (1 << (c - 'a')); 
            }
        }
        
       
    }
}
