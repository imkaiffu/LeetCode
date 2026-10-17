class Solution {
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        class Element implements Comparable<Element> {
            int val, sum, index;
            Element(int val, int sum, int index) {
                this.val = val;
                this.sum = sum;
                this.index = index;
            }
            
            public int compareTo(Element other) {
                if (this.sum != other.sum) {
                    return Integer.compare(this.sum, other.sum);
                }
                return Integer.compare(this.val, other.val);
            }
        }

        Element[] arr = new Element[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Element(nums[i], getDigitSum(nums[i]), i);
        }

        java.util.Arrays.sort(arr);

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || arr[i].index == i) {
                continue;
            }

            int cycleSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = arr[j].index;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }
}