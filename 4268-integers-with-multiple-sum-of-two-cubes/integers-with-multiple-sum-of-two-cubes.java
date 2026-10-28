class Solution {
    public static final List<Integer> GOOD = new ArrayList<>();

    static {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a = 1; a <= 1000; a++) {
            long a3 = (long) a * a * a;
            for (int b = a; b <= 1000; b++) {
                long b3 = (long) b * b * b;
                long sum = a3 + b3;
                if (sum > 1000000000L) {
                    break;
                }
                cnt.put((int) sum, cnt.getOrDefault((int) sum, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > 1) {
                GOOD.add(entry.getKey());
            }
        }
        Collections.sort(GOOD);
    }

    public List<Integer> findGoodIntegers(int n) {
        int idx = Collections.binarySearch(GOOD, n + 1);
        if (idx < 0) {
            idx = -idx - 1;
        }
        return GOOD.subList(0, idx);
    }
}