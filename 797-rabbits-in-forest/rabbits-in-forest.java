class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }
        
        int totalRabbits = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int x = entry.getKey();
            int count = entry.getValue();
            int groupSize = x + 1;
            int groups = (count + x) / groupSize;
            totalRabbits += groups * groupSize;
        }
        
        return totalRabbits;
    }
}