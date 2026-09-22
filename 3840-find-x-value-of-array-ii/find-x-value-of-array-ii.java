class Solution {
    static class Node {
        int prod;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }

    private int k;
    private Node[] tree;

    private void merge(Node parent, Node left, Node right) {
        parent.prod = (left.prod * right.prod) % k;
        for (int i = 0; i < k; i++) {
            parent.count[i] = left.count[i];
        }
        for (int r = 0; r < k; r++) {
            int target = (left.prod * r) % k;
            parent.count[target] += right.count[r];
        }
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) {
            int val = nums[l] % k;
            tree[node].prod = val;
            tree[node].count[val] = 1;
            return;
        }
        int mid = (l + r) / 2;
        build(2 * node, l, mid, nums);
        build(2 * node + 1, mid + 1, r, nums);
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            for (int i = 0; i < k; i++) {
                tree[node].count[i] = 0;
            }
            int v = val % k;
            tree[node].prod = v;
            tree[node].count[v] = 1;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid) {
            update(2 * node, l, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, r, idx, val);
        }
        merge(tree[node], tree[2 * node], tree[2 * node + 1]);
    }

    private Node query(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return tree[node];
        }
        int mid = (l + r) / 2;
        if (qr <= mid) {
            return query(2 * node, l, mid, ql, qr);
        }
        if (ql > mid) {
            return query(2 * node + 1, mid + 1, r, ql, qr);
        }
        Node leftRes = query(2 * node, l, mid, ql, qr);
        Node rightRes = query(2 * node + 1, mid + 1, r, ql, qr);
        Node res = new Node(k);
        merge(res, leftRes, rightRes);
        return res;
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            tree[i] = new Node(k);
        }
        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int val = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            update(1, 0, n - 1, idx, val);
            Node res = query(1, 0, n - 1, start, n - 1);
            ans[i] = res.count[x];
        }
        return ans;
    }
}