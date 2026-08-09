class Solution {
    int solve(int i,int M,int[][] dp,int[] suffix,int n){
        if(i>=n)return 0;

        if(dp[i][M]!=-1)return dp[i][M];

        int total=suffix[i];
        int best=0;

        for(int X=1;X<=2*M && i+X<=n;X++){
            int opponent=solve(i+X,Math.max(M,X),dp,suffix,n);
            int current=total-opponent;
            best=Math.max(best,current);
        }
        return dp[i][M]=best;
    }
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][] dp=new int[n][n+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int[] suffix=new int[n];
        int prev=0;
        for(int i=n-1;i>=0;i--){
            suffix[i]=prev+piles[i];
            prev=suffix[i];
        }

        return solve(0,1,dp,suffix,n);
    }
}