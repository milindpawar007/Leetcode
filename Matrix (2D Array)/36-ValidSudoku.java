import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> boxMap = new HashMap<>();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char currentChar = board[row][col];

                if (currentChar == '.') {
                    continue;
                }

                String boxKey = (row / 3) + " " + (col / 3);

                rowMap.putIfAbsent(row, new HashSet<>());
                colMap.putIfAbsent(col, new HashSet<>());
                boxMap.putIfAbsent(boxKey, new HashSet<>());

                if (rowMap.get(row).contains(currentChar)
                        || colMap.get(col).contains(currentChar)
                        || boxMap.get(boxKey).contains(currentChar)) {
                    return false;
                }

                rowMap.get(row).add(currentChar);
                colMap.get(col).add(currentChar);
                boxMap.get(boxKey).add(currentChar);
            }
        }

        return true;
    }
}