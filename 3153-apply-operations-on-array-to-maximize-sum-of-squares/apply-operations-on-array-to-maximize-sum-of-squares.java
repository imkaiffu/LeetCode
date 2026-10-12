class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] bitCount = new int[31];
        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }
        long answer = 0;
        long mod = 1_000_000_007;
        for (int i = 0; i < k; i++) {
            int current = 0;
            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    current |= (1 << bit);
                    bitCount[bit]--;
                }
            }
            answer = (answer + (long) current * current) % mod;
        }
        return (int) answer;
    }
}