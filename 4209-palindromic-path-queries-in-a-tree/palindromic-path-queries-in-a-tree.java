class Solution {
    private int[] parent;
    private int[] depth;
    private int[] heavy;
    private int[] head;
    private int[] pos;
    private int[] val;
    private int curPos;
    private int[] tree;
    private int N;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        parent = new int[n];
        depth = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        val = new int[n];
        Arrays.fill(heavy, -1);

        dfs1(0, -1, 0, adj);

        curPos = 0;
        dfs2(0, 0, adj);

        for (int i = 0; i < n; i++) {
            val[pos[i]] = 1 << (s.charAt(i) - 'a');
        }

        N = n;
        tree = new int[4 * N];
        buildTree(1, 0, N - 1);

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                int mask = 1 << (c - 'a');
                updateTree(1, 0, N - 1, pos[u], mask);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = queryPath(u, v);
                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }

    private int dfs1(int v, int p, int d, List<List<Integer>> adj) {
        parent[v] = p;
        depth[v] = d;
        int size = 1;
        int maxSubtree = 0;
        for (int neighbor : adj.get(v)) {
            if (neighbor != p) {
                int subSize = dfs1(neighbor, v, d + 1, adj);
                size += subSize;
                if (subSize > maxSubtree) {
                    maxSubtree = subSize;
                    heavy[v] = neighbor;
                }
            }
        }
        return size;
    }

    private void dfs2(int v, int h, List<List<Integer>> adj) {
        head[v] = h;
        pos[v] = curPos++;
        if (heavy[v] != -1) {
            dfs2(heavy[v], h, adj);
        }
        for (int neighbor : adj.get(v)) {
            if (neighbor != parent[v] && neighbor != heavy[v]) {
                dfs2(neighbor, neighbor, adj);
            }
        }
    }

    private void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = val[start];
            return;
        }
        int mid = (start + end) / 2;
        buildTree(2 * node, start, mid);
        buildTree(2 * node + 1, mid + 1, end);
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private void updateTree(int node, int start, int end, int idx, int mask) {
        if (start == end) {
            tree[node] = mask;
            return;
        }
        int mid = (start + end) / 2;
        if (idx <= mid) {
            updateTree(2 * node, start, mid, idx, mask);
        } else {
            updateTree(2 * node + 1, mid + 1, end, idx, mask);
        }
        tree[node] = tree[2 * node] ^ tree[2 * node + 1];
    }

    private int queryTree(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return queryTree(2 * node, start, mid, l, r) ^ queryTree(2 * node + 1, mid + 1, end, l, r);
    }

    private int queryPath(int u, int v) {
        int res = 0;
        while (head[u] != head[v]) {
            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }
            res ^= queryTree(1, 0, N - 1, pos[head[u]], pos[u]);
            u = parent[head[u]];
        }
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        res ^= queryTree(1, 0, N - 1, pos[u], pos[v]);
        return res;
    }
}