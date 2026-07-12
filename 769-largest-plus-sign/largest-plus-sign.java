class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n);
        }
        
        for (int[] mine : mines) {
            dp[mine[0]][mine[1]] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            int left = 0, right = 0, up = 0, down = 0;
            
            for (int j = 0, k = n - 1; j < n; j++, k--) {
                left = (dp[i][j] == 0) ? 0 : left + 1;
                dp[i][j] = Math.min(dp[i][j], left);
                
                right = (dp[i][k] == 0) ? 0 : right + 1;
                dp[i][k] = Math.min(dp[i][k], right);
                
                up = (dp[j][i] == 0) ? 0 : up + 1;
                dp[j][i] = Math.min(dp[j][i], up);
                
                down = (dp[k][i] == 0) ? 0 : down + 1;
                dp[k][i] = Math.min(dp[k][i], down);
            }
        }
        
        int maxOrder = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxOrder = Math.max(maxOrder, dp[i][j]);
            }
        }
        
        return maxOrder;
    }
}