class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        long[] evenCost = new long[k];
        long[] oddCost = new long[k];

        for (int i = 0; i < n; i++) {
            int rem = ((nums[i] % k) + k) % k;
            if (i % 2 == 0) {
                for (int target = 0; target < k; target++) {
                    evenCost[target] += minStep(rem, target, k);
                }
            } else {
                for (int target = 0; target < k; target++) {
                    oddCost[target] += minStep(rem, target, k);
                }
            }
        }

        long ans = Long.MAX_VALUE;
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                if (x != y) {
                    ans = Math.min(ans, evenCost[x] + oddCost[y]);
                }
            }
        }

        return (int) ans;
    }

    private long minStep(int cur, int target, int k) {
        long diff = Math.abs((long) cur - target);
        return Math.min(diff, k - diff);
    }
}