class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0; i<n-2; i++){
            int st = i+1;
            int end = n-1;
            while(st < end){
                int sum = nums[i] + nums[st] + nums[end];
                if(sum == 0){
                    result.add(Arrays.asList(nums[i],nums[st],nums[end]));
                    st++;
                    end--;
                }else if(sum > 0){
                    end--;
                }else{
                    st++;
                }
            }
        }
        return new ArrayList<>(result);
        
    }
}