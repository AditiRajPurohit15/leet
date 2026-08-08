class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[] ans=new int[m];

        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1];
            int k=dp[i+1];
            if(k<m){
                char reqChar=word2.charAt(m-k-1);
                if(word1.charAt(i)==reqChar){
                    dp[i]=k+1;
                }
            }
        }

        int j=0;
        int ptr=0;
        boolean used=false;
        for(int i=0; i < n && j < m;i++){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[ptr++]=i;
                j++;
            }else{
                if(!used && dp[i+1]>=m-j-1){
                    used=true;
                    ans[ptr++]=i;
                    j++;
                }
            }
        }
        if (j != m) {
            return new int[0];
        }
        return ans;
    }
}