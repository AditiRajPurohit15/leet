class Solution {
    public int[] sortArray(int[] nums) {
        divide(0,nums.length-1,nums);
        return nums;
    }
    public void divide(int s,int e,int[] nums){
        if(s>=e)return;
        int m=s+(e-s)/2;

        divide(s,m,nums);
        divide(m+1,e,nums);
        conquer(s,m,e,nums);
    }
    public void conquer(int s,int m,int e,int[] nums){
        int[] merge=new int[e-s+1];
        int i=s,j=m+1,k=0;
        while(i<=m && j<=e){
            if(nums[i]<=nums[j]){
                merge[k++]=nums[i++];
            }else{
                merge[k++]=nums[j++];
            }
        }
        while(i<=m){
            merge[k++]=nums[i++];
        }
        while(j<=e){
            merge[k++]=nums[j++];
        }
        int l=0;
        for(int n=s;n<=e;n++){
            nums[n]=merge[l++];
        }

    }
}