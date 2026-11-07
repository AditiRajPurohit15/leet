class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int ans=0;
        int preSum=0;

        for(int i=0;i<nums.length;i++){
            // int sum=k-nums[i];
            preSum+=nums[i];
            if(map.containsKey(preSum-k)){
                ans+=map.get(preSum-k);
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }

        return ans;
    }
}