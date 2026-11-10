class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int ans=0;

        for(int num:nums)set.add(num);
        for(int i:set){
            if(!set.contains(i-1)){
                int j=i;
                int cnt=0;
                while(set.contains(j)){
                    cnt++;
                    j++;
                }
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}