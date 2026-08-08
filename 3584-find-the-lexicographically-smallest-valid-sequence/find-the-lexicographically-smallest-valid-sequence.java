class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[] last = new int[m];
        int ptr = n - 1;
        
        for (int j = m - 1; j >= 0; j--) {
            while (ptr >= 0 && word1.charAt(ptr) != word2.charAt(j)) {
                ptr--;
            }
            last[j] = ptr;
            if (ptr >= 0) {
                ptr--;
            }
        }

        int[] ans = new int[m];
        boolean changed = false;
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                if (changed) {
                    if (j == m - 1 || i < last[j + 1]) {
                        ans[j] = i;
                        j++;
                    }
                } else {
                    ans[j] = i;
                    j++;
                }
            } else {
                if (!changed && (j == m - 1 || i < last[j + 1])) {
                    ans[j] = i;
                    changed = true;
                    j++;
                }
            }
            i++;
        }

        return j == m ? ans : new int[0];
    }
}