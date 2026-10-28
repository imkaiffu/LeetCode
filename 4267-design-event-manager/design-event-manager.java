class EventManager {
    public HashMap<Integer, Integer> map;
    public TreeSet<int[]> set;

    public EventManager(int[][] events) {
        map = new HashMap<>();
        set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        for (int[] e : events) {
            map.put(e[0], e[1]);
            set.add(new int[]{e[1], e[0]});
        }
    }
    
    public void updatePriority(int eventId, int newPriority) {
        if (!map.containsKey(eventId)) {
            return;
        }
        int oldPriority = map.get(eventId);
        set.remove(new int[]{oldPriority, eventId});
        map.put(eventId, newPriority);
        set.add(new int[]{newPriority, eventId});
    }
    
    public int pollHighest() {
        if (set.isEmpty()) {
            return -1;
        }
        int[] curr = set.pollFirst();
        int eventId = curr[1];
        map.remove(eventId);
        return eventId;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */