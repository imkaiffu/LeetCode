class Solution {
    public int primePalindrome(int n) {
        if (8 <= n && n <= 11) {
            return 11;
        }

        for (int i = 1; i < 100000; i++) {
            String s = Integer.toString(i);
            String r = new StringBuilder(s).reverse().toString();
            int val = Integer.parseInt(s + r.substring(1));

            if (val >= n && isPrime(val)) {
                return val;
            }
        }

        return -1;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}