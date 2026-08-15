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
    int dia=0;
    public int level(TreeNode root){
        if(root==null)return 0;

        int left=level(root.left);
        int right=level(root.right);

        int level=Math.max(left,right)+1;
        dia=Math.max(dia,left+right);
        return level;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        level(root);
        return dia;
    }
}