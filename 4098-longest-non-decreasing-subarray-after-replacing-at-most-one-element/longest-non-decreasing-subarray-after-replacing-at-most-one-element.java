class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, left[i]);
        }

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                maxLen = Math.max(maxLen, left[i - 1] + 1);
            }
            if (i < n - 1) {
                maxLen = Math.max(maxLen, right[i + 1] + 1);
            }
            if (i > 0 && i < n - 1) {
                if (nums[i - 1] <= nums[i + 1]) {
                    maxLen = Math.max(maxLen, left[i - 1] + 1 + right[i + 1]);
                }
            }
        }

        return maxLen;
    }
}