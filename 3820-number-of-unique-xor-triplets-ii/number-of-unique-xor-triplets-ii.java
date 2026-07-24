class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }

        int limit = 1;
        while (limit <= maxVal) {
            limit <<= 1;
        }

        boolean[] present = new boolean[limit];
        int uniqueCount = 0;
        for (int num : nums) {
            if (!present[num]) {
                present[num] = true;
                uniqueCount++;
            }
        }

        int[] u = new int[uniqueCount];
        int idx = 0;
        for (int i = 0; i < limit; i++) {
            if (present[i]) {
                u[idx++] = i;
            }
        }

        boolean[] has2 = new boolean[limit];
        for (int i = 0; i < uniqueCount; i++) {
            for (int j = i; j < uniqueCount; j++) {
                has2[u[i] ^ u[j]] = true;
            }
        }

        boolean[] has3 = new boolean[limit];
        for (int i = 0; i < uniqueCount; i++) {
            int val1 = u[i];
            for (int j = 0; j < limit; j++) {
                if (has2[j]) {
                    has3[val1 ^ j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < limit; i++) {
            if (has3[i]) {
                count++;
            }
        }

        return count;
    }
}