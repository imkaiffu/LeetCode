class Solution {
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo + 1;
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            int num = lo + i;
            pairs[i][0] = num;
            pairs[i][1] = getPower(num);
        }
        
        Arrays.sort(pairs, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        return pairs[k - 1][0];
    }

    private int getPower(int n) {
        int steps = 0;
        long val = n;
        while (val != 1) {
            if (val % 2 == 0) {
                val /= 2;
            } else {
                val = 3 * val + 1;
            }
            steps++;
        }
        return steps;
    }
}