/*
LeetCode: 1004. Max Consecutive Ones III

Approach:
- Sliding Window (Two Pointers)
- We can flip at most k zeros → treat zeros as "cost"

Steps:
1. Expand window using right pointer
2. Count zeros in current window
3. If zeroCount > k:
   - Shrink window from left until valid
4. Track max window size

Why it works:
- We maintain a window with at most k zeros
- This ensures we can flip those zeros to 1s

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {

        int right = 0;
        int left = 0;
        int result = 0;
        int zeroCount = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            result = Math.max(result, right - left + 1);
            right++;
        }

        return result;
    }
}