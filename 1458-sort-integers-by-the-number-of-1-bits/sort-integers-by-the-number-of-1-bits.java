class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(boxed, (a, b) -> {
            int bitCountA = Integer.bitCount(a);
            int bitCountB = Integer.bitCount(b);
            if (bitCountA != bitCountB) {
                return Integer.compare(bitCountA, bitCountB);
            }
            return Integer.compare(a, b);
        });
        return Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
    }
}