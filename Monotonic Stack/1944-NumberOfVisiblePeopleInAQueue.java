class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {

            int count = 0;

            // pop smaller
            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }

            // first greater/equal also visible
            if (!stack.isEmpty()) {
                count++;
            }

            result[i] = count;

            stack.push(heights[i]);
        }

        return result;
    }
}