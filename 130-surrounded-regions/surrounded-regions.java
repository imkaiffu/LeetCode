class Solution {
    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (board[i][j] == 'O') {
                        dfs(i, j, board, r, c);
                    }
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'M') {
                    board[i][j] = 'O';
                }


            }
        }
    }

    public void dfs(int i, int j, char[][] grid, int r, int c) {
        if (i < 0 || j < 0 || i == r || j == c || grid[i][j] != 'O') {
            return;
        }
        grid[i][j] = 'M';
        dfs(i, j + 1, grid, r, c); // right
        dfs(i + 1, j, grid, r, c); // bottom
        dfs(i, j - 1, grid, r, c); // left
        dfs(i - 1, j, grid, r, c); // top
    }
}