class Solution {
    public int mirrorFrequency(String s) {
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        
        boolean[] visited = new boolean[128];
        int total = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c]) {
                continue;
            }
            char m;
            if (c >= 'a' && c <= 'z') {
                m = (char) ('z' - (c - 'a'));
            } else {
                m = (char) ('9' - (c - '0'));
            }
            visited[c] = true;
            visited[m] = true;
            total += Math.abs(freq[c] - freq[m]);
        }
        
        return total;
    }
}