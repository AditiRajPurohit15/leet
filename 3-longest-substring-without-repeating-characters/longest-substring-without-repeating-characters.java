class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=0,j=0;
        int cnt=0;
        while(j<s.length()){
            char ch=s.charAt(j);

            while(i<j && map.containsKey(ch)){
                char c=s.charAt(i);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    map.remove(c);
                }
                i++;
            }

            map.put(ch,map.getOrDefault(ch,0)+1);
            cnt=Math.max(cnt,j-i+1);
            j++;
        }
        return cnt;
    }
}