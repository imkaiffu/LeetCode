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
    public boolean hasPathSum(TreeNode root, int targetSum) {
       return solve(root , targetSum);
    }
    public boolean solve(TreeNode root , int target){
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return target == root.val;
        }
        int RemainingSum = target - root.val;
        boolean Total = solve(root.left , RemainingSum) || solve(root.right , RemainingSum);
        return Total;
    }
}