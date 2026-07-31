class Solution {
    public void sortColors(int[] nums) {
        int s=0,m=0,e=nums.length-1;
        while(m<=e){
            if(nums[m]==1){
                m++;
            }else if(nums[m]==0){
                int temp=nums[s];
                nums[s]=nums[m];
                nums[m]=temp;
                s++;
                m++;
            }else{
                int temp=nums[e];
                nums[e]=nums[m];
                nums[m]=temp;
                e--;
            }
        }
    }
}