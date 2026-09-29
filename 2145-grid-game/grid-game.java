class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        long topSum = 0;
        for (int val : grid[0]) {
            topSum += val;
        }
        
        long bottomSum = 0;
        long minRobot2Score = Long.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            topSum -= grid[0][i];
            
            long robot2Points = Math.max(topSum, bottomSum);
            minRobot2Score = Math.min(minRobot2Score, robot2Points);
            
            bottomSum += grid[1][i];
        }
        
        return minRobot2Score;
    }
}