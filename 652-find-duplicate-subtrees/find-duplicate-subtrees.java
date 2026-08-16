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
    HashMap<String,Integer> map=new HashMap<>();
    List<TreeNode> ans=new ArrayList<>();
    public String solve(TreeNode root){
        if(root==null){
            return "#";
        }

        String left=solve(root.left);
        String right=solve(root.right);

        String curr = root.val + "," + left + "," + right;
        map.put(curr,map.getOrDefault(curr,0)+1);
        if(map.get(curr)==2){
            ans.add(root);
        }
        return curr;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        solve(root);
        return ans;
    }
}