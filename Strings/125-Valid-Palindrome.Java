/*
Problem: 125. Valid Palindrome (LeetCode)

Description:
Given a string s, determine if it is a palindrome, considering only 
alphanumeric characters and ignoring cases.

Example:
Input: s = "A man, a plan, a canal: Panama"
Output: true

Input: s = "race a car"
Output: false

--------------------------------------------------

Approach (Two Pointer + Filtering):

Key Idea:
- Ignore non-alphanumeric characters
- Compare characters from both ends
- Convert to lowercase for case-insensitive comparison

--------------------------------------------------

Steps:
1. Initialize two pointers:
   → left = 0
   → right = s.length() - 1

2. While left < right:
   → Skip non-alphanumeric characters on left
   → Skip non-alphanumeric characters on right
   → Compare lowercase characters
   → If mismatch → return false
   → Move both pointers inward

3. If all checks pass → return true

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            // Move both pointers
            left++;
            right--;
        }

        return true;
    }
}