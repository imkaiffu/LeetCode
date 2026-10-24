class Solution {
    public int numEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0 || i == r - 1 || j == c - 1) {
                    if (grid[i][j] == 1) {
                        dfs(i, j, grid, r, c);
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }

        }
        return count;
    }

    public void dfs(int i, int j, int[][] grid, int r, int c) {
        if (i < 0 || j < 0 || i == r || j == c || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;

        dfs(i, j + 1, grid, r, c); // right
        dfs(i + 1, j, grid, r, c); // bottom
        dfs(i, j - 1, grid, r, c); // left
        dfs(i - 1, j, grid, r, c); // top
    }
}