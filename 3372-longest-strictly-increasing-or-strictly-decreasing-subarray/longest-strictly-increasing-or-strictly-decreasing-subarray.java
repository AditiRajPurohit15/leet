class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;

        int incAns=Integer.MIN_VALUE;
        int decAns=Integer.MIN_VALUE;

        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                dec++;
                incAns=Math.max(inc,incAns);
                inc=1;
            }else if(nums[i]==nums[i-1]){
                decAns=Math.max(dec,decAns);
                incAns=Math.max(inc,incAns);
                dec=1;
                inc=1;
            }else{
                decAns=Math.max(dec,decAns);
                dec=1;
                inc++;
            }
        }
        incAns=Math.max(incAns,inc);
        decAns=Math.max(decAns,dec);

        return Math.max(incAns,decAns);
    }
}