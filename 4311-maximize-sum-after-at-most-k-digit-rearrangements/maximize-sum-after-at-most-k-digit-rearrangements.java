class Solution {
    public long maximizeSum(int[] nums, int k) {
        //naye arr m sabka max store krlo->maintain a map and tick top k picked which needed changing-> take rest from original arr(non picked ones in the top k)
        long totalSum=0;
        int n=nums.length;
        int[] gains=new int[n];

        for(int i=0;i<n;i++){
            totalSum+=nums[i];
            int maxValue=getMaxValue(nums[i]);
            gains[i]=maxValue-nums[i];
        }

        Arrays.sort(gains);

        int operationsPerformed=0;
        
        for(int i=n-1;i>=0 && operationsPerformed<k;i--){
            if(gains[i]>0){
                totalSum+=gains[i];
                operationsPerformed++;
            }else break;
        }

        return totalSum;
    }

    private int getMaxValue(int num){
        int[] digitCnt=new int[10];
        int temp=num;

        while(temp>0){
            digitCnt[temp%10]++;
            temp/=10;
        }

        long maxNum=0;
        for(int d=9;d>=0;d--){
            while(digitCnt[d]>0){
                maxNum=maxNum*10+d;
                digitCnt[d]--;
            }
        }

        return (int)maxNum;
    }
}