class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    //min-size max-sum
    int s=1,e=Integer.MIN_VALUE;
    for(int pile:piles){
        e=Math.max(e,pile);
    }    

    int ans=-1;
    while(s<=e){
        int m=s+(e-s)/2;
        if(isValid(m,piles,h)){
            ans=m;
            e=m-1;
        }else  s=m+1;
    }
    return ans;
    }
    public boolean isValid(int m,int[] piles,int h){
        int totalHrs=0;

        for(int i=0;i<piles.length;i++){
            if(piles[i]<=m)totalHrs++;
            else{
                totalHrs+=Math.ceil((double)piles[i]/m);
            }
        }
            return totalHrs<=h?true:false;
    }
}