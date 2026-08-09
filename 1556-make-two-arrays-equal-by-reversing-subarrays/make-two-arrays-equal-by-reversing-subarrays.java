class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer , Integer> map = new HashMap<>();
        Map<Integer , Integer> map1 = new HashMap<>();
        for(int x: arr){
            map.put(x, map.getOrDefault(x , 0)+1);
        }
        for(int x: target){
           map1.put(x, map1.getOrDefault(x , 0)+1);
        }
        if(map.equals(map1)){
            return true;
        }else{
            return false;
        }
    }
}