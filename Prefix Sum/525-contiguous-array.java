/*
Problem: 525. Contiguous Array (Medium)

Given a binary array nums, return the maximum length of a contiguous subarray 
with equal number of 0 and 1.

----------------------------------------------------
Brute Force Approach (O(n^2)):

- Try all subarrays
- Count number of 0s and 1s
- If equal → update max length

----------------------------------------------------
Optimal Approach (Prefix Sum + HashMap) (O(n)):

Core Idea:
- Convert:
    0 → -1
    1 → +1

- Then problem becomes:
    Find longest subarray with sum = 0

Why?
- Equal 0 and 1 → (-1 + 1 cancel out → sum = 0)

Steps:
1. Maintain prefix sum
2. If same prefix seen before:
       subarray between them has sum = 0
3. Store first occurrence of prefix in map

Important:
- map.put(0, -1)
  → handles subarray starting from index 0

----------------------------------------------------
Example:
nums = [0,1,0]

Converted:
[-1, +1, -1]

Prefix:
index:   -1   0   1   2
prefix:   0  -1   0  -1

Longest length = 2

----------------------------------------------------
*/

import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {

        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Base case: prefix 0 at index -1
        map.put(0, -1);

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 -> -1, 1 -> +1
            prefix += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(prefix)) {
                result = Math.max(result, i - map.get(prefix));
            } else {
                // store first occurrence
                map.put(prefix, i);
            }
        }

        return result;
    }
}