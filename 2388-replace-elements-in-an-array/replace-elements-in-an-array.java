class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] op : operations) {
            int oldVal = op[0];
            int newVal = op[1];
            int idx = map.get(oldVal);
            nums[idx] = newVal;
            map.put(newVal, idx);
            map.remove(oldVal);
        }

        return nums;
    }
}