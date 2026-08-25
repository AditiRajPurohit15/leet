class Solution {
    public int missingMultiple(int[] nums, int k) {
        int ans=0;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(num==1 && k!=1)continue;
            set.add(num);
        }
        int i=k;
        while(i<10000){
            if(!set.contains(i))return i;
            i+=k;
        }
        return -1;
    }
}