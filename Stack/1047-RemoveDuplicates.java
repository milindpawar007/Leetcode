import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        Stack<Character> stack = new Stack<>();
        String result = "";

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }

        return result;
    }
}