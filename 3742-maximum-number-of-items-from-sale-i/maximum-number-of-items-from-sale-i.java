class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freeCount = new int[n];

        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factorI == 0) {
                    count++;
                }
            }
            freeCount[i] = count;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int bonus = freeCount[i];

            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1 + bonus);
            }

            for (int b = cost; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1);
            }
        }

        return dp[budget];
    }
}