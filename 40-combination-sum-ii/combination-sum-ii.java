class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> ans = new HashSet<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(0, candidates, target, ans, temp);
        return new ArrayList<>(ans);
    }
    void solve(int st, int[] arr, int t, HashSet<List<Integer>> ans , ArrayList<Integer> temp){
        if(t == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(t < 0){
            return;
        }
        for(int i = st; i<arr.length; i++){
            if(i>st && arr[i] == arr[i-1]) continue;
            temp.add(arr[i]);
            solve(i+1, arr, t - arr[i], ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}