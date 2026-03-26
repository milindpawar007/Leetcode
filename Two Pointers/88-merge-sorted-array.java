/**
 * Problem: Merge Sorted Array (LeetCode 88)
 *
 * Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 *
 * nums1 has size m + n, where first m elements are valid,
 * and last n elements are empty (0s).
 *
 * Approach:
 * - Use three pointers from the end
 * - Compare and place larger element at the end
 * - Copy remaining nums2 if any
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(1)
 */

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int rightpointer1 = m - 1;
        int rightpointer2 = n - 1;
        int writepointer = m + n - 1;

        // Step 1: Compare and fill from back
        while (rightpointer1 >= 0 && rightpointer2 >= 0) {
            if (nums1[rightpointer1] < nums2[rightpointer2]) {
                nums1[writepointer] = nums2[rightpointer2];
                rightpointer2--;
            } else {
                nums1[writepointer] = nums1[rightpointer1];
                rightpointer1--;
            }
            writepointer--;
        }

        // Step 2: Copy remaining nums2 elements
        while (rightpointer2 >= 0) {
            nums1[writepointer] = nums2[rightpointer2];
            rightpointer2--;
            writepointer--;
        }
    }
}