/*
Problem: 560. Subarray Sum Equals K

Description:
Given an integer array nums and an integer k,
return the total number of continuous subarrays whose sum equals k.

Approach:
- Prefix Sum + HashMap
- Keep running sum (prefix)
- Check how many times (prefix - k) has appeared before

Time Complexity:
- O(n)

Space Complexity:
- O(n)
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {

        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        for (int num : nums) {

            sum += num;

            // check if (sum - k) was seen before
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // store current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}