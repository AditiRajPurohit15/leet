class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=0,e=nums.length-1;
        int firstOcc=-1;
        int lastOcc=-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]==target){
                firstOcc=m;
                e=m-1;
            }else if(nums[m]<target)s=m+1;
            else e=m-1;
        }
        s=0;
        e=nums.length-1;
        while(s<=e){
            int m=s+(e-s)/2;
            if(nums[m]==target){
                lastOcc=m;
                s=m+1;
            }else if(nums[m]<target)s=m+1;
            else e=m-1;
        }
        return new int[]{firstOcc,lastOcc};
    }
}