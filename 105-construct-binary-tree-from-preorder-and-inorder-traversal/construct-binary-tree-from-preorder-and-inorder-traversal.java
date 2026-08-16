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
    HashMap<Integer,Integer> map=new HashMap<>();
    int preIndex=0;
    public TreeNode solve(int[] preorder, int[] inorder,int l,int r){
        if(l>r)return null;
        int count=map.get(preorder[preIndex]);
        TreeNode node=new TreeNode(preorder[preIndex++]);

        node.left=solve(preorder,inorder,l,count-1);
        node.right=solve(preorder,inorder,count+1,r);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return solve(preorder,inorder,0,inorder.length-1);
    }
}