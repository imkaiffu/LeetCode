class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int x: nums){
            if(!set.contains(x)){
                set.add(x);
            }else{
                return x;
            }
        }
        return -1;
    }
}