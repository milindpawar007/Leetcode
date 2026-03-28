/*
Problem: 303. Range Sum Query - Immutable

Description:
Given an integer array nums, handle multiple queries of the following type:
- Return the sum of elements between indices left and right (inclusive).

Approach:
- Use Prefix Sum
- Precompute cumulative sums in constructor
- Answer each query in O(1)

Time Complexity:
- Constructor: O(n)
- sumRange: O(1)

Space Complexity:
- O(n)
*/

class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {

        // Create prefix array of size n+1
        prefix = new int[nums.length + 1];

        // Build prefix sum
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {

        // Return sum in O(1)
        if (left == 0) {
            return prefix[right];
        }
        int result = prefix[right] - prefix[left - 1];

        return result;
    }
}