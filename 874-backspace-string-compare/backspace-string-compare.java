class Solution {
    public String createStr(String s){
    StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!='#'){
                sb.append(ch);
            }else{
                if(sb.length()==0)continue;
                else sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
    public boolean backspaceCompare(String s, String t) {
        String s1=createStr(s);
        String t1=createStr(t);

        return s1.equals(t1);
    }
}