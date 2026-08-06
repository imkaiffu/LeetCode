class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : arr1){
            map.put(num , map.getOrDefault(num, 0)+1);
        }
        Arrays.sort(arr1);
        int ans[] = new int[arr1.length];
        int i=0;
        for(int num: arr2){
            if(map.containsKey(num)){
                int count = map.get(num);
                while(count > 0){
                    ans[i++] = num;
                    count--;
                }
                map.remove(num);
            }
        }
        for(int num: arr1){
            if(map.containsKey(num)){
                int count = map.get(num);
                while(count > 0){
                    ans[i++] = num;
                    count--;
                }
                map.remove(num);
            }
        }
   
        return ans;
    }
}