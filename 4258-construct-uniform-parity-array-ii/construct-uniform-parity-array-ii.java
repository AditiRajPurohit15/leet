class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        boolean isEven=nums1[0]%2==0;
        for(int i=1;i<nums1.length;i++){
            if(isEven){
                if(nums1[i]%2==0)continue;
                int temp=nums1[i]-nums1[0]; //diff of even,odd is always odd
                if(temp>=1 && temp%2==0)continue;
                return false;
            }else if(!isEven){
                if(nums1[i]%2!=0)continue;
                int temp=nums1[i]-nums1[0];
                if(temp>=1 && temp%2!=0)continue;
                return false;
            }
        }
        return true;
    }
}