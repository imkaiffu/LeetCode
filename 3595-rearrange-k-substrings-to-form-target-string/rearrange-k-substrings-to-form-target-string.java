class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        if (n % k != 0) {
            return false;
        }
        int len = n / k;
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i += len) {
            String sub = s.substring(i, i + len);
            count.put(sub, count.getOrDefault(sub, 0) + 1);
        }
        for (int i = 0; i < n; i += len) {
            String sub = t.substring(i, i + len);
            int freq = count.getOrDefault(sub, 0);
            if (freq == 0) {
                return false;
            }
            count.put(sub, freq - 1);
        }
        return true;
    }
}