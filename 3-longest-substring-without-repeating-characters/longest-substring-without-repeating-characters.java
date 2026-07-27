class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j=0;
        int ans=0;
        while(i<=j && j<s.length()){
            char c=s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);

            while(map.get(c)>1 && i<=j){
                char ch=s.charAt(i);
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0){
                    map.remove(ch);
                }
                    i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}