class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            long currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                if (isValid(currentSum, x)) {
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private boolean isValid(long sum, int x) {
        if (sum == 0) {
            return x == 0;
        }
        long lastDigit = Math.abs(sum % 10);
        long firstDigit = Math.abs(sum);
        while (firstDigit >= 10) {
            firstDigit /= 10;
        }
        return firstDigit == x && lastDigit == x;
    }
}