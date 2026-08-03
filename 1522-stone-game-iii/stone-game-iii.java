class Solution {
    public int solve(int i,int[] arr,Integer[] dp){
        int n=arr.length;
        if(i>=n)return 0;
        int ans=-Integer.MAX_VALUE;
        int sum=0;

        if(dp[i]!=null)return dp[i];
        for(int k=0;k<3 && k+i<n;k++){
            sum+=arr[k+i];
            ans=Math.max(ans,sum-solve(k+i+1,arr,dp));
        }

        return dp[i]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        Integer[] dp=new Integer[n];
        int ans=solve(0,stoneValue,dp);
        if(ans==0)return "Tie";
        return ans>0 ? "Alice":"Bob";
    }
}