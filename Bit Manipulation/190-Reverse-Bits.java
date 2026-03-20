/*
Problem: 190. Reverse Bits (LeetCode)

Description:
Reverse bits of a given 32-bit unsigned integer.

Example:
Input:  n = 00000010100101000001111010011100
Output:       00111001011110000010100101000000

--------------------------------------------------

Approach (Bit by Bit Reverse):

Key Idea:
- Extract last bit of n
- Place it in correct reversed position
- Shift n to process next bit

--------------------------------------------------

Steps:
1. Initialize result = 0
2. Loop from i = 31 to 0:
   → Extract last bit: (n & 1)
   → Place it at position i: (bit << i)
   → Add to result
   → Right shift n
3. Return result

--------------------------------------------------

Example:
n = 101

Step:
Take last bit → 1 → place at highest position
Continue shifting and placing

--------------------------------------------------

Time Complexity: O(32) → constant
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int reverseBits(int n) {

        int result = 0;

        // Process all 32 bits
        for (int i = 31; i >= 0; i--) {

            // Extract last bit
            int bit = n & 1;

            // Place it in reversed position
            result = result + (bit << i);

            // Shift n to process next bit
            n = n >> 1;
        }

        return result;
    }
}