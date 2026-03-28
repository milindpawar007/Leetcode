
/**
 * LeetCode 15. 3Sum
 *
 * Problem:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, j != k, and:
 *
 * nums[i] + nums[j] + nums[k] == 0
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Approach (Using HashSet):
 * 1. Sort the array
 * 2. Fix one element (i)
 * 3. Use two pointers (left, right)
 * 4. If sum == 0 → add to Set (avoids duplicates)
 * 5. Move pointers accordingly
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n) (due to HashSet)
 */

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length <= 2) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}