class Solution {
   private static final int MOD = 1000000007;

    private long[] sum;
    private long[] sumSq;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new long[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int last = lastSeen.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, last + 1, i, 1);
            totalSum = (totalSum + sumSq[1]) % MOD;
            lastSeen.put(nums[i], i);
        }

        return (int) totalSum;
    }

    private void pushDown(int node, int start, int end) {
        if (lazy[node] == 0) {
            return;
        }

        int mid = start + (end - start) / 2;
        int leftChild = 2 * node;
        int rightChild = 2 * node + 1;

        apply(leftChild, start, mid, lazy[node]);
        apply(rightChild, mid + 1, end, lazy[node]);

        lazy[node] = 0;
    }

    private void apply(int node, int start, int end, long val) {
        long len = end - start + 1;
        sumSq[node] = (sumSq[node] + 2 * val % MOD * sum[node] % MOD + val * val % MOD * len % MOD) % MOD;
        sum[node] = (sum[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void update(int node, int start, int end, int l, int r, long val) {
        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }

        pushDown(node, start, end);
        int mid = start + (end - start) / 2;

        if (l <= mid) {
            update(2 * node, start, mid, l, r, val);
        }
        if (r > mid) {
            update(2 * node + 1, mid + 1, end, l, r, val);
        }

        sum[node] = (sum[2 * node] + sum[2 * node + 1]) % MOD;
        sumSq[node] = (sumSq[2 * node] + sumSq[2 * node + 1]) % MOD;
    }
}