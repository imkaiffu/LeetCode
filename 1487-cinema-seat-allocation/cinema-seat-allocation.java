class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> occupied = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (col >= 2 && col <= 9) {
                occupied.put(row, occupied.getOrDefault(row, 0) | (1 << col));
            }
        }

        int leftMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middleMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int rightMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        int maxFamilies = (n - occupied.size()) * 2;

        for (int mask : occupied.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean right = (mask & rightMask) == 0;
            boolean middle = (mask & middleMask) == 0;

            if (left && right) {
                maxFamilies += 2;
            } else if (left || right || middle) {
                maxFamilies += 1;
            }
        }

        return maxFamilies;
    }
}