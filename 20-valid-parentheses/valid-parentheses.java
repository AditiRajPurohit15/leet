class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stk.push(ch);
            }else if(ch==')' || ch=='}'||ch==']'){
                if(stk.isEmpty())return false;
                else if((stk.peek()=='(' && ch==')') || (stk.peek()=='{' && ch=='}') || (stk.peek()=='[' && ch==']')){
                    stk.pop();
                }else return false;
            }else return false;
            i++;
        }
        return stk.isEmpty();
    }
}