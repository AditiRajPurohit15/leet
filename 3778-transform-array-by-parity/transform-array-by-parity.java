class Solution {
    public int[] transformArray(int[] nums) {
        int cnt=0;
        for(int num:nums){
            if(num%2==0)cnt++;
        }
        Arrays.fill(nums,1);
        for(int i=0;i<cnt;i++){
            nums[i]=0;
        }
        return nums;
    }
}