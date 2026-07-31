class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<Character, String> map = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            char ch = pattern.charAt(i);
            String str = arr[i];
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(str)){
                    return false;
                }
            }else{
                if(map.containsValue(str)){
                    return false;
                }else{
                    map.put(ch, str);
                }
            }
        }
        return true;
    }
}