class Solution {
    public void subs(List<List<Integer>> ans,List<Integer> list,int[] nums,int i,boolean picked){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i==0 || nums[i]!=nums[i-1] || picked){
            list.add(nums[i]);
            subs(ans,list,nums,i+1,true);
            list.remove(list.size()-1);
        }
        subs(ans,list,nums,i+1,false);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subs(ans,list,nums,0,true);
        return ans; 
    }
}