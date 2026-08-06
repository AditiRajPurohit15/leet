class Solution {
    public int smallestNumber(int n, int t) {
        int i=n;
        while(true){
            int prod=1;
            int temp=i;
            while(i!=0){
                int rem=i%10;
                prod*=rem;
                i/=10;
            }
            if(prod%t==0){
                return temp;
            }
            i=temp+1;
        }
    }
}