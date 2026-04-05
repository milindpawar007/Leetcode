/*
LeetCode: 424. Longest Repeating Character Replacement

Approach:
- Sliding Window with frequency array
- Track the most frequent character in the window (maxfreq)

Key Idea:
- We can replace at most k characters
- So window is valid if:
    window size - maxfreq <= k

Steps:
1. Expand window using right pointer
2. Update frequency of current character
3. Track max frequency in window
4. If window is invalid:
   - Shrink from left
5. Track maximum valid window size

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int maxfreq = 0;
        int maxwindow = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);

            int window = right - left + 1;

            if (window - maxfreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            window = right - left + 1;
            maxwindow = Math.max(maxwindow, window);
        }

        return maxwindow;
    }
}