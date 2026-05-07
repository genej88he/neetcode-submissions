class Solution {
    public void solve(char[][] board) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
                    if (board[i][j] == 'O') {
                        dfs(board, i, j, seen);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && !seen[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y, boolean[][] seen) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[x].length && board[x][y] == 'O' && !seen[x][y]) {
            seen[x][y] = true;
            int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] directions : dir) {
                int newX = x + directions[0];
                int newY = y + directions[1];
                dfs(board, newX, newY, seen);
            }
        }
    }
}

