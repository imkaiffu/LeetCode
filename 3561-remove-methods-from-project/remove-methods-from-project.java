class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] inv : invocations) {
            adj.get(inv[0]).add(inv[1]);
        }

        boolean[] suspicious = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        suspicious[k] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj.get(curr)) {
                if (!suspicious[next]) {
                    suspicious[next] = true;
                    queue.offer(next);
                }
            }
        }

        boolean canRemove = true;
        for (int[] inv : invocations) {
            if (!suspicious[inv[0]] && suspicious[inv[1]]) {
                canRemove = false;
                break;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!canRemove || !suspicious[i]) {
                result.add(i);
            }
        }

        return result;
    }
}