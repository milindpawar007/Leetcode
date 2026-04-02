import java.util.*;

/*
========================================================
PROBLEM: Find All Anagrams in a String
========================================================

Given:
- String s (text)
- String p (pattern)

Return:
- All start indices of p's anagrams in s

Example:
s = "cbaebabacd", p = "abc"
Output = [0, 6]

========================================================
APPROACH: Sliding Window + Frequency Array
========================================================

Core Idea:
- Anagrams have SAME frequency of characters
- Use fixed-size arrays (size 26) instead of HashMap
- Maintain a sliding window of size k = p.length()

Steps:

1. Build frequency array for pattern (parray)
2. Build frequency array for first window in s (sarray)
3. Compare arrays → if equal → index 0 is valid
4. Slide window one step at a time:
   - Remove left character
   - Add new right character
5. Compare arrays at each step

========================================================
WINDOW LOGIC (IMPORTANT)
========================================================

For window starting at index i:

Window range:
start = i
end   = i + k - 1   (because k elements)

So:
REMOVE → s[i - 1]
ADD    → s[i + k - 1]

========================================================
WHY "-1" ?
========================================================

Because of formula:
window size = end - start + 1

k = end - i + 1
→ end = i + k - 1

========================================================
TIME COMPLEXITY
========================================================

- Loop runs O(n)
- Array comparison takes O(26) → constant

Total:
O(n)

========================================================
SPACE COMPLEXITY
========================================================

- Two arrays of size 26

O(1)

========================================================
PATTERN RECOGNITION
========================================================

Use this when:
- Fixed window size
- Anagram / permutation problems
- Lowercase letters → use array (faster than map)

========================================================
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        // Edge case
        if (p.length() > s.length()) {
            return result;
        }

        int[] parray = new int[26]; // frequency of pattern
        int[] sarray = new int[26]; // frequency of current window

        // Step 1: Build frequency arrays
        for (int i = 0; i < p.length(); i++) {
            parray[p.charAt(i) - 'a']++;
            sarray[s.charAt(i) - 'a']++;
        }

        // Step 2: Check first window
        if (Arrays.equals(parray, sarray)) {
            result.add(0);
        }

        // Step 3: Slide the window
        for (int i = 1; i <= s.length() - p.length(); i++) {

            // Remove previous left character
            sarray[s.charAt(i - 1) - 'a']--;

            // Add new right character
            sarray[s.charAt(i + p.length() - 1) - 'a']++;

            // Compare arrays
            if (Arrays.equals(parray, sarray)) {
                result.add(i);
            }
        }

        return result;
    }
}