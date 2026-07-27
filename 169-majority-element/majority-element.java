class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer , Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                int val = map.get(i);
                map.put(i, val + 1);
            }else{
                map.put(i,1);
            }
            if(map.get(i) > nums.length/2){
                return i;
            }
        }
        return -1;
    }
}