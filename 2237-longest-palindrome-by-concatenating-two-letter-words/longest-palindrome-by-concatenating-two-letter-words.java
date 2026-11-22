class Solution {
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];
        int length = 0;

        for (String word : words) {
            int first = word.charAt(0) - 'a';
            int second = word.charAt(1) - 'a';

            if (count[second][first] > 0) {
                length += 4;
                count[second][first]--;
            } else {
                count[first][second]++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (count[i][i] > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }
}