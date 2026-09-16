class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Map.Entry<Character , Integer>> pq = new PriorityQueue<> ((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        String ans = "";
        while(!pq.isEmpty()){
            Map.Entry<Character , Integer> mp = pq.poll();
            int val = mp.getValue();
            char key = mp.getKey();
            while(val-- > 0){
                ans += key;
            }
        }
        return ans;
    }
}