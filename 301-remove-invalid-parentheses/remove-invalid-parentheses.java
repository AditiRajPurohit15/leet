class Solution {
    int minCnt=Integer.MAX_VALUE;
    public boolean isValid(String str){
        Stack<Character> stk = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);

            if(ch=='('){
                stk.push('(');
            }else if(ch==')'){
                if(!stk.isEmpty()){
                stk.pop();
                }else{
                    return false;
                }
            }else continue;
        }
        
        return stk.isEmpty();
        
    }
    public void solve(String s, int cnt, StringBuilder sb,int i,int balance,Set<String> ans){
        if(i==s.length()){
            String str = sb.toString();

            if(isValid(str) && cnt<=minCnt){
                if(cnt<minCnt){
                    minCnt=cnt;
                    ans.clear();
                }
                ans.add(str);
            }
            return;
        }

        if(cnt>minCnt)return;

        char ch = s.charAt(i);

        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
            //pick only
            sb.append(ch);
            solve(s,cnt,sb,i+1,balance,ans);
            sb.deleteCharAt(sb.length()-1);
            return;
        }


        if(balance < 0){
            return;
        }
        //not pick
        solve(s,cnt+1,sb,i+1,balance,ans);

        //pick
        sb.append(ch);

        if(ch=='('){
            solve(s,cnt,sb,i+1,balance+1,ans);
         }else{
             solve(s,cnt,sb,i+1,balance-1,ans);
         }

        sb.deleteCharAt(sb.length()-1);

    }
    public List<String> removeInvalidParentheses(String s) {
        Set<String> ans = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();

        solve(s,0,sb,0,0,ans);

        List<String> list = new ArrayList<>();

        list.addAll(ans);

        return list;

    }
}