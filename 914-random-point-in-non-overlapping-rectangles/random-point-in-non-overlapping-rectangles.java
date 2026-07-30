class Solution {
    private int[][] rects;
    private TreeMap<Integer, Integer> map;
    private int totalPoints;
    private Random random;

    public Solution(int[][] rects) {
        this.rects = rects;
        this.map = new TreeMap<>();
        this.totalPoints = 0;
        this.random = new Random();

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int numPoints = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            totalPoints += numPoints;
            map.put(totalPoints, i);
        }
    }

    public int[] pick() {
        int target = random.nextInt(totalPoints) + 1;
        int rectIndex = map.ceilingEntry(target).getValue();
        int[] rect = rects[rectIndex];

        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */