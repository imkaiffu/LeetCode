class Solution {
    public int reverseDegree(String s) {
        int totalSum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int reversedAlphabetPosition = 26 - (c - 'a');
            int stringPosition = i + 1;
            totalSum += reversedAlphabetPosition * stringPosition;
        }
        return totalSum;
    }
}