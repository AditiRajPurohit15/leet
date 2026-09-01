class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i-1]!=nums[i]){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        int ans=0;
        for(int val:map.values()){
            if(val==1)ans++;
        }
        return ans;
    }
}