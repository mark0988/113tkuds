import java.util.*;

public class M06_PalindromeClean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String raw = sc.nextLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < raw.length(); i++) {
            char c = raw.charAt(i);
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        String cleaned = sb.toString(); // O(n)

       
        boolean isPalindrome = checkPalindrome(cleaned);

        System.out.println(isPalindrome ? "Yes" : "No"); // O(1)
    }

    
    private static boolean checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
