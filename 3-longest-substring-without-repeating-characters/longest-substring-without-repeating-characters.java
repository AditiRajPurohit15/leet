class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int i=0,j=0;
        Map<Character,Integer>lastSeen=new HashMap<>();
        while(j<s.length()){
            char ch=s.charAt(j);
            if(lastSeen.containsKey(ch)){
                i=Math.max(i,lastSeen.get(ch)+1);
            }
            lastSeen.put(ch,j);
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}