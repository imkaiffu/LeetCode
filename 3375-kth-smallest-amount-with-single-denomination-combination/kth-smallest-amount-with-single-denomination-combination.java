class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long minCoin = coins[0];
        for (int c : coins) {
            minCoin = Math.min(minCoin, c);
        }
        
        long low = 1;
        long high = minCoin * k;
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private long count(long m, int[] coins) {
        long res = 0;
        int n = coins.length;
        
        for (int i = 1; i < (1 << n); i++) {
            long lcmVal = 1;
            int setBits = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    lcmVal = lcm(lcmVal, coins[j]);
                    setBits++;
                }
            }
            
            if (setBits % 2 == 1) {
                res += m / lcmVal;
            } else {
                res -= m / lcmVal;
            }
        }
        
        return res;
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}