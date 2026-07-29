class Solution {
    public String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;

        int[] count = new int[26];
        for (int i = 0; i < halfLen; i++) {
            count[s.charAt(i) - 'a']++;
        }

        long[][] comb = new long[halfLen + 1][halfLen + 1];
        for (int i = 0; i <= halfLen; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                comb[i][j] = Math.min((long) 1e18, comb[i - 1][j - 1] + comb[i - 1][j]);
            }
        }

        long totalPermutations = getPermutations(count, halfLen, comb);
        if (k > totalPermutations) {
            return "";
        }

        StringBuilder half = new StringBuilder();
        int remainingLen = halfLen;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (count[c] > 0) {
                    count[c]--;
                    long ways = getPermutations(count, remainingLen - 1, comb);
                    if (k <= ways) {
                        half.append((char) ('a' + c));
                        remainingLen--;
                        break;
                    } else {
                        k -= ways;
                        count[c]++;
                    }
                }
            }
        }

        String firstHalf = half.toString();
        StringBuilder result = new StringBuilder(firstHalf);
        if (n % 2 != 0) {
            result.append(s.charAt(halfLen));
        }
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }

    private long getPermutations(int[] count, int len, long[][] comb) {
        long res = 1;
        int currentLen = len;
        for (int c = 0; c < 26; c++) {
            if (count[c] > 0) {
                res = multSat(res, comb[currentLen][count[c]]);
                currentLen -= count[c];
            }
        }
        return res;
    }

    private long multSat(long a, long b) {
        if (a == 0 || b == 0) return 0;
        if (a > 1e18 / b) return (long) 1e18;
        return a * b;
    }
}