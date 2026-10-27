class Solution {
    public int maxDistance(String moves) {
        int u = 0, d = 0, l = 0, r = 0, wild = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') u++;
            else if (c == 'D') d++;
            else if (c == 'L') l++;
            else if (c == 'R') r++;
            else wild++;
        }
        
        int ans = 0;
        ans = Math.max(ans, Math.abs((u + wild) - d) + Math.abs(r - l));
        ans = Math.max(ans, Math.abs(u - (d + wild)) + Math.abs(r - l));
        ans = Math.max(ans, Math.abs(u - d) + Math.abs((r + wild) - l));
        ans = Math.max(ans, Math.abs(u - d) + Math.abs(r - (l + wild)));
        
        return ans;
    }
}