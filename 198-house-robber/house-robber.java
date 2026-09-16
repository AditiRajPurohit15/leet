class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int p1=nums[0];
        if(n==1)return p1;
        int p2=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int temp=Math.max(p2,p1+nums[i]);
            p1=p2;
            p2=temp;
        }
        return p2;
    }
}