import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int index = 0;
        for (int num : nums) {
            int val = target - num;
            if (map.containsKey(val)) {
                return new int[] { index, map.get(val) };
            } else {
                map.put(num, index);
            }
            index++;
        }

        return new int[] {};

    }
}