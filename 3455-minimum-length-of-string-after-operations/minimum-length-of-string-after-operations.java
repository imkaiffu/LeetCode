class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        int ans = 0;
        for (int count : freq) {
            if (count > 0) {
                ans += (count % 2 == 1) ? 1 : 2;
            }
        }

        return ans;
    }
}