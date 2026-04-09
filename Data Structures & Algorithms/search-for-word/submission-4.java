class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    private boolean exist(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) {
            return false;
        }

        board[x][y] = '#';
        boolean result = exist(board, word, index + 1, x - 1, y) || exist(board, word, index + 1, x + 1, y) ||
                         exist(board, word, index + 1, x, y - 1) || exist(board, word, index + 1, x, y + 1);
        board[x][y] = word.charAt(index);
        return result;

    }
}
