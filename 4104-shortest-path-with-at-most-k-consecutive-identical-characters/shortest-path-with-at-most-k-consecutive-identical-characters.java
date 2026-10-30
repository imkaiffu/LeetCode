class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        char[] lab = labels.toCharArray();
        long INF = Long.MAX_VALUE / 2;
        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) {
            Arrays.fill(row, INF);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0][1] = 0;
        pq.add(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            int count = (int) cur[2];

            if (d > dist[u][count]) {
                continue;
            }
            if (u == n - 1) {
                return (int) d;
            }

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int nextCount = lab[v] == lab[u] ? count + 1 : 1;
                if (nextCount <= k && d + w < dist[v][nextCount]) {
                    dist[v][nextCount] = d + w;
                    pq.add(new long[]{d + w, v, nextCount});
                }
            }
        }

        return -1;
    }
}