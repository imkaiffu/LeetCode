class Solution {
    public long maxScore(int[] nums) {
       int n = nums.length;
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return (long) nums[0] * nums[0];
        }

        long[] prefGcd = new long[n];
        long[] prefLcm = new long[n];
        long[] suffGcd = new long[n];
        long[] suffLcm = new long[n];

        prefGcd[0] = nums[0];
        prefLcm[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefGcd[i] = gcd(prefGcd[i - 1], nums[i]);
            prefLcm[i] = lcm(prefLcm[i - 1], nums[i]);
        }

        suffGcd[n - 1] = nums[n - 1];
        suffLcm[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffGcd[i] = gcd(suffGcd[i + 1], nums[i]);
            suffLcm[i] = lcm(suffLcm[i + 1], nums[i]);
        }

        long ans = prefGcd[n - 1] * prefLcm[n - 1];

        for (int i = 0; i < n; i++) {
            long curGcd;
            long curLcm;
            if (i == 0) {
                curGcd = suffGcd[1];
                curLcm = suffLcm[1];
            } else if (i == n - 1) {
                curGcd = prefGcd[n - 2];
                curLcm = prefLcm[n - 2];
            } else {
                curGcd = gcd(prefGcd[i - 1], suffGcd[i + 1]);
                curLcm = lcm(prefLcm[i - 1], suffLcm[i + 1]);
            }
            ans = Math.max(ans, curGcd * curLcm);
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; 
    }
}