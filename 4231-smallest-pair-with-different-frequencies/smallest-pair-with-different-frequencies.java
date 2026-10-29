class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> uniqueNums = new ArrayList<>(freqMap.keySet());
        Collections.sort(uniqueNums);

        int n = uniqueNums.size();
        for (int i = 0; i < n; i++) {
            int x = uniqueNums.get(i);
            int freqX = freqMap.get(x);

            for (int j = i + 1; j < n; j++) {
                int y = uniqueNums.get(j);
                int freqY = freqMap.get(y);

                if (freqX != freqY) {
                    return new int[]{x, y};
                }
            }
        }

        return new int[]{-1, -1};
    }
}