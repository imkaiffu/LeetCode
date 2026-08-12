class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] count = new int[100001];
        long k = (long) k1 + k2;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            count[diff]++;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }

        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] > 0) {
                long take = Math.min(k, (long) count[i]);
                count[i] -= take;
                count[i - 1] += take;
                k -= take;
            }
        }

        long result = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                result += (long) count[i] * (long) i * i;
            }
        }

        return result;
    }
}