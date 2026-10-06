class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long[] count = new long[101];
        for (int x : arr) {
            count[x]++;
        }
        
        long ans = 0;
        long mod = 1_000_000_007;
        
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) {
                    continue;
                }
                
                if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j < k) {
                    ans += (count[i] * (count[i] - 1) / 2) * count[k];
                } else if (i < j && j == k) {
                    ans += count[i] * (count[j] * (count[j] - 1) / 2);
                } else if (i < j && j < k) {
                    ans += count[i] * count[j] * count[k];
                }
                
                ans %= mod;
            }
        }
        
        return (int) ans;
    }
}