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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
       return result;
    }
    
    private int maxPathSumUtil(TreeNode root){
         if(root == null){
            return 0;
        }
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        int maxSofar = Math.max(Math.max(left,right)+root.val,root.val);
        int maxCase  = Math.max(maxSofar, left+right+root.val);
        result = Math.max(result,maxCase);
        return maxSofar;
    }
}
