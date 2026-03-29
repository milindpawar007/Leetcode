
/**
 * Problem: Continuous Subarray Sum
 * LeetCode: 523
 *
 * Given an integer array nums and an integer k, return true if nums has a continuous
 * subarray of size at least 2 whose elements sum up to a multiple of k.
 *
 * Approach: Prefix Sum + HashMap
 *
 * Key Idea:
 * If two prefix sums have the same remainder when divided by k,
 * then the subarray between them is divisible by k.
 *
 * Important:
 * - Subarray length must be at least 2
 * - Store FIRST occurrence of remainder (do not overwrite)
 * - Handle k == 0 separately
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class CheckSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case

        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int remainder;
            if (k == 0) {
                remainder = prefix;
            } else {
                remainder = prefix % k;
            }

            if (map.containsKey(remainder)) {
                // subarray length must be at least 2
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                // store first occurrence only
                map.put(remainder, i);
            }
        }

        return false;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        CheckSubarraySum obj = new CheckSubarraySum();

        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;

        boolean result = obj.checkSubarraySum(nums, k);
        System.out.println("Result: " + result); // Expected: true
    }
}