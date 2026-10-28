class Solution {
   public static final int MOD = 1000000007;

    public int countVisiblePeople(int n, int pos, int k) {
        int l = pos;
        int r = n - pos - 1;
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[n] = power(fact[n], MOD - 2);
        for (int i = n - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }

        long ways = 0;
        int minA = Math.max(0, k - r);
        int maxA = Math.min(k, l);

        for (int a = minA; a <= maxA; a++) {
            int b = k - a;
            long combL = comb(l, a, fact, invFact);
            long combR = comb(r, b, fact, invFact);
            long term = (combL * combR) % MOD;
            ways = (ways + term) % MOD;
        }

        return (int) ((ways * 2) % MOD);
    }

    public long comb(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    public long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}