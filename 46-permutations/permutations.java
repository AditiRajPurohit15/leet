class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void solve(int i,int[] nums){
        if(i==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int num:nums)list.add(num);
            ans.add(list);
            return;
        }

        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            solve(i+1,nums);
            swap(nums,i,j);
        }
    }
    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        solve(0,nums);
        return ans;
    }
}