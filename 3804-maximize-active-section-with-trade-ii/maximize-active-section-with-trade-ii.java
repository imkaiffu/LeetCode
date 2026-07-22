class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int totalOnes = 0;
        int n = s.length();
        List<int[]> blocks = new ArrayList<>();
        
        for (int i = 0; i < n; ) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                i++;
            } else {
                int start = i;
                while (i < n && s.charAt(i) == '0') {
                    i++;
                }
                blocks.add(new int[]{start, i - 1, i - start});
            }
        }

        SparseTable st = null;
        if (blocks.size() > 1) {
            int[] V = new int[blocks.size() - 1];
            for (int i = 0; i < V.length; i++) {
                V[i] = blocks.get(i)[2] + blocks.get(i + 1)[2];
            }
            st = new SparseTable(V);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            
            int x = findFirst(blocks, l);
            int y = findLast(blocks, r);

            if (x == -1 || y == -1 || x > y || x == y) {
                ans.add(totalOnes);
                continue;
            }

            int lFirst = Math.min(r, blocks.get(x)[1]) - Math.max(l, blocks.get(x)[0]) + 1;
            int lLast = Math.min(r, blocks.get(y)[1]) - Math.max(l, blocks.get(y)[0]) + 1;

            int maxGain = 0;
            if (x + 1 == y) {
                maxGain = lFirst + lLast;
            } else {
                maxGain = Math.max(lFirst + blocks.get(x + 1)[2], blocks.get(y - 1)[2] + lLast);
                if (x + 1 <= y - 2 && st != null) {
                    maxGain = Math.max(maxGain, st.query(x + 1, y - 2));
                }
            }
            ans.add(totalOnes + maxGain);
        }
        return ans;
    }

    private int findFirst(List<int[]> blocks, int val) {
        int low = 0;
        int high = blocks.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (blocks.get(mid)[1] >= val) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private int findLast(List<int[]> blocks, int val) {
        int low = 0;
        int high = blocks.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (blocks.get(mid)[0] <= val) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    class SparseTable {
        int[][] st;
        int[] log;

        public SparseTable(int[] arr) {
            int n = arr.length;
            if (n == 0) {
                return;
            }
            log = new int[n + 1];
            for (int i = 2; i <= n; i++) {
                log[i] = log[i / 2] + 1;
            }
            int k = log[n] + 1;
            st = new int[k][n];
            for (int i = 0; i < n; i++) {
                st[0][i] = arr[i];
            }
            for (int j = 1; j < k; j++) {
                for (int i = 0; i + (1 << j) <= n; i++) {
                    st[j][i] = Math.max(st[j - 1][i], st[j - 1][i + (1 << (j - 1))]);
                }
            }
        }

        public int query(int l, int r) {
            if (l > r) {
                return 0;
            }
            int j = log[r - l + 1];
            return Math.max(st[j][l], st[j][r - (1 << j) + 1]);
        }
    }
}