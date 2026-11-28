class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxFactor = 0;
        long minPrice = Long.MAX_VALUE;

        for (int[] it : items) {
            maxFactor = Math.max(maxFactor, it[0]);
            minPrice = Math.min(minPrice, it[1]);
        }

        int[] cnt = new int[maxFactor + 1];
        for (int[] it : items) {
            cnt[it[0]]++;
        }

        int[] multiples = new int[maxFactor + 1];
        for (int f = 1; f <= maxFactor; f++) {
            if (cnt[f] == 0) continue;
            for (int m = f; m <= maxFactor; m += f) {
                multiples[f] += cnt[m];
            }
        }

        long[][] units = new long[n][2];
        for (int i = 0; i < n; i++) {
            units[i][0] = items[i][1];
            units[i][1] = multiples[items[i][0]] - 1;
        }

        Arrays.sort(units, (a, b) -> Long.compare(a[0], b[0]));

        long remBudget = budget;
        long totalItems = 0;
        long twoMinPrice = 2L * minPrice;

        for (long[] u : units) {
            long price = u[0];
            long cap = u[1];
            if (price >= twoMinPrice) break;
            if (remBudget < price) continue;
            long take = Math.min(cap, remBudget / price);
            totalItems += 2L * take;
            remBudget -= take * price;
        }

        totalItems += remBudget / minPrice;
        return (int) totalItems;
    }
}