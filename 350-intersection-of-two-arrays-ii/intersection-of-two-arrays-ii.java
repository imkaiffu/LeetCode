class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num: nums1){
            map.put(num , map.getOrDefault(num , 0)+1);
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums2){
            int count = map.getOrDefault(num , 0);
            if(count > 0){
                list.add(num);
                map.put(num , count-1);
            }
        }
        int ans[] = new int[list.size()];
        int i=0;
        for(int num : list){
            ans[i++]= num;
        }
        return ans;
    }
}