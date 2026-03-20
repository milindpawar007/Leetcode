/*
Problem: 205. Isomorphic Strings (LeetCode)

Description:
Two strings s and t are isomorphic if the characters in s can be replaced 
to get t.

All occurrences of a character must be replaced with another character 
while preserving the order of characters.

No two characters may map to the same character, but a character may map to itself.

Example:
Input: s = "egg", t = "add" → Output: true
Input: s = "foo", t = "bar" → Output: false
Input: s = "paper", t = "title" → Output: true

--------------------------------------------------

Approach (Your Logic):
1. If lengths are different → return false
2. Use two maps:
   - wordassign → maps character from s → t
   - assign → tracks if a character in t is already used
3. Traverse both strings:
   - If character not mapped:
       → check if target char already used
       → if yes → return false
       → else assign mapping
   - If already mapped:
       → verify mapping is consistent
4. If all checks pass → return true

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Step 1: Length check
        if (s.length() != t.length()) {
            return false;
        }

        // Map to store mapping from s → t
        Map<Character, Character> wordassign = new HashMap<>();

        // Map to track if a character in t is already assigned
        Map<Character, Boolean> assign = new HashMap<>();

        // Step 2: Traverse both strings
        for (int i = 0; i < s.length(); i++) {
            char first = s.charAt(i); // char from s
            char second = t.charAt(i); // char from t

            // Case 1: If current char from s is not mapped yet
            if (!wordassign.containsKey(first)) {

                // Check if target char is already used
                if (assign.containsKey(second) && assign.get(second) == true) {
                    return false; // already mapped to another char
                }

                // Create mapping
                wordassign.put(first, second);
                assign.put(second, true);

            } else {
                // Case 2: If already mapped → check consistency
                if (wordassign.get(first) != second) {
                    return false;
                }
            }
        }

        // If all checks pass → strings are isomorphic
        return true;
    }
}