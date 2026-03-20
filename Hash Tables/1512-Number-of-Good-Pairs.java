/*
Problem: 1512. Number of Good Pairs (LeetCode)

Description:
Given an array of integers nums, return the number of good pairs.

A pair (i, j) is called good if:
- nums[i] == nums[j]
- i < j

Example:
Input: nums = [1,2,3,1,1,3]
Output: 4

--------------------------------------------------

Approach (Your Logic):
1. Use a HashMap to store frequency of each number.
2. Traverse the array:
   - If number already exists in map:
       → It has appeared before
       → Each previous occurrence forms a pair with current
       → So add map.get(num) to count
       → Then increment frequency
   - If not exists:
       → Add it with frequency 1
3. Return total count

Key Insight:
If a number appears k times, it contributes:
kC2 = k*(k-1)/2 pairs
But here we calculate it on-the-fly.

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

import java.util.Map;
import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {

        int count = 0;

        // Map to store frequency of numbers
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            // If number already seen before
            if (map.containsKey(num)) {

                // Add previous occurrences to count
                count = count + map.get(num);

                // Increase frequency
                map.put(num, map.get(num) + 1);

            } else {
                // First occurrence
                map.put(num, 1);
            }
        }

        return count;
    }
}