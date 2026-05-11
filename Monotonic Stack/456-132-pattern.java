
import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {

        if (nums.length < 3)
            return false;

        Stack<Integer> stack = new Stack<>();
        int secondmax = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            // nums[i] becomes "1"
            if (nums[i] < secondmax) {
                return true;
            }

            // maintain decreasing stack
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondmax = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}