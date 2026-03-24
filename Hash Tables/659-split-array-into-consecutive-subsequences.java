
/**
 * LeetCode 659 - Split Array into Consecutive Subsequences
 *
 * Problem:
 * Given a sorted array nums, determine if it is possible to split it into
 * one or more subsequences such that:
 * 1. Each subsequence is consecutive
 * 2. Each subsequence has length >= 3
 *
 * Approach (Greedy + HashMap):
 * - freq map: stores remaining count of each number
 * - tail map: stores how many subsequences are waiting for a number
 *
 * For each number:
 * 1. If already used → skip
 * 2. If a sequence is waiting → extend it
 * 3. Else try to create new sequence (num, num+1, num+2)
 * 4. Else → return false
 *
 * Time: O(n)
 * Space: O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean isPossible(int[] nums) {

        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> tail = new HashMap<>();

        // Step 1: Build frequency map
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Process each number
        for (int num : nums) {

            // Skip if already used
            if (freq.get(num) == 0) {
                continue;
            }

            // Case 1: Extend existing sequence
            if (tail.getOrDefault(num, 0) > 0) {
                freq.put(num, freq.get(num) - 1);
                tail.put(num, tail.get(num) - 1);
                tail.put(num + 1, tail.getOrDefault(num + 1, 0) + 1);
            }

            // Case 2: Create new sequence
            else if (freq.getOrDefault(num + 1, 0) > 0 &&
                    freq.getOrDefault(num + 2, 0) > 0) {

                freq.put(num, freq.get(num) - 1);
                freq.put(num + 1, freq.get(num + 1) - 1);
                freq.put(num + 2, freq.get(num + 2) - 1);

                tail.put(num + 3, tail.getOrDefault(num + 3, 0) + 1);
            }

            // Case 3: Not possible
            else {
                return false;
            }
        }

        return true;
    }
}