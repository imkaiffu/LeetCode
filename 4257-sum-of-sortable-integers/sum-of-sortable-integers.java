class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }

            boolean possible = true;
            int numBlocks = n / k;
            int prevMax = Integer.MIN_VALUE;

            for (int b = 0; b < numBlocks; b++) {
                int start = b * k;
                int minIdx = -1;

                for (int i = 0; i < k; i++) {
                    int currVal = nums[start + i];
                    int prevVal = nums[start + (i - 1 + k) % k];

                    if (currVal < prevVal) {
                        if (minIdx != -1) {
                            possible = false;
                            break;
                        }
                        minIdx = i;
                    }
                }

                if (!possible) {
                    break;
                }

                int blockMin, blockMax;
                if (minIdx == -1) {
                    blockMin = nums[start];
                    blockMax = nums[start + k - 1];
                } else {
                    blockMin = nums[start + minIdx];
                    blockMax = nums[start + (minIdx - 1 + k) % k];
                }

                if (blockMin < prevMax) {
                    possible = false;
                    break;
                }

                prevMax = blockMax;
            }

            if (possible) {
                sum += k;
            }
        }

        return sum;
    }
}