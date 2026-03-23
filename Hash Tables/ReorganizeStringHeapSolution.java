import java.util.*;

/**
 * LeetCode 767 - Reorganize String
 *
 * Approach: Max Heap (PriorityQueue)
 *
 * Steps:
 * 1. Count frequency using HashMap
 * 2. Check if valid reorganization is possible
 * 3. Use max heap to always pick top 2 frequent chars
 * 4. Append them and reduce frequency
 * 5. Push back if still remaining
 */
public class ReorganizeStringHeapSolution {

    public String reorganizeString(String s) {
        // Step 1: Frequency map
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Find max frequency
        int max = 0;
        for (int val : freq.values()) {
            max = Math.max(max, val);
        }

        // Step 3: Check feasibility
        int n = s.length();
        if (max > (n + 1) / 2) {
            return "";
        }

        // Step 4: Max heap based on frequency
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        // Step 5: Build result
        StringBuilder result = new StringBuilder();

        while (pq.size() >= 2) {
            Map.Entry<Character, Integer> first = pq.poll();
            Map.Entry<Character, Integer> second = pq.poll();

            result.append(first.getKey());
            result.append(second.getKey());

            first.setValue(first.getValue() - 1);
            second.setValue(second.getValue() - 1);

            if (first.getValue() > 0) {
                pq.offer(first);
            }
            if (second.getValue() > 0) {
                pq.offer(second);
            }
        }

        // Step 6: Handle last remaining character
        if (!pq.isEmpty()) {
            result.append(pq.poll().getKey());
        }

        return result.toString();
    }

    // Optional: Main method for quick testing
    public static void main(String[] args) {
        ReorganizeStringHeapSolution obj = new ReorganizeStringHeapSolution();

        String input = "aab";
        String output = obj.reorganizeString(input);

        System.out.println("Input: " + input);
        System.out.println("Output: " + output);
    }
}
