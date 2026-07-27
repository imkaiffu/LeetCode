class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> map  = new HashMap<>();
        
        for(int i: nums){
            if(map.containsKey(i)){
                int val = map.get(i);
                map.put(i , val + 1);
            }else{
                map.put(i , 1);
            }
        }
        for(int k: map.keySet()){
            if(map.get(k) > nums.length / 3){
                list.add(k);
            }
        }
        return list;
    }
}