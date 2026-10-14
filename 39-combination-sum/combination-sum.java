class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0 , candidates , target , temp , ans);
        return ans;
    }
    public void solve(int i, int []arr, int t , List<Integer> temp, List<List<Integer>> ans ){
        if(i == arr.length) return;
        if(t<0) return;
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(arr[i]);
        solve(i , arr, t-arr[i] , temp , ans);
        temp.remove(temp.size()-1);
        solve(i+1 , arr , t, temp , ans);
    }
}