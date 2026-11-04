class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] minOps = getMinOps(nums, x);
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        for (int j = 1; j <= k; j++) {
            for (int i = j * x; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                long prev = dp[j - 1][i - x];
                if (prev < INF) {
                    dp[j][i] = Math.min(dp[j][i], prev + minOps[i - x]);
                }
            }
        }

        return dp[k][n];
    }

    private long[] getMinOps(int[] nums, int x) {
        int n = nums.length;
        long[] res = new long[n - x + 1];
        Comparator<int[]> cmp = (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
        TreeSet<int[]> lo = new TreeSet<>(cmp);
        TreeSet<int[]> hi = new TreeSet<>(cmp);
        long loSum = 0;
        long hiSum = 0;

        for (int i = 0; i < n; i++) {
            int[] cur = new int[]{nums[i], i};
            if (lo.isEmpty() || cmp.compare(cur, lo.last()) <= 0) {
                lo.add(cur);
                loSum += cur[0];
            } else {
                hi.add(cur);
                hiSum += cur[0];
            }

            if (i >= x) {
                int[] out = new int[]{nums[i - x], i - x};
                if (lo.remove(out)) {
                    loSum -= out[0];
                } else {
                    hi.remove(out);
                    hiSum -= out[0];
                }
            }

            int size = lo.size() + hi.size();
            int target = (size + 1) / 2;

            while (lo.size() > target) {
                int[] t = lo.pollLast();
                loSum -= t[0];
                hi.add(t);
                hiSum += t[0];
            }
            while (lo.size() < target) {
                int[] t = hi.pollFirst();
                hiSum -= t[0];
                lo.add(t);
                loSum += t[0];
            }

            if (i >= x - 1) {
                long med = lo.last()[0];
                res[i - x + 1] = med * lo.size() - loSum + hiSum - med * hi.size();
            }
        }

        return res;
    }
}