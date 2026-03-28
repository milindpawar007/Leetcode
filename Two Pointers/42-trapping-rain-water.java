/**
 * LeetCode 42. Trapping Rain Water
 *
 * Problem:
 * Given n non-negative integers representing an elevation map,
 * compute how much water it can trap after raining.
 *
 * Example:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Approach (Two Pointer - Optimal):
 *
 * 1. Use two pointers:
 * left = 0, right = n - 1
 *
 * 2. Track:
 * leftMax = max height from left
 * rightMax = max height from right
 *
 * 3. Logic:
 * - If leftMax < rightMax:
 * water = leftMax - height[left]
 * move left++
 * - Else:
 * water = rightMax - height[right]
 * move right--
 *
 * Why it works:
 * The smaller side determines the trapped water.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public int trap(int[] height) {

        if (height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while (left < right) {

            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                result += leftMax - height[left];
                left++;
            } else {
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }
}