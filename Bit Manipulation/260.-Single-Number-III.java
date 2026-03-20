/*
Problem: 260. Single Number III (LeetCode)

Description:
Given an integer array nums, in which exactly two elements appear only once 
and all the other elements appear exactly twice. Find the two elements 
that appear only once.

Example:
Input: nums = [1,2,1,3,2,5]
Output: [3,5]

--------------------------------------------------

Approach (XOR + Bit Partition):

Key Idea:
1. XOR all elements → duplicates cancel out
   → xor = a ^ b (where a and b are the two unique numbers)

2. Find a set bit (1) in xor
   → This bit is different between a and b

3. Use that bit to divide numbers into 2 groups:
   - Group 1 → bit is 1
   - Group 2 → bit is 0

4. XOR within each group → get a and b separately

--------------------------------------------------

Steps:
1. XOR all numbers → xor = a ^ b
2. Find position of rightmost set bit in xor
3. Divide numbers into two groups based on that bit
4. XOR each group → get two unique numbers

--------------------------------------------------

Time Complexity: O(n)
Space Complexity: O(1)

--------------------------------------------------
*/

class Solution {
    public int[] singleNumber(int[] nums) {

        int xor = 0;

        // Step 1: XOR all elements → gives a ^ b
        for (int num : nums) {
            xor = xor ^ num;
        }

        // Step 2: Find rightmost set bit position
        int count = 0;
        while (true) {
            if ((xor & 1) == 1) {
                break;
            }
            xor = xor >> 1;
            count++;
        }

        int sorted = 0; // group where bit = 1
        int unsorted = 0; // group where bit = 0

        // Step 3: Divide into two groups and XOR
        for (int num : nums) {

            // Check bit at 'count' position
            if (((num >> count) & 1) == 1) {
                sorted = sorted ^ num;
            } else {
                unsorted = unsorted ^ num;
            }
        }

        // Step 4: return two unique numbers
        return new int[] { sorted, unsorted };
    }
}