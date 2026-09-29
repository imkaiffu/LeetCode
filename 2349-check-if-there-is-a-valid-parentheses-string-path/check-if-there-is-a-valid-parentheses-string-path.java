class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
            return false;
        }
        
        int maxBalance = (m + n) / 2;
        boolean[][][] visited = new boolean[m][n][maxBalance + 1];
        
        return dfs(grid, 0, 0, 0, visited, m, n);
    }
    
    private boolean dfs(char[][] grid, int i, int j, int balance, boolean[][][] visited, int m, int n) {
        if (i >= m || j >= n) {
            return false;
        }
        
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }
        
        if (balance < 0 || balance >= visited[0][0].length) {
            return false;
        }
        
        if (i == m - 1 && j == n - 1) {
            return balance == 0;
        }
        
        if (visited[i][j][balance]) {
            return false;
        }
        
        visited[i][j][balance] = true;
        
        return dfs(grid, i + 1, j, balance, visited, m, n) || dfs(grid, i, j + 1, balance, visited, m, n);
    }
}