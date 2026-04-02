/*
Problem: Permutation in String (LeetCode 567)

Approach:
Sliding Window + Frequency Array

- Build frequency array for s1
- Build frequency array for first window of s2 (size = s1.length)
- Compare both arrays
- Slide window:
    - remove left char
    - add right char
    - compare again

Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.*;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        // Edge case
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1array = new int[26];
        int[] s2array = new int[26];

        // Build frequency arrays
        for (int i = 0; i < s1.length(); i++) {
            s1array[s1.charAt(i) - 'a']++;
            s2array[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (Arrays.equals(s1array, s2array)) {
            return true;
        }

        // Sliding window
        for (int i = 1; i <= s2.length() - s1.length(); i++) {

            // Remove left char
            s2array[s2.charAt(i - 1) - 'a']--;

            // Add new right char
            s2array[s2.charAt(i + s1.length() - 1) - 'a']++;

            // Compare
            if (Arrays.equals(s1array, s2array)) {
                return true;
            }
        }

        return false;
    }
}