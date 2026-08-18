class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        int max1=-1;
        int maxn=-1;

        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int key:map.keySet()){
            if(map.get(key)==1){
                max1=Math.max(max1,key);
            }
            maxn=Math.max(maxn,key);
        }
        if(k==1)return max1;
        if(k==n)return maxn;

        int first=map.get(nums[0]);
        int last=map.get(nums[n-1]);
        if(first==1 && last==1){
            return Math.max(nums[0],nums[n-1]);
        }
        if(first==1)return nums[0];
        if(last==1)return nums[n-1];
        return -1;
    }
}