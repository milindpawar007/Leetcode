import java.util.*;

/*
 * Problem: Evaluate Reverse Polish Notation
 * LeetCode: 150
 *
 * Description:
 * Evaluate an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators: +, -, *, /
 *
 * Approach:
 * - Use stack
 * - Push numbers
 * - On operator:
 *      pop two elements
 *      apply operation
 *      push result
 *
 * Important:
 * Order matters:
 *   second = pop()
 *   first  = pop()
 *   result = first op second
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b + a);

            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);

            } else if (token.equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);

            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}