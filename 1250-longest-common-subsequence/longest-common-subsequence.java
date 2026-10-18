class Solution {
    public int solve(int i,int j,String t1, String t2,Integer[][] dp){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=null)return dp[i][j];

        if(t1.charAt(i)==t2.charAt(j)){
            return dp[i][j]=1+solve(i-1,j-1,t1,t2,dp);
        }

        return dp[i][j]=Math.max(solve(i,j-1,t1,t2,dp),solve(i-1,j,t1,t2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        Integer[][] dp=new Integer[m][n];

        return solve(m-1,n-1,text1,text2,dp);
    }
}