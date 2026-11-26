class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        long[][] nextDist = new long[26][26];
        long[][] prevDist = new long[26][26];

        for (int start = 0; start < 26; start++) {
            long cost = 0;
            int cur = start;
            for (int step = 1; step < 26; step++) {
                cost += nextCost[cur];
                cur = (cur + 1) % 26;
                nextDist[start][cur] = cost;
            }
        }

        for (int start = 0; start < 26; start++) {
            long cost = 0;
            int cur = start;
            for (int step = 1; step < 26; step++) {
                cost += previousCost[cur];
                cur = (cur - 1 + 26) % 26;
                prevDist[start][cur] = cost;
            }
        }

        long total = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            int v = t.charAt(i) - 'a';
            if (u != v) {
                total += Math.min(nextDist[u][v], prevDist[u][v]);
            }
        }

        return total;
    }
}