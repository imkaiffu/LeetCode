/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
       List<Integer> list = new ArrayList<>();
       solve(root , list);
       Collections.sort(list);
       int sum = 0;
       for(int i=0; i<list.size(); i++){
        int val = list.get(i);
        if(val > high){
            break;
        }
        if(val >= low){
            sum += val;
        }
       }
       return sum;
    }
    public void solve(TreeNode root , List<Integer> list){
        if(root == null) return;

        solve(root.left , list);
        list.add(root.val);
        solve(root.right , list);
    }
}