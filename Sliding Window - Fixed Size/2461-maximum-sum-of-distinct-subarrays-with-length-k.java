/*
Problem: Maximum Sum of Distinct Subarrays With Length K

Approach:
Sliding Window + Frequency Map

- Build first window of size k
- Maintain running sum
- Use HashMap to track frequency
- Slide window:
    - remove left element
    - add right element
- If map.size() == k → all elements are distinct
- Update max sum

Time Complexity: O(n)
Space Complexity: O(k)
*/

import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        if (k > nums.length)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long result = 0;

        // First window
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
        }

        if (map.size() == k) {
            result = sum;
        }

        // Sliding window
        for (int i = 1; i <= nums.length - k; i++) {
            int outgoing = nums[i - 1];
            int incoming = nums[i + k - 1];

            // Update sum
            sum -= outgoing;
            sum += incoming;

            // Remove outgoing
            map.put(outgoing, map.get(outgoing) - 1);
            if (map.get(outgoing) == 0) {
                map.remove(outgoing);
            }

            // Add incoming
            map.put(incoming, map.getOrDefault(incoming, 0) + 1);

            // Check distinct
            if (map.size() == k) {
                result = Math.max(result, sum);
            }
        }

        return result;
    }
}