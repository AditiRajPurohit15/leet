class Solution {
    public boolean isVal(char c){
        if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9'))return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<=j){
            while(i<j && !isVal(s.charAt(i)))i++;
            while(i<j && !isVal(s.charAt(j)))j--;
            char ci=Character.toLowerCase(s.charAt(i));
            char cj = Character.toLowerCase(s.charAt(j));
            System.out.println("ci->"+ci+" cj->"+cj);
            if(ci!=cj)return false;
            i++;
            j--;
        }
        return true;
    }
}