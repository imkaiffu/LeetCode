class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int totalOnes = 0;
        int maxZeroSum = 0;
        int prevZero = -1;
        int currZero = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                totalOnes++;
                if (currZero > 0) {
                    if (prevZero != -1) {
                        maxZeroSum = Math.max(maxZeroSum, prevZero + currZero);
                    }
                    prevZero = currZero;
                    currZero = 0;
                }
            } else {
                currZero++;
            }
        }

        if (currZero > 0 && prevZero != -1) {
            maxZeroSum = Math.max(maxZeroSum, prevZero + currZero);
        }

        return totalOnes + maxZeroSum;
    }
}