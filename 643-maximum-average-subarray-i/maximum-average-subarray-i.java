class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int ans=0;
        int sum=0;
        for(int i=0;i<k;i++)sum+=nums[i];
        ans=sum;
        int j=k;
        int i=0;
        while(j<nums.length){
            sum-=nums[i++];
            sum+=nums[j++];
            ans=Math.max(ans,sum);
        }

        return (double)ans/k;
    }
}