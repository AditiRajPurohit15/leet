class Solution {
    List<String> ans=new ArrayList<>();
    public void permute(String ip,String op){
        if(ip.length()==0){
            ans.add(op);
            return;
        }

        char c=ip.charAt(0);
        String s=""+c;
        ip=ip.substring(1,ip.length());
        if(Character.isDigit(c)){
            permute(ip,op+s);
            return;
        }

        String ch=(""+c).toLowerCase();
        String ch2=(""+c).toUpperCase();

        permute(ip,op+ch);
        permute(ip,op+ch2);
    }
    public List<String> letterCasePermutation(String s) {
        permute(s,"");
        return ans;
    }
}