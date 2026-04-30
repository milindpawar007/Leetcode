
class Solution {

    /**
     * Problem:
     * Remove duplicate letters such that every letter appears once
     * and the result is the smallest in lexicographical order.
     *
     * Approach:
     * 1. Store last occurrence index of each character.
     * 2. Use a greedy + stack-like approach (StringBuilder).
     * 3. Maintain a visited (taken) array to avoid duplicates.
     * 4. While current char is smaller than last char in result
     * AND last char appears later again → remove it.
     */

    public String removeDuplicateLetters(String s) {

        StringBuilder result = new StringBuilder();

        // Step 1: Store last occurrence of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Track if character already in result
        boolean[] taken = new boolean[26];

        // Step 3: Iterate through string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If already used, skip
            if (taken[ch - 'a']) {
                continue;
            }

            // Step 4: Maintain lexicographical order
            while (result.length() > 0 &&
                    result.charAt(result.length() - 1) > ch &&
                    lastIndex[result.charAt(result.length() - 1) - 'a'] > i) {

                // Remove last char and mark as not taken
                taken[result.charAt(result.length() - 1) - 'a'] = false;
                result.deleteCharAt(result.length() - 1);
            }

            // Add current character
            result.append(ch);
            taken[ch - 'a'] = true;
        }

        return result.toString();
    }
}