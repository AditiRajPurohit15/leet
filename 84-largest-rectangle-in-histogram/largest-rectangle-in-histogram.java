class Solution {
    class Pair{
        int first;
        int second;

        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int largestRectangleArea(int[] heights) {
        List<Integer> left=new ArrayList<>(); //nsl
        List<Integer> right=new ArrayList<>();//nsr
        Stack<Pair> s=new Stack<>();
        
        int n=heights.length;

        int pseudo=-1;
        for(int i=0;i<n;i++){
            if(s.isEmpty())left.add(pseudo);
            else if(!s.isEmpty() && s.peek().first<heights[i])left.add(s.peek().second);
            else if(!s.isEmpty() && s.peek().first>=heights[i]){
                while(!s.isEmpty() && s.peek().first>=heights[i])s.pop();
                if(s.isEmpty())left.add(pseudo);
                else left.add(s.peek().second);
            }
            s.push(new Pair(heights[i],i));
        }
        
        for(int i=0;i<n;i++){
            left.set(i,i-left.get(i));
        }
        
        s.clear();
        pseudo=n;
        for(int i=n-1;i>=0;i--){
            if(s.isEmpty())right.add(pseudo);
            else if(!s.isEmpty() && s.peek().first<heights[i])right.add(s.peek().second);
            else if(!s.isEmpty() && s.peek().first>=heights[i]){
                while(!s.isEmpty() && s.peek().first>=heights[i])s.pop();
                if(s.isEmpty())right.add(pseudo);
                else right.add(s.peek().second);
            }
            s.push(new Pair(heights[i],i));
        }
        Collections.reverse(right);
        for(int i=0;i<n;i++){
            right.set(i,right.get(i)-i);
        }

        int[] width=new int[n];
        for(int i=0;i<n;i++){
            width[i]=right.get(i)+left.get(i)-1;
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*width[i]);
        }
        return ans;

    }
}