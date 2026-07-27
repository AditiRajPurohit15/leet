class Solution {
    public boolean isPal(int st,int e,String s){
        int i=st;
        int j=e-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public String longestPalindrome(String s) {
        for(int length=s.length();length>0;length--){
            for(int start=0;start<=s.length()-length;start++){
                if(isPal(start,start+length,s)){
                    return s.substring(start,start+length);
                }
            }
        }
        return "";
    }
}