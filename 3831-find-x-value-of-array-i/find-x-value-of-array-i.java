class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        long[] dp = new long[k];
        
        for (int num : nums) {
            long[] nextDp = new long[k];
            int rem = num % k;
            
            nextDp[rem]++;
            
            for (int i = 0; i < k; i++) {
                if (dp[i] > 0) {
                    int nextRem = (int) (((long) i * num) % k);
                    nextDp[nextRem] += dp[i];
                }
            }
            
            for (int i = 0; i < k; i++) {
                dp[i] = nextDp[i];
                result[i] += dp[i];
            }
        }
        
        return result;
    }
}