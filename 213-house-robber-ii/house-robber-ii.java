class Solution {
    public int robb(int[] nums,int i,int j){
        int p1=nums[i];
        if(j-i+1==1)return p1;
        int p2=Math.max(nums[i],nums[i+1]);
        for(int k=i+2;k<=j;k++){
            int temp=Math.max(p2,p1+nums[k]);
            p1=p2;
            p2=temp;
        }
        return p2;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n == 1) return nums[0];
        int a=robb(nums,0,n-2);
        int b=robb(nums,1,n-1);
        return Math.max(a,b);
    }
}