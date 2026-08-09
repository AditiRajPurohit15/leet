class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums)set.add(num);
        int cnt=1;
        int max=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int current=num;
                int streak=1;
                while(set.contains(current+1)){
                    current++;
                    streak++;
                }
                max=Math.max(max,streak);
            }
        }
        return max;
    }
}