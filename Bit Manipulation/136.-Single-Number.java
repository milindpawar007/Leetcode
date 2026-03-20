/*
Problem: 136. Single Number (LeetCode)

Description:
Given a non-empty array of integers nums, every element appears twice 
except for one. Find that single one.

You must implement a solution with:
- Linear runtime complexity
- Constant extra space

Example:
Input: nums = [4,1,2,1,2]
Output: 4

--------------------------------------------------

Approach (XOR Logic):
1. XOR of a number with itself = 0
   → a ^ a = 0

2. XOR of a number with 0 = same number
   → a ^ 0 = a

3. XOR is commutative and associative
   → Order does not matter

4. So:
   All duplicate numbers cancel out → only single number remains

Example:
[4,1,2,1,2]
→ (1^1) = 0
→ (2^2) = 0
→ 4 ^ 0 ^ 0 = 4

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int singleNumber(int[] nums) {

        // Initialize result with first element
        int result = nums[0];

        // XOR all elements
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        // Final result is the single number
        return result;
    }
}