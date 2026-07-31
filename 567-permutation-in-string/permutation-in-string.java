class Solution {
    public boolean isAnagram(int[] arr,int[] varArr){
        for(int k=0;k<26;k++){
            if(arr[k]!=varArr[k])return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())return false;
        int size=s1.length();//window size
        
        int[] arr=new int[26];
        
        for(char c:s1.toCharArray()){
            arr[c-'a']++;
        }

        int varArr[]=new int[26];
            for(int k=0;k<size;k++){
            char c=s2.charAt(k);
            varArr[c-'a']++;
        }
        if(isAnagram(arr,varArr))return true;
        int i=1,j=size;
        while(j<s2.length()){
            varArr[s2.charAt(i-1)-'a']--;
            varArr[s2.charAt(j)-'a']++;
            if(isAnagram(arr,varArr))return true;
            i++;
            j++;
        }
        return false;
    }
}