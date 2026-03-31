/*
Problem: 643. Maximum Average Subarray I (Easy)

Given an integer array nums consisting of n elements, and an integer k,
find a contiguous subarray whose length is equal to k that has the maximum average value.
Return this value.

----------------------------------------------------
Approach: Sliding Window (Optimal)

Core Idea:
- Instead of recalculating sum for every subarray (O(n*k)),
  use a sliding window to maintain the sum in O(n)

Steps:
1. Calculate sum of first window of size k
2. Slide the window:
   - Remove left element
   - Add new right element
3. Track maximum average

----------------------------------------------------
Example:
nums = [1,12,-5,-6,50,3], k = 4

First window sum = 1 + 12 + (-5) + (-6) = 2
Next:
Remove 1, add 50 → sum = 51
Next:
Remove 12, add 3 → sum = 42

Max average = 51 / 4 = 12.75

----------------------------------------------------
Time Complexity: O(n)
Space Complexity: O(1)
----------------------------------------------------
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int sum = 0;

        // Step 1: First window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = (double) sum / k;

        int start = 0;

        // Step 2: Slide the window
        for (int end = k; end < nums.length; end++) {

            sum = sum - nums[start];
            start++;

            sum = sum + nums[end];

            double avg = (double) sum / k;
            result = Math.max(result, avg);
        }

        return result;
    }
}