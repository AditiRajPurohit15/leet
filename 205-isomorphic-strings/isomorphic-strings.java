class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map1=new HashMap<>();
        HashMap<Character,Character> map2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char left=s.charAt(i);
            char right=t.charAt(i);
            if(map1.containsKey(left) && map1.get(left)!=right)return false;
            if(map2.containsKey(right) && map2.get(right)!=left)return false;

            map1.put(left,right);
            map2.put(right,left);
        }
        return true;
    }
}