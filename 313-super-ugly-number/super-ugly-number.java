class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int k = primes.length;
        int[] pointers = new int[k];
        
        for (int i = 1; i < n; i++) {
            long nextMin = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                long val = (long) ugly[pointers[j]] * primes[j];
                nextMin = Math.min(nextMin, val);
            }
            ugly[i] = (int) nextMin;
            
            for (int j = 0; j < k; j++) {
                if ((long) ugly[pointers[j]] * primes[j] == nextMin) {
                    pointers[j]++;
                }
            }
        }
        
        return ugly[n - 1];
    }
}