class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int cnt=0;
        int minLen=Integer.MAX_VALUE;
        String ans="";
        //store len and index
        int i=0,j=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(ch=='1')cnt++;
            while(cnt>k){
                char c=s.charAt(i);
                if(c=='1')cnt--;
                i++;
            }

            while(cnt==k){
                int len = j - i + 1;
                String curr = s.substring(i, j + 1);

                if(len<minLen || len == minLen && curr.compareTo(ans) < 0){
                    minLen=len;
                    ans=curr;
                }
                char cr=s.charAt(i);
                if(cr=='1')cnt--;
                i++;
            }
            j++;
        }
        return ans;
    }
}