/*
Problem: 191. Number of 1 Bits (LeetCode)

Description:
Given an integer n, return the number of '1' bits 
(also known as the Hamming weight).

Example:
Input: n = 11 (binary: 1011)
Output: 3

--------------------------------------------------

Approach (Brian Kernighan’s Algorithm):

Key Idea:
n & (n - 1) removes the rightmost set bit (1)

Example:
n = 1011
n-1 = 1010
n & (n-1) = 1010  → removed last 1

Repeat until n becomes 0

--------------------------------------------------

Steps:
1. Initialize count = 0
2. While n != 0:
   → n = n & (n - 1)  (remove one set bit)
   → increment count
3. Return count

--------------------------------------------------

Time Complexity: O(number of 1 bits)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int hammingWeight(int n) {

        int count = 0;

        // Loop until all set bits are removed
        while (n != 0) {

            // Remove the rightmost 1 bit
            n = n & (n - 1);

            // Increment count
            count++;
        }

        return count;
    }
}