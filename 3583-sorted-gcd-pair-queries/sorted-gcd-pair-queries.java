class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        
        int[] cnt = new int[max + 1];
        for (int num : nums) {
            cnt[num]++;
        }
        
        long[] gcdCnt = new long[max + 1];
        for (int i = max; i >= 1; i--) {
            long c = 0;
            for (int j = i; j <= max; j += i) {
                c += cnt[j];
            }
            gcdCnt[i] = c * (c - 1) / 2;
            for (int j = 2 * i; j <= max; j += i) {
                gcdCnt[i] -= gcdCnt[j];
            }
        }
        
        for (int i = 1; i <= max; i++) {
            gcdCnt[i] += gcdCnt[i - 1];
        }
        
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long q = queries[i];
            int low = 1, high = max;
            int res = 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (gcdCnt[mid] > q) {
                    res = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            ans[i] = res;
        }
        
        return ans;
    }
}