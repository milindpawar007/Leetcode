import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();
        int left = 0;

        for (int right = 0; right < n; right++) {

            // 1. Remove smaller elements from back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            // 2. Add current index
            deque.offerLast(right);

            // 3. Remove out-of-window element from front
            if (deque.peekFirst() < left) {
                deque.pollFirst();
            }

            // 4. Record result when window size is reached
            if (right >= k - 1) {
                result[left] = nums[deque.peekFirst()];
                left++;
            }
        }

        return result;
    }
}