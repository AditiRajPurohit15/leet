class Solution {
    public void sortColors(int[] nums) {
        int s=0,m=0,e=nums.length-1;
        while(m<=e){
            if(nums[m]==1){
                m++;
            }else if(nums[m]==0){
                int temp=nums[m];
                nums[m]=nums[s];
                nums[s]=temp;
                m++;
                s++;
            }else{
                int temp=nums[m];
                nums[m]=nums[e];
                nums[e]=temp;
                e--;
            }
        }
    }
}