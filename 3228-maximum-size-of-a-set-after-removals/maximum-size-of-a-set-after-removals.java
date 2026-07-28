class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> common = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
            if (set1.contains(num)) {
                common.add(num);
            }
        }

        int n1 = set1.size();
        int n2 = set2.size();
        int c = common.size();

        int take1 = Math.min(n1 - c, n / 2);
        int take2 = Math.min(n2 - c, n / 2);

        return Math.min(take1 + take2 + c, n);
    }
}