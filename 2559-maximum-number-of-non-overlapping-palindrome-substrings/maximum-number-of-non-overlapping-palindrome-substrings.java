class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int lastIndex = -1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                
                while (left > lastIndex && right < n && s.charAt(left) == s.charAt(right)) {
                    if (right - left + 1 >= k) {
                        count++;
                        lastIndex = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
        }
        
        return count;
    }
}