class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        long[] last = new long[26];
        long currentCount = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newCount = (2 * currentCount + 1 - last[idx] + MOD) % MOD;
            last[idx] = (currentCount + 1) % MOD;
            currentCount = newCount;
        }

        return (int) currentCount;
    }
}