class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long total = (long) (n + 1) * n / 2;
        if (Math.abs(target) > total || (target - total) % 2 != 0) {
            return new int[0];
        }
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n; i >= 1; i--) {
            long rem = (long) i * (i - 1) / 2;
            if (target - (-i) <= rem) {
                target -= -i;
                result[left++] = -i;
            } else {
                target -= i;
                result[right--] = i;
            }
        }
        return result;
    }
}