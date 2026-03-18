/**
 * LeetCode 1189 - Maximum Number of Balloons
 *
 * APPROACH (Your HashMap Approach)
 * ------------------------------------------------------------
 *
 * Idea:
 * Instead of counting all characters, only focus on:
 *   'b', 'a', 'l', 'o', 'n'
 *
 * Step 1: Count frequency using HashMap
 * --------------------------------------
 * Traverse the string and store only required characters.
 *
 * Example:
 * text = "loonbalxballpoon"
 *
 * Map after loop:
 *   b = 2
 *   a = 2
 *   l = 4
 *   o = 4
 *   n = 2
 *
 * ------------------------------------------------------------
 *
 * Step 2: Split into two groups
 *
 * 1. Single occurrence characters (appear once in "balloon"):
 *    b, a, n
 *
 *    These directly represent how many balloons they can support:
 *
 *    singlechar = min(b, a, n)
 *
 * ------------------------------------------------------------
 *
 * 2. Double occurrence characters (appear twice in "balloon"):
 *    l, o
 *
 *    We first take minimum of both:
 *      doublechar = min(l, o)
 *
 *    Since each balloon needs 2 of them:
 *      usable = doublechar / 2
 *
 * ------------------------------------------------------------
 *
 * Step 3: Final Answer
 *
 *    return min(singlechar, doublechar / 2)
 *
 * Reason:
 * The smallest value is the limiting factor.
 *
 * ------------------------------------------------------------
 *
 * Example Walkthrough:
 *
 * text = "ballooon"
 *
 * counts:
 *   b = 1, a = 1, l = 2, o = 3, n = 1
 *
 * singlechar = min(1,1,1) = 1
 * doublechar = min(2,3) = 2
 *
 * result = min(1, 2/2) = min(1,1) = 1
 *
 * ------------------------------------------------------------
 *
 * TIME COMPLEXITY:
 *   O(n)
 *
 * SPACE COMPLEXITY:
 *   O(1) → only 5 characters stored
 *
 * ------------------------------------------------------------
 *
 * KEY IDEA:
 *   Count → Split → Divide (for l, o) → Take minimum
 *
 * ------------------------------------------------------------
 */

import java.util.*;

class Solution {
    public int maxNumberOfBalloons(String text) {
       
        Map<Character, Integer> result = new HashMap<>();

        // Count only relevant characters
        for (char ch : text.toCharArray()) {
            if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
                result.put(ch, result.getOrDefault(ch, 0) + 1);
            }
        }

        // Single occurrence characters
        int singlechar = Math.min(
            result.getOrDefault('b', 0),
            Math.min(result.getOrDefault('a', 0),
                     result.getOrDefault('n', 0))
        );

        // Double occurrence characters
        int doublechar = Math.min(
            result.getOrDefault('l', 0),
            result.getOrDefault('o', 0)
        );

        // Final result
        return Math.min(singlechar, doublechar / 2);
    }
}