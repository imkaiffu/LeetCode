class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       List<Integer> list = new ArrayList<>();
       Arrays.sort(nums);
       int n= nums.length;
       for(int i=0; i<n-1; i++){
        int miss = nums[i] + 1;
        while(miss < nums[i+1]){
            list.add(miss);
            miss++;
        }
       }
       return list; 
    }
}