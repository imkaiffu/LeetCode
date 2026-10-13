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
    int prevVal = -1;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
       inorder(root);
       return min;
    }
    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        if(prevVal != -1){
            min = Math.min(min , root.val - prevVal);
        }
        prevVal = root.val;

        inorder(root.right);
    }
}