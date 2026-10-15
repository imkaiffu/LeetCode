class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sum = 0;
        for(int i=0; i<n; i++){
            Set<Integer> subArr = new HashSet<>();

            for(int j=i; j<n; j++){

                subArr.add(nums.get(j));

                int count = subArr.size();
                sum += count * count;

            }
        }
        return sum;
        
    }
}