class Solution {
    public void subs(List<List<Integer>> ans,List<Integer> list,int[] nums,int i){
        ans.add(new ArrayList<>(list));
        for(int j=i;j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]){
                continue;
            }
            list.add(nums[j]);
            subs(ans,list,nums,j+1);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subs(ans,list,nums,0);
        return ans; 
    }
}