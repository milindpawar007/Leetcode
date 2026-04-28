// Problem: Best Sightseeing Pair
// Platform: LeetCode
// Approach: Greedy / Optimization using formula split

class Solution {
    public int maxScoreSightseeingPair(int[] values) {

        int result = 0;

        // best value of (values[i] + i)
        int maxVal = values[0];

        for (int j = 1; j < values.length; j++) {

            // calculate score using best previous i
            int current = maxVal + values[j] - j;

            result = Math.max(result, current);

            // update best (values[i] + i)
            maxVal = Math.max(maxVal, values[j] + j);
        }

        return result;
    }
}