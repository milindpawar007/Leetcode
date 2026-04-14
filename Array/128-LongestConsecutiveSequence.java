// File: Arrays/LongestConsecutiveSequence.java

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        // Step 1: Add all elements to set
        for (int num : nums) {
            set.add(num);
        }

        int maxlen = 0;

        // Step 2: Find sequences
        for (int num : set) {

            // Start only if it's the beginning of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxlen = Math.max(maxlen, length);
            }
        }

        return maxlen;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(sol.longestConsecutive(nums)); // Output: 4
    }
}