class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int currentMax = 0;
        
        for (int i = 0; i < n; i++) {
            currentMax = Math.max(currentMax, nums[i]);
            prefixGcd[i] = findGcd(nums[i], currentMax);
        }
        
        Arrays.sort(prefixGcd);
        
        long totalSum = 0;
        int left = 0;
        int right = n - 1;
        
        while (left < right) {
            totalSum += findGcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        
        return totalSum;
    }
    
    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}