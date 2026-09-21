class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0 ,0 , nums, target);
    }

    public int solve(int i, int sum, int[] nums, int target) {
        if (i == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int p = solve(i + 1, sum + nums[i], nums, target);
        int m = solve(i + 1, sum - nums[i], nums, target);
        return p + m;
    }
}