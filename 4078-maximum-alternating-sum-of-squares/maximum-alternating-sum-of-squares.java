class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long temp[] = new long[n];
        for(int i=0; i<n; i++){
            temp[i] = nums[i]*nums[i];
        }
        Arrays.sort(temp);

        long total = 0;
        int right = 0;
        int left = n-1;
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                total += temp[left--];
            }else{
                total -= temp[right++];
            }
        }
        return total;
    }
}