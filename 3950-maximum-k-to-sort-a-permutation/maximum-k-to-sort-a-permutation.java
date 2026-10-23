class Solution {
    public int sortPermutation(int[] nums) {
        int ans=-1;
        for(int i=0;i<nums.length;i++){
            if(i!=nums[i]){
                System.out.println("i : "+i+" nums[i]: "+nums[i]);
                ans = ans & nums[i];
                System.out.println("ans: "+ans);
            }
        }
        return ans==-1?0:ans;
    }
}