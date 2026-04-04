
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 30-SubstringWithConcatenationOfAllWords {
    
}
/*
Problem: Substring with Concatenation of All Words (LeetCode 30)

Approach:
Optimized Sliding Window + Word Frequency Map

Key Idea:
- All words have same length
- Process string in chunks of size wordLen
- Use sliding window to track valid words
- Maintain frequency map for required words (wordcount)
- Maintain frequency map for current window (window)

Steps:
1. Build word frequency map
2. Try all starting offsets (0 to wordLen - 1)
3. Move right pointer in steps of wordLen
4. Extract word and check validity
5. If valid:
    - add to window
    - shrink if frequency exceeds allowed
6. If count matches total words:
    - record index
    - slide left
7. If invalid word:
    - reset window

Time Complexity: O(n)
Space Complexity: O(k)
*/

import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        Map<String, Integer> wordcount = new HashMap<>();
        for (String word : words) {
            wordcount.put(word, wordcount.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> window = new HashMap<>();

            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordcount.containsKey(word)) {
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    while (window.get(word) > wordcount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == wordCount) {
                        result.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}