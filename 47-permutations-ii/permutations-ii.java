class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int[] nums,boolean[] used,List<Integer> list){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;
            if(i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
            list.add(nums[i]);
            used[i]=true;
            solve(nums,used,list);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used=new boolean[nums.length];
        solve(nums,used,new ArrayList<>());
        return ans;
    }
}