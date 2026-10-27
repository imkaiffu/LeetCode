class Solution {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        
        StringBuilder firstRow = new StringBuilder();
        for (int j = 0; j < n; j++) {
            firstRow.append('.');
        }
        grid[0] = firstRow.toString();

        StringBuilder remainingRows = new StringBuilder();
        for (int j = 0; j < n - 1; j++) {
            remainingRows.append('#');
        }
        remainingRows.append('.');
        
        String otherRowStr = remainingRows.toString();
        for (int i = 1; i < m; i++) {
            grid[i] = otherRowStr;
        }

        return grid;
    }
}