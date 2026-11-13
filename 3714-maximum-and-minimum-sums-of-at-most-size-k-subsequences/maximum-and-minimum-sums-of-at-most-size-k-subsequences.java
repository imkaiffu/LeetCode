class Solution {
    public static final int MOD = 1_000_000_007;
    public static final int MAX = 100_005;
    public static final long[] FAC = new long[MAX];
    public static final long[] INV = new long[MAX];

    static {
        FAC[0] = 1;
        INV[0] = 1;
        for (int i = 1; i < MAX; i++) {
            FAC[i] = (FAC[i - 1] * i) % MOD;
        }
        INV[MAX - 1] = power(FAC[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i >= 1; i--) {
            INV[i] = (INV[i + 1] * (i + 1)) % MOD;
        }
    }

    private static long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return res;
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return FAC[n] * INV[r] % MOD * INV[n - r] % MOD;
    }

    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] c = new long[n + 1];
        c[0] = 1;
        for (int i = 1; i <= n; i++) {
            c[i] = (c[i - 1] + nCr(n - 1, i)) % MOD;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long sumMax = 0;
            long sumMin = 0;
            for (int j = 0; j < Math.min(i + 1, k); j++) {
                sumMax = (sumMax + nCr(i, j)) % MOD;
            }
            for (int j = 0; j < Math.min(n - i, k); j++) {
                sumMin = (sumMin + nCr(n - 1 - i, j)) % MOD;
            }
            long cur = ((nums[i] * sumMax) % MOD + (nums[i] * sumMin) % MOD) % MOD;
            ans = (ans + cur) % MOD;
        }
        return (int) ans;
    }
}