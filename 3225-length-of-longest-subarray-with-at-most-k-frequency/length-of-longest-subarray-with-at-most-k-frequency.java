class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i=0,j=0,cnt=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(j<nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(i<j && map.get(nums[j])>k){
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])==0)map.remove(nums[i]);
                i++;
            }

            cnt=Math.max(cnt,j-i+1);
            j++;
        }
        return cnt;
    }
}