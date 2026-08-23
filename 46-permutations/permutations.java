class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> list=new ArrayList<>();

    public void solve(int[] nums,boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            used[i]=true;
            list.add(nums[i]);
            solve(nums,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n=nums.length;
        boolean[] used=new boolean[n];
        solve(nums,used);
        return ans;
    }
}