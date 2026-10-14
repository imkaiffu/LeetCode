class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9 || sum < 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int remainingSum = sum;
        
        for (int i = 0; i < num; i++) {

            int remainingSlots = num - 1 - i;
            
            for (int d = 9; d >= 0; d--) {
                if (remainingSum - d <= remainingSlots * 9 && remainingSum - d >= 0) {
                    sb.append(d);
                    remainingSum -= d;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}