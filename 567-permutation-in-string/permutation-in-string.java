class Solution {
    public boolean isAnagram(int i,int j,String s2,String s1){
        int[] arr=new int[26];
        for(char c:s1.toCharArray()){
            arr[c-'a']++;
        }
        for(int k=i;k<=j;k++){
            char c=s2.charAt(k);
            arr[c-'a']--;
        }
        for(int k=0;k<26;k++){
            if(arr[k]!=0)return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int size=s1.length();//window size
        int i=0,j=size-1;
        while(j<s2.length()){
            if(isAnagram(i,j,s2,s1))return true;
            i++;
            j++;
        }
        return false;
    }
}