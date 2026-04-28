/*
Problem: Minimum Window Substring (LeetCode 76)

Approach:
1. Use sliding window (two pointers)
2. Maintain frequency map for target string (t)
3. Expand window using right pointer
4. When all characters are matched → shrink using left pointer
5. Track minimum window

Optimized Approach (O(n)):
- Instead of checking full map every time, use "formed" count
*/

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0)
            return "";

        int[] map = new int[256];

        // Fill target frequency
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }

        int left = 0;
        int right = 0;
        int count = t.length(); // characters remaining to match

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            // Include current char
            if (map[s.charAt(right)] > 0) {
                count--;
            }

            map[s.charAt(right)]--;
            right++;

            // When all characters matched
            while (count == 0) {

                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Remove left char
                map[s.charAt(left)]++;

                if (map[s.charAt(left)] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}