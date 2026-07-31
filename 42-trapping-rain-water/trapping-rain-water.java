class Solution {
    public int trap(int[] height) {
        int[] leftS=new int[height.length];
        int[] rightS=new int[height.length];

        int max=height[0];
        leftS[0]=0;
        for(int i=1;i<height.length;i++){
            leftS[i]=max;
            max=Math.max(max,height[i]);
        }
        max=height[height.length-1];
        rightS[height.length-1]=0;
        for(int i=height.length-2;i>=0;i--){
            rightS[i]=max;
            max=Math.max(max,height[i]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+=Math.max(0,Math.min(leftS[i],rightS[i])-height[i]);
        }
        return sum;
    }
}