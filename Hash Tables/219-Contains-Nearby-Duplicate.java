import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 219: Contains Duplicate II
 *
 * Problem:
 * Given an integer array nums and an integer k, return true if there are two
 * distinct indices i and j
 * such that nums[i] == nums[j] and |i - j| <= k.
 *
 * Approach:
 * - Use a HashMap to store each number and its latest index.
 * - While iterating:
 * 1. If number already exists in map:
 * - Check if current index - stored index <= k
 * - If yes, return true
 * 2. Update the index of the current number in map
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // Map to store number -> latest index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // If number already seen before
            if (map.containsKey(nums[i])) {

                int prevIndex = map.get(nums[i]);

                // Check if distance is within k
                if (i - prevIndex <= k) {
                    return true;
                }
            }

            // Update latest index of the number
            map.put(nums[i], i);
        }

        return false;
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = { 1, 2, 3, 1 };
        int k1 = 3;
        System.out.println(sol.containsNearbyDuplicate(nums1, k1)); // true

        int[] nums2 = { 1, 0, 1, 1 };
        int k2 = 1;
        System.out.println(sol.containsNearbyDuplicate(nums2, k2)); // true

        int[] nums3 = { 1, 2, 3, 1, 2, 3 };
        int k3 = 2;
        System.out.println(sol.containsNearbyDuplicate(nums3, k3)); // false
    }
}