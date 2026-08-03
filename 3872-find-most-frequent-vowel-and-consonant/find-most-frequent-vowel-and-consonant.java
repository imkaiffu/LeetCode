class Solution {
    public int maxFreqSum(String s) {
        Map<Character , Integer> map = new HashMap<>();
        int MaxCon = 0;
        int MaxVow = 0;
        int n = s.length();
        for(int i=0; i<n; i++){
            char ch =  s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ){
                MaxVow = Math.max(map.get(ch) , MaxVow);
            }else{
                MaxCon = Math.max(map.get(ch) , MaxCon);
            }
        }
        return MaxCon + MaxVow ;
    }
}