class Solution {
    private List<Integer>[] g;
    private int[] baseTime;

    public long finishTime(int n, int[][] edges, int[] baseTime) {
        this.baseTime = baseTime;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            g[e[0]].add(e[1]);
        }
        return dfs(0);
    }

    private long dfs(int u) {
        if (g[u].isEmpty()) {
            return baseTime[u];
        }
        long earliest = Long.MAX_VALUE;
        long latest = Long.MIN_VALUE;
        for (int v : g[u]) {
            long t = dfs(v);
            earliest = Math.min(earliest, t);
            latest = Math.max(latest, t);
        }
        return 2 * latest - earliest + baseTime[u];
    }
}