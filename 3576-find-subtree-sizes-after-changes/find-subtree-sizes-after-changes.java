class Solution {
    private List<Integer>[] origTree;
    private List<Integer>[] newTree;
    private int[] ans;
    private int[] lastNode;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        origTree = new ArrayList[n];
        newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        lastNode = new int[26];
        Arrays.fill(lastNode, -1);

        buildNewTree(0, parent);

        ans = new int[n];
        computeSubtreeSize(0);
        return ans;
    }

    private void buildNewTree(int u, int[] parent) {
        int ch = s.charAt(u) - 'a';
        int prevNode = lastNode[ch];

        if (u != 0) {
            int newParent = (prevNode != -1) ? prevNode : parent[u];
            newTree[newParent].add(u);
        }

        lastNode[ch] = u;
        for (int v : origTree[u]) {
            buildNewTree(v, parent);
        }
        lastNode[ch] = prevNode;
    }

    private int computeSubtreeSize(int u) {
        int size = 1;
        for (int v : newTree[u]) {
            size += computeSubtreeSize(v);
        }
        ans[u] = size;
        return size;
    }
}