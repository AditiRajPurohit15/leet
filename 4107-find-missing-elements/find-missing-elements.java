class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        int min=Integer.MAX_VALUE,max=0;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
            set.add(num);
        }
        for(int i=min+1;i<max;i++){
            if(!set.contains(i))ans.add(i);
        }
        return ans;
    }
}