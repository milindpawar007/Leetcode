public class 347-TopKFrequentElements {
    
}
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create bucket (index = frequency)
        List<Integer>[] bucket = new List[nums.length + 1];

        // Initialize each bucket
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // Step 3: Fill bucket
        for (int key : map.keySet()) {
            int freq = map.get(key);
            bucket[freq].add(key);
        }

        // Step 4: Collect top k elements
        int[] result = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int num : bucket[i]) {
                result[index++] = num;
                if (index == k) return result;
            }
        }

        return result;
    }
}