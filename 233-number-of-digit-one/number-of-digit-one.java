class Solution {
    int[][][] dp=new int[12][2][12];
    public int solve(String s,int idx,int tight,int cnt){
        if(idx==s.length())return cnt;
        if(dp[idx][tight][cnt]!=-1)return dp[idx][tight][cnt];

        int limit=(tight==1)?s.charAt(idx)-'0':9;
        int ans=0;
        for(int i=0;i<=limit;i++){
            int newTight=(tight==1 && i==limit)?1:0;
            int newCnt=cnt+((i==1)?1:0);
            ans+=(solve(s,idx+1,newTight,newCnt));
        }
        return dp[idx][tight][cnt]=ans;
    }
    public int countDigitOne(int n) {
        String r=String.valueOf(n);
        for(int i=0;i<12;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(r,0,1,0);
    }
}