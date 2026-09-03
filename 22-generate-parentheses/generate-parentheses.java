class Solution {
    List<String> ans=new ArrayList<>();
    public void solve(int open,int close,String op){
        if(open==0 && close==0){
            ans.add(op);
            return;
        }

        if(open!=0){
            String op1=op+"(";
            solve(open-1,close,op1);
        }
        if(close>open){
            String op2=op+")";
            solve(open,close-1,op2);
        }
    }
    public List<String> generateParenthesis(int n) {
        int open=n;
        int close=n;
        String op="";
        solve(open,close,op);
        return ans;
    }
}