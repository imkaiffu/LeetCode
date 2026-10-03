class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(cost , n , dp);
    }
    public int solve(int []cost , int n , int []dp){
        if(n <= 1) return 0;
        if(dp[n] != -1) return dp[n];
        int aStep = cost[n-1] + solve(cost , n-1 , dp);
        int dStep = cost[n-2] + solve(cost , n-2,dp);
        dp[n] = Math.min(aStep , dStep);
        return dp[n];
    }
}