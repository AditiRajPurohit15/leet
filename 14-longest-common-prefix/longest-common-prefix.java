class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans="";
        StringBuilder sb=new StringBuilder();
        Arrays.sort(strs);
        String s1=strs[0];
        String s2=strs[strs.length-1];

        int i=0,j=0;
        while(i<s1.length() && j<s2.length()){
            char c1=s1.charAt(i);
            char c2=s2.charAt(j);
            if(c1==c2){
                sb.append(c1);
            }else break;
            i++;
            j++;
        }
        return sb.toString();
    }
}