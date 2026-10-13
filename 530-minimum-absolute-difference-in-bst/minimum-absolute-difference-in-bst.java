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
    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<list.size(); i++){
            min = Math.min(min ,(list.get(i) - list.get(i-1)));
        }
        return min;
    }
    public void solve(TreeNode root , ArrayList<Integer> list){
        if(root == null) return;

        solve(root.left , list);
        list.add(root.val);
        solve(root.right , list);

    }
}