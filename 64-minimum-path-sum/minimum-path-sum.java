class Solution {
    public int solve(int i,int j,int m,int n,int[][] grid,Integer[][] dp){
        
        if(i==m-1 && j==n-1)return grid[i][j];

        if(dp[i][j]!=null)return dp[i][j];

        int right=Integer.MAX_VALUE;
        int bottom=Integer.MAX_VALUE;

        if(j+1<n) right = grid[i][j] + solve(i,j+1,m,n,grid,dp);
        if(i+1<m) bottom = grid[i][j]+solve(i+1,j,m,n,grid,dp);

        return dp[i][j]=Math.min(right,bottom);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Integer[][] dp=new Integer[m][n];
        return solve(0,0,m,n,grid,dp);
    }
}