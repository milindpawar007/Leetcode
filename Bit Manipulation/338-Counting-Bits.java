/*
Problem: 338. Counting Bits (LeetCode)

Description:
Given an integer n, return an array ans of length n + 1 such that:
ans[i] is the number of 1's in the binary representation of i.

Example:
Input: n = 5
Output: [0,1,1,2,1,2]

--------------------------------------------------

Approach (Dynamic Programming + Bit Logic):

Key Idea:
For any number i:
- i / 2 → removes last bit (right shift)
- i % 2 → gives last bit (0 or 1)

So:
result[i] = result[i / 2] + (i % 2)

Example:
i = 5 → binary 101
i/2 = 2 → binary 10 → has 1 set bit
i%2 = 1 → last bit is 1

So:
result[5] = result[2] + 1 = 1 + 1 = 2

--------------------------------------------------

Steps:
1. Initialize result array of size n+1
2. result[0] = 0
3. Loop from 1 to n:
   → result[i] = result[i/2] + (i%2)
4. Return result

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(n)

--------------------------------------------------
*/

class Solution {
    public int[] countBits(int n) {

        // Create result array
        int result[] = new int[n + 1];

        // Base case
        result[0] = 0;

        // Fill using DP relation
        for (int i = 1; i <= n; i++) {

            // result[i/2] → bits without last bit
            // (i%2) → last bit (0 or 1)
            result[i] = result[i / 2] + (i % 2);
        }

        return result;
    }
}