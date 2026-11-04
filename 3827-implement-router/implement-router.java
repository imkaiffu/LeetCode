class Router {
    private final int memoryLimit;
    private final ArrayDeque<int[]> queue = new ArrayDeque<>();
    private final HashSet<String> seen = new HashSet<>();
    private final HashMap<Integer, Entry> byDestination = new HashMap<>();

    private static class Entry {
        ArrayList<Integer> times = new ArrayList<>();
        int head = 0;
    }

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "#" + destination + "#" + timestamp;
        if (seen.contains(key)) {
            return false;
        }

        if (queue.size() == memoryLimit) {
            forwardPacket();
        }

        queue.offer(new int[]{source, destination, timestamp});
        seen.add(key);
        byDestination.computeIfAbsent(destination, d -> new Entry()).times.add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (queue.isEmpty()) {
            return new int[0];
        }

        int[] p = queue.poll();
        seen.remove(p[0] + "#" + p[1] + "#" + p[2]);
        byDestination.get(p[1]).head++;
        return p;
    }

    public int getCount(int destination, int startTime, int endTime) {
        Entry e = byDestination.get(destination);
        if (e == null) {
            return 0;
        }

        int lo = lowerBound(e.times, e.head, startTime);
        int hi = lowerBound(e.times, e.head, endTime + 1);
        return hi - lo;
    }

    private int lowerBound(ArrayList<Integer> list, int from, int target) {
        int l = from;
        int r = list.size();
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */