class Solution {
    public int majorityElement(int[] nums) {
        int vote=1;
        int maj=nums[0];
        for(int num:nums){
            if(num==maj){
                vote++;
            }else{
                vote--;
            }
                if(vote<=0){
                    maj=num;
                    vote=1;
                }
        }
        return maj;
    }
}