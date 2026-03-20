/*
Problem: 371. Sum of Two Integers (LeetCode)

Description:
Given two integers a and b, return the sum of the two integers 
without using the operators + and -.

--------------------------------------------------

Approach (Bit Manipulation):

Key Idea:
1. XOR (^) → gives sum without carry
2. AND (&) → gives carry bits
3. Shift carry left → move to correct position

Repeat until no carry remains

--------------------------------------------------

Example:
a = 5 (101)
b = 3 (011)

Step 1:
a ^ b = 110 (6)  → sum without carry
a & b = 001 (1) → carry
carry << 1 = 010 (2)

Step 2:
a = 6 (110)
b = 2 (010)

Repeat:
a ^ b = 100 (4)
carry = 100 (4)

Step 3:
a = 4, b = 4

Repeat:
a ^ b = 000
carry = 1000

Continue until carry = 0

Final result = 8

--------------------------------------------------

Steps:
1. While b != 0:
   → carry = (a & b) << 1
   → a = a ^ b
   → b = carry
2. Return a

--------------------------------------------------

Time Complexity: O(1) (max 32 iterations)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int getSum(int a, int b) {

        // Repeat until no carry
        while (b != 0) {

            // Calculate carry
            int carry = (a & b) << 1;

            // Sum without carry
            a = a ^ b;

            // Update carry
            b = carry;
        }

        return a;
    }
}