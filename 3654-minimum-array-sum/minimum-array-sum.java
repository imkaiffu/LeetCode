class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        int[][][] dp = new int[n + 1][op1 + 1][op2 + 1];
        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE / 2);
            }
        }
        dp[0][op1][op2] = 0;

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int half = (x + 1) / 2;
            for (int a = 0; a <= op1; a++) {
                for (int b = 0; b <= op2; b++) {
                    int cur = dp[i][a][b];
                    if (cur >= Integer.MAX_VALUE / 2) {
                        continue;
                    }
                    dp[i + 1][a][b] = Math.min(dp[i + 1][a][b], cur + x);
                    if (a > 0) {
                        dp[i + 1][a - 1][b] = Math.min(dp[i + 1][a - 1][b], cur + half);
                    }
                    if (b > 0 && x >= k) {
                        dp[i + 1][a][b - 1] = Math.min(dp[i + 1][a][b - 1], cur + (x - k));
                    }
                    if (a > 0 && b > 0) {
                        if (half >= k) {
                            dp[i + 1][a - 1][b - 1] = Math.min(dp[i + 1][a - 1][b - 1], cur + (half - k));
                        }
                        if (x >= k) {
                            int subHalf = ((x - k) + 1) / 2;
                            dp[i + 1][a - 1][b - 1] = Math.min(dp[i + 1][a - 1][b - 1], cur + subHalf);
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int a = 0; a <= op1; a++) {
            for (int b = 0; b <= op2; b++) {
                ans = Math.min(ans, dp[n][a][b]);
            }
        }
        return ans;
    }
}