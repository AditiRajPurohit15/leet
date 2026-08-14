class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //if stack empty 0 if not check if top most element > curr element stk m store index
        //while stack element is < peek
        Stack<Integer> stk=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        int n=temperatures.length;
        int[] ans=new int[n];

        for(int i=n-1;i>=0;i--){

            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                ans[i]=stk.peek()-i;
            }
            stk.push(i);
        }
        return ans;
    }
}