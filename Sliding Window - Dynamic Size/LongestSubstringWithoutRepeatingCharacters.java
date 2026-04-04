import java.util.HashSet;
import java.util.Set;

/*
============================================================
LeetCode Problem: Longest Substring Without Repeating Characters
============================================================

Given a string s, find the length of the longest substring 
without repeating characters.

------------------------------------------------------------
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with length 3.

Example 2:
Input: s = "bbbbb"
Output: 1

Example 3:
Input: s = "pwwkew"
Output: 3

------------------------------------------------------------
Approach: Sliding Window + HashSet

- Use two pointers (left, right) to maintain a window
- Use HashSet to store unique characters in the window
- If duplicate found:
    → shrink window from left until duplicate removed
- Update max length at each step

Time Complexity: O(n)
Space Complexity: O(n)

============================================================
*/

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        int max = 0; // Stores maximum length
        int left = 0; // Left pointer of window
        Set<Character> set = new HashSet<>(); // Store unique chars

        // Right pointer expands window
        for (int right = 0; right < s.length(); right++) {

            // If duplicate found, shrink window
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++; // Move left forward
            }

            // Add current character
            set.add(s.charAt(right));

            // Update max length
            int windowLength = right - left + 1;
            max = Math.max(max, windowLength);
        }

        return max;
    }

    // Test the solution
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // 3
    }
}