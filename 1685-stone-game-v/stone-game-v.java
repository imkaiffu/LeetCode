class Solution {
    private Integer[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new Integer[n][n];
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        return solve(0, n - 1);
    }

    private int solve(int left, int right) {
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int maxScore = 0;
        for (int k = left; k < right; k++) {
            int leftSum = prefixSum[k + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[k + 1];

            if (leftSum < rightSum) {
                maxScore = Math.max(maxScore, leftSum + solve(left, k));
            } else if (rightSum < leftSum) {
                maxScore = Math.max(maxScore, rightSum + solve(k + 1, right));
            } else {
                maxScore = Math.max(maxScore, leftSum + Math.max(solve(left, k), solve(k + 1, right)));
            }
        }
        return memo[left][right] = maxScore;
    }
}