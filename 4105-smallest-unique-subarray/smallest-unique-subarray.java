class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 1_000_000_009L;
    private static final long BASE1 = 1_000_003L;
    private static final long BASE2 = 1_000_033L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        long[] p1 = new long[n + 1];
        long[] p2 = new long[n + 1];
        p1[0] = 1;
        p2[0] = 1;
        for (int i = 1; i <= n; i++) {
            p1[i] = (p1[i - 1] * BASE1) % MOD1;
            p2[i] = (p2[i - 1] * BASE2) % MOD2;
        }

        long[] h1 = new long[n + 1];
        long[] h2 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            long val = nums[i] + 1_000_000_005L;
            h1[i + 1] = (h1[i] * BASE1 + (val % MOD1)) % MOD1;
            h2[i + 1] = (h2[i] * BASE2 + (val % MOD2)) % MOD2;
        }

        int lo = 1, hi = n, ans = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUniqueOfLength(nums, mid, h1, h2, p1, p2)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean hasUniqueOfLength(int[] nums, int len, long[] h1, long[] h2, long[] p1, long[] p2) {
        int n = nums.length;
        Map<Long, Integer> freq = new HashMap<>(n * 2);
        for (int i = 0; i + len <= n; i++) {
            int j = i + len;
            long x1 = (h1[j] - (h1[i] * p1[len]) % MOD1 + MOD1) % MOD1;
            long x2 = (h2[j] - (h2[i] * p2[len]) % MOD2 + MOD2) % MOD2;
            long key = (x1 << 32) ^ x2;
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count == 1) {
                return true;
            }
        }
        return false;
    }
}