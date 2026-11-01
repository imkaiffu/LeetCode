class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }

            int slow = i;
            int fast = i;

            while (nums[slow] * nums[getNext(nums, fast)] > 0 
                   && nums[slow] * nums[getNext(nums, getNext(nums, fast))] > 0) {
                slow = getNext(nums, slow);
                fast = getNext(nums, getNext(nums, fast));

                if (slow == fast) {
                    if (slow == getNext(nums, slow)) {
                        break;
                    }
                    return true;
                }
            }

            int curr = i;
            int val = nums[i];
            while (nums[curr] * val > 0) {
                int next = getNext(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }

    private int getNext(int[] nums, int index) {
        int n = nums.length;
        int next = (index + nums[index]) % n;
        if (next < 0) {
            next += n;
        }
        return next;
    }
}