/*
LeetCode: 209. Minimum Size Subarray Sum

Approach:
- Use Sliding Window (Two Pointers)
- Since all numbers are positive:
  → expanding window increases sum
  → shrinking window decreases sum

Steps:
1. Expand window using right pointer and keep adding to sum
2. When sum >= target:
   - Update minimum length
   - Shrink window from left to minimize size
3. Continue until end

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int result = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }

            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}