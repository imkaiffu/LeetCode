class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] countX = new int[n];
        int[] countY = new int[n];
        int ans = 0;

        for (int i = 0; i < m; i++) {
            int rowX = 0;
            int rowY = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'X') {
                    rowX++;
                } else if (grid[i][j] == 'Y') {
                    rowY++;
                }
                countX[j] += rowX;
                countY[j] += rowY;

                if (countX[j] > 0 && countX[j] == countY[j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}