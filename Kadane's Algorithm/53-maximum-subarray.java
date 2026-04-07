/**
 * LeetCode 53 - Maximum Subarray
 *
 * Approach:
 * Kadane’s Algorithm
 *
 * Idea:
 * At each index, decide:
 * 1. Start new subarray from current element
 * 2. Continue previous subarray
 *
 * Formula:
 * currentSum = max(nums[i], currentSum + nums[i])
 * maxSum = max(maxSum, currentSum)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}