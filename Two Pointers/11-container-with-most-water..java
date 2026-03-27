public class 11-container-with-most-water. {
    
}
/*
Problem: 11. Container With Most Water (LeetCode)

Description:
You are given an integer array height of length n.
There are n vertical lines drawn such that the two endpoints of the i-th line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Example:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49

Approach (Optimal - Two Pointer):
- Start with two pointers: left = 0, right = n - 1
- Calculate area = min(height[left], height[right]) * (right - left)
- Move the pointer with smaller height
- Keep updating max area

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int maxArea(int[] height) {

        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int temparea = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(temparea, area);

            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return area;
    }
}