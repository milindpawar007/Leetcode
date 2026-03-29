
/**
 * Problem: Subarrays Divisible by K
 * LeetCode: 974
 *
 * Given an integer array nums and an integer k, return the number of non-empty subarrays
 * that have a sum divisible by k.
 *
 * Approach: Prefix Sum + HashMap (Optimal)
 *
 * Key Idea:
 * If two prefix sums have the same remainder when divided by k,
 * then the subarray between them is divisible by k.
 *
 * Important:
 * Java % can return negative remainder → normalize it
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int prefix = 0;
        int count = 0;

        for (int num : nums) {
            prefix += num;

            int remainder = prefix % k;

            // normalize negative remainder
            if (remainder < 0) {
                remainder += k;
            }

            // if same remainder seen before → valid subarray
            count += map.getOrDefault(remainder, 0);

            // update frequency
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }

    // Optional: main method for quick testing
    public static void main(String[] args) {
        SubarraysDivisibleByK obj = new SubarraysDivisibleByK();

        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;

        int result = obj.subarraysDivByK(nums, k);
        System.out.println("Result: " + result); // Expected: 7
    }
}