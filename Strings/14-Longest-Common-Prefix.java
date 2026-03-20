/*
Problem: 14. Longest Common Prefix (LeetCode)

Description:
Write a function to find the longest common prefix string 
among an array of strings.

If there is no common prefix, return an empty string "".

Example:
Input: ["flower","flow","flight"]
Output: "fl"

--------------------------------------------------

Approach (Sorting Trick):

Key Idea:
- Sort the array
- Only compare first and last strings
- Why? They will be the most different
- Common prefix of these two = answer

--------------------------------------------------

Steps:
1. Sort the array
2. Take:
   → first = strs[0]
   → last = strs[n-1]
3. Compare characters one by one
4. Stop at first mismatch
5. Build result string

--------------------------------------------------

Time Complexity: O(n log n + m)
n = number of strings
m = length of shortest string

Space Complexity: O(1) (ignoring sort space)

--------------------------------------------------
*/

import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Step 1: Sort array
        Arrays.sort(strs);

        String result = "";

        // Step 2: Compare first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < first.length(); i++) {

            // If characters match → add to result
            if (first.charAt(i) == last.charAt(i)) {
                result = result + first.charAt(i);
            } else {
                break;
            }
        }

        return result;
    }
}