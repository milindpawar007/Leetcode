class Solution {

    /**
     * Problem:
     * Given a string s containing '*' characters,
     * remove each '*' and the closest non-star character to its left.
     *
     * Example:
     * Input: "leet**cod*e"
     * Output: "lecoe"
     *
     * Approach:
     * - Use StringBuilder as a stack.
     * - Traverse each character:
     * • If normal character → append (push)
     * • If '*' → remove last character (pop)
     *
     * Why this works:
     * - '*' behaves exactly like a backspace operation.
     * - Stack helps track previous characters efficiently.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public String removeStars(String s) {

        // Acts as a stack
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {
                // Pop last character (backspace effect)
                sb.deleteCharAt(sb.length() - 1);
            } else {
                // Push character
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}