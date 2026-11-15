class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD=(int)(1e9 + 7);
        long preSum=0;
        long oddCnt=0;
        for(int ele:arr){
            preSum+=ele;
            oddCnt+=preSum%2;
        }
        oddCnt+=((long)arr.length-oddCnt)*oddCnt;
        return (int)(oddCnt % MOD);
    }
}