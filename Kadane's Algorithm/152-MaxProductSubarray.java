// Problem: Maximum Product Subarray
// Platform: LeetCode
// Approach: Prefix + Suffix Scan (O(n))

class Solution {
    public int maxProduct(int[] nums) {

        int result = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < nums.length; i++) {

            // reset when product becomes 0
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            // forward product
            prefix = prefix * nums[i];

            // backward product
            suffix = suffix * nums[nums.length - 1 - i];

            // update result
            result = Math.max(result, Math.max(prefix, suffix));
        }

        return result;
    }
}