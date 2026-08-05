class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i=0, j=0;
        List<Integer> list = new ArrayList<>();

        while(i<n && j<m){
            if(nums1[i]< nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int ans[] = new int[list.size()];
        int k=0;
        for(int num : list){
            ans[k++]= num;
        }
        return ans;
    }
}