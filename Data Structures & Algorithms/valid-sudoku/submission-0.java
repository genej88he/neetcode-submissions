class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> row = new HashMap<>();
            Map<Character, Integer> column = new HashMap<>();

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!row.containsKey(board[i][j])) {
                        row.put(board[i][j], 1);
                    } else {
                        row.put(board[i][j], row.get(board[i][j]) + 1);
                    }
                }
                if (board[j][i] != '.') {
                    if (!column.containsKey(board[j][i])) {
                        column.put(board[j][i], 1);
                    } else {
                        column.put(board[j][i], column.get(board[j][i]) + 1);
                    }
                }

            }
            
            for (Character each : row.keySet()) {
                if (row.get(each) > 1) {
                    return false;
                }
            }

            for (Character each : column.keySet()) {
                if (column.get(each) > 1) {
                    return false;
                }
            }    
        }
        for (int i = 0; i < 9; i++) {
            Map<Character, Integer> square = new HashMap<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = (i / 3) * 3 + j;
                    int column = (i % 3) * 3 + k;
                    if (board[row][column] != '.') {
                        if (!square.containsKey(board[row][column])) {
                            square.put(board[row][column], 1);
                        } else {
                            square.put(board[row][column], square.get(board[row][column]) + 1);
                        }
                    }
                }
            }

            for (Character each : square.keySet()) {
                if (square.get(each) > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
