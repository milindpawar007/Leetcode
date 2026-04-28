/**
 * LeetCode 918 - Maximum Sum Circular Subarray
 *
 * Approach:
 * Kadane’s Algorithm (extended for circular arrays)
 *
 * Idea:
 * Case 1 (Normal): Maximum subarray using Kadane
 * Case 2 (Circular): Total sum - Minimum subarray
 *
 * Final Answer:
 * max(maxSubarraySum, totalSum - minSubarraySum)
 *
 * Edge Case:
 * If all numbers are negative → return maxSubarraySum directly
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int currentMax = 0, maxSum = nums[0];
        int currentMin = 0, minSum = nums[0];
        int totalSum = 0;

        for (int num : nums) {

            // Max subarray (Kadane)
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);

            // Min subarray (Kadane)
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);

            totalSum += num;
        }

        // All negative case
        if (maxSum < 0)
            return maxSum;

        // Circular case vs normal case
        return Math.max(maxSum, totalSum - minSum);
    }
}