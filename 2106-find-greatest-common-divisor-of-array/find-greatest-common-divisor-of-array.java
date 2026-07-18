class Solution {
    public int findGCD(int[] nums) {
        int n = nums.length;
        int min = 9999999;
        int max = 0;
        for(int i=0; i<n; i++){
            if(nums[i]<min){
                min = nums[i];
            }
            if(max < nums[i]){
                max = nums[i];
            }
        }
        int ans = 1;
        for(int i=1; i<=min; i++){
            if(min % i ==0 && max % i ==0){
                ans= i;
            }
        }
        return ans;
    }
}