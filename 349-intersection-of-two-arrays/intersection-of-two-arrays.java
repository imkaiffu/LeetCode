class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1){
            set.add(num);
        }
        Set<Integer> insert = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num)){
                insert.add(num);
            }
        }
        int []ans = new int[insert.size()];
        int i=0;
        for(int num : insert){
            ans[i++]= num;
        }
        return ans;
    }
}