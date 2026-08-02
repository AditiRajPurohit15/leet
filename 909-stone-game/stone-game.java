class Solution {
    public int solve(int i,int j,int[] piles,Integer[][] dp){
        if(i>j)return 0;
        if(i==j)return piles[i];
        if(i+1==j)return Math.max(piles[i],piles[j]);

        if(dp[i][j]!=null)return dp[i][j];
        int left=piles[i]+Math.min(solve(i+2,j,piles,dp),solve(i+1,j-1,piles,dp));
        int right=piles[j]+Math.min(solve(i,j-2,piles,dp),solve(i+1,j-1,piles,dp));

        return dp[i][j]=Math.max(right,left); 
    }
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer[][] dp=new Integer[n][n];
        int aliceScore = solve(0,n-1,piles,dp);
        int sum=0;
        for(int pile:piles){
            sum+=pile;
        }
        sum/=2;
        if(aliceScore>=sum)return true;
        return false;
    }
}