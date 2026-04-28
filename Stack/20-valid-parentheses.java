import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        // Edge cases
        if (s == null || s.length() <= 1) {
            return false;
        }

        Stack<Character> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(')');
            } else if (ch == '{') {
                st.push('}');
            } else if (ch == '[') {
                st.push(']');
            } else {
                if (st.isEmpty() || ch != st.pop()) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    // Optional main for testing
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}")); // true
        System.out.println(isValid("(]")); // false
    }
}