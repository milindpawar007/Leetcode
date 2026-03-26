
/**
 * Problem: Two Sum II - Input Array Is Sorted (LeetCode 167)
 *
 * Given a 1-indexed array of integers that is already sorted,
 * find two numbers such that they add up to a specific target.
 *
 * Return the indices of the two numbers (1-based index).
 *
 * Approach:
 * - Use two pointers (left and right)
 * - If sum is too large → move right pointer left
 * - If sum is too small → move left pointer right
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] { left + 1, right + 1 }; // 1-based index
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {}; // fallback (though problem guarantees one solution)
    }
}