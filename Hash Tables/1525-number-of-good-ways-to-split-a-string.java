/*
LeetCode Problem: 1525. Number of Good Ways to Split a String
Difficulty: Medium

Approach:
We use prefix and postfix arrays to store the count of distinct characters.

1. Traverse from left → build prefix array
   prefix[i] = number of unique characters from 0 to i

2. Traverse from right → build postfix array
   postfix[i] = number of unique characters from i to end

3. For each split index i:
   Compare prefix[i] and postfix[i+1]
   If equal → valid split

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class Solution {
    public int numSplits(String s) {

        int count = 0;
        int n = s.length();

        int[] prefix = new int[n];
        int[] postfix = new int[n];

        Set<Character> pre = new HashSet<>();
        Set<Character> pos = new HashSet<>();

        // Build prefix and postfix arrays
        for (int i = 0; i < n; i++) {
            pre.add(s.charAt(i));
            prefix[i] = pre.size();

            pos.add(s.charAt(n - i - 1));
            postfix[n - i - 1] = pos.size();
        }

        // Count valid splits
        for (int i = 0; i < n - 1; i++) {
            if (prefix[i] == postfix[i + 1]) {
                count++;
            }
        }

        return count;
    }
}