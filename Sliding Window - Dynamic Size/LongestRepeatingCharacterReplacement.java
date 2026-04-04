import java.util.*;

/*
============================================================
LeetCode 424: Longest Repeating Character Replacement
============================================================

Given a string s and an integer k, you can replace at most k 
characters in the string.

Return the length of the longest substring containing the 
same letter after performing at most k replacements.

------------------------------------------------------------
Example 1:
Input: s = "ABAB", k = 2
Output: 4

Example 2:
Input: s = "AABABBA", k = 1
Output: 4

------------------------------------------------------------
Core Idea (Sliding Window):

We maintain a window where:
(window size - max frequency character) <= k

Why?
- maxfreq = count of most frequent char in window
- rest characters = window - maxfreq
- those are the ones we need to replace

If replacements needed > k → shrink window

------------------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1) (26 characters)

============================================================
*/

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int[] freq = new int[26]; // Frequency of characters
        int left = 0;
        int maxfreq = 0; // Most frequent char in window
        int maxwindow = 0; // Result

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            freq[s.charAt(right) - 'A']++;

            // Update max frequency in window
            maxfreq = Math.max(maxfreq, freq[s.charAt(right) - 'A']);

            int window = right - left + 1;

            // If replacements needed > k → shrink window
            if (window - maxfreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Update max window size
            window = right - left + 1;
            maxwindow = Math.max(maxwindow, window);
        }

        return maxwindow;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement obj = new LongestRepeatingCharacterReplacement();

        System.out.println(obj.characterReplacement("ABAB", 2)); // 4
        System.out.println(obj.characterReplacement("AABABBA", 1)); // 4
    }
}