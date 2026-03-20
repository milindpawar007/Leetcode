/*
Problem: 201. Bitwise AND of Numbers Range (LeetCode)

Description:
Given two integers left and right that represent the range [left, right],
return the bitwise AND of all numbers in this range.

Example:
Input: left = 5, right = 7
Output: 4

--------------------------------------------------

Approach (Common Prefix / Bit Shift):

Key Idea:
- When numbers increase, right-side bits keep changing.
- Only the common left-side prefix remains same.

So:
Keep shifting both left and right until they become equal.
Count how many shifts we did.
Then shift back to restore position.

--------------------------------------------------

Example:
left = 5  → 101
right = 7 → 111

Step 1:
101 → 10
111 → 11

Step 2:
10 → 1
11 → 1   (now equal)

Common prefix = 1
Shifts = 2

Result = 1 << 2 = 100 = 4

--------------------------------------------------

Steps:
1. Initialize shift = 0
2. While left != right:
   → right shift both
   → increment shift
3. Return left << shift

--------------------------------------------------

Time Complexity: O(1) (max 32 iterations)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        // Find common prefix
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }

        // Restore shifted bits
        return left << shift;
    }
}