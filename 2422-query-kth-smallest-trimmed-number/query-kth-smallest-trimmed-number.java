class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        int numLen = nums[0].length();

        for (int i = 0; i < n; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];

            Pair[] trimmed = new Pair[nums.length];
            for (int j = 0; j < nums.length; j++) {
                String sub = nums[j].substring(numLen - trim);
                trimmed[j] = new Pair(sub, j);
            }

            Arrays.sort(trimmed, (a, b) -> {
                int cmp = a.val.compareTo(b.val);
                if (cmp != 0) {
                    return cmp;
                }
                return Integer.compare(a.index, b.index);
            });

            answer[i] = trimmed[k - 1].index;
        }

        return answer;
    }

    private static class Pair {
        String val;
        int index;

        Pair(String val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}