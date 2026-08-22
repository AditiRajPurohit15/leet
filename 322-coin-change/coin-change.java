class Solution {
    public int solve(int n,int[] coins, int amount,Integer[][] dp){
        if(n==0)return Integer.MAX_VALUE-1;
        if(amount==0)return 0;
        if(dp[n][amount]!=null)return dp[n][amount];
        if(coins[n-1]<=amount){
            return dp[n][amount]=Math.min(1+solve(n,coins,amount-coins[n-1],dp),solve(n-1,coins,amount,dp));
        }else return dp[n][amount]=solve(n-1,coins,amount,dp);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        Integer[][] dp=new Integer[n+1][amount+1];
        int ans=solve(n,coins,amount,dp);
        return (ans!=Integer.MAX_VALUE-1)?ans:-1;
    }
}