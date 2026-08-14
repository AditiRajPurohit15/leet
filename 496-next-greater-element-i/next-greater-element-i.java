class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();

        int[] ans=new int[nums1.length];
        int n=nums2.length;

        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums2[i]>=stk.peek()){
                stk.pop();
            }
           if(stk.isEmpty()) map.put(nums2[i],-1);
           else map.put(nums2[i],stk.peek());
            stk.push(nums2[i]);
        }

        for(int i=0;i<nums1.length;i++){
            ans[i]=map.get(nums1[i]);
        }

        return ans;
    }
}