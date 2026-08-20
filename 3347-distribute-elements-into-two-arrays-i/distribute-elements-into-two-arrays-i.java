class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();

        l1.add(nums[0]);
        l2.add(nums[1]);

        int last1=nums[0];
        int last2=nums[1];

        for(int i=2;i<nums.length;i++){
            if(last1>=last2){
                l1.add(nums[i]);
                last1=nums[i];
            }else{
                l2.add(nums[i]);
                last2=nums[i];
            }
        }
        int i=0;
        for(int j=0;j<l1.size();j++){
            nums[i++]=l1.get(j);
        }
        for(int j=0;j<l2.size();j++){
            nums[i++]=l2.get(j);
        }
        return nums;
    }
}