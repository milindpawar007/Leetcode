import java.util.*;

/**
 * LeetCode 49: Group Anagrams
 *
 * Approach:
 * - Convert each word to sorted form
 * - Use sorted word as key in HashMap
 * - Group original words under same key
 * - Return all grouped values as List<List<String>>
 *
 * Time Complexity: O(n * k log k)
 * Space Complexity: O(n * k)
 */

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(str);
        }

        // Convert map values to result list
        List<List<String>> result = new ArrayList<>();

        for (List<String> group : map.values()) {
            result.add(group);
        }

        return result;
    }
}