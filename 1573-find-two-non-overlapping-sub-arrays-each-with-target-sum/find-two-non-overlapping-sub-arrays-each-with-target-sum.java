class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE / 2);
        
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE / 2;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];
            
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            
            if (sum == target) {
                int len = right - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE / 2) {
                    ans = Math.min(ans, dp[left - 1] + len);
                }
                minLen = Math.min(minLen, len);
            }
            dp[right] = minLen;
        }
        
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}