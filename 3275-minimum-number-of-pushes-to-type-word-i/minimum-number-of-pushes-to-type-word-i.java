class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;
        int multiplier = 1;

        while (n > 0) {
            if (n >= 8) {
                pushes += 8 * multiplier;
                n -= 8;
            } else {
                pushes += n * multiplier;
                n = 0;
            }
            multiplier++;
        }

        return pushes;
    }
}