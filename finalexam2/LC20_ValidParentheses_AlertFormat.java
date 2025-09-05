import java.util.*;

public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        System.out.println(isValidFormat(s));
    }

    public static boolean isValidFormat(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsValue(c)) {
                
                stack.push(c);
            } else if (map.containsKey(c)) {
                
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false; 
                }
            } else {
                
                return false;
            }
        }

        return stack.isEmpty(); 
    }
}
