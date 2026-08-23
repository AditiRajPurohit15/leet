class Solution {
    public void allCombination(List<List<Integer>> ans,int[] nums,int i){
        if(i==nums.length){
            List<Integer> list=new ArrayList<>();
            for(int n:nums)list.add(n);
            ans.add(list);
            return;
        }

        Set<Integer> set=new HashSet<>();
        for(int j=i;j<nums.length;j++){
            if(set.contains(nums[j]))continue;

            set.add(nums[j]);
            swap(i,j,nums);
            allCombination(ans,nums,i+1);
            swap(i,j,nums);
        }
        set.add(nums[i]);
    }
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        allCombination(ans,nums,0);
        return ans;
    }
}