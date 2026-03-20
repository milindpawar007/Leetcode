/*
Problem: 392. Is Subsequence (LeetCode)

Description:
Given two strings s and t, return true if s is a subsequence of t, 
or false otherwise.

A subsequence is formed by deleting some (or no) characters 
without changing the order of the remaining characters.

Example:
Input: s = "abc", t = "ahbgdc"
Output: true

Input: s = "axc", t = "ahbgdc"
Output: false

--------------------------------------------------

Approach (Two Pointer):

Key Idea:
- Use one pointer for s (k)
- Traverse t with another pointer
- If characters match → move pointer of s
- If all characters of s are matched → return true

--------------------------------------------------

Steps:
1. Initialize pointer k = 0 (for s)
2. Traverse string t:
   → If s[k] == t[i], move k++
3. After loop:
   → If k == s.length() → all characters matched
   → else → not a subsequence

--------------------------------------------------

Time Complexity: O(n) where n = length of t
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public boolean isSubsequence(String s, String t) {

        int k = 0; // pointer for string s

        // Traverse string t
        for (int i = 0; i < t.length(); i++) {

            // If characters match → move pointer in s
            if (k < s.length() && s.charAt(k) == t.charAt(i)) {
                k++;
            }
        }

        // If all characters of s are matched
        return k == s.length();
    }
}