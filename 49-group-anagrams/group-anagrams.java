class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
           char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            if(map.containsKey(temp))continue;
            map.put(temp,new ArrayList<>());
        }
        for(String s:strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String temp = new String(arr);
            map.get(temp).add(s);
        }
        List<List<String>> ans=new ArrayList<>();
        for(List<String> val:map.values()){
            ans.add(val);
        }
        return ans;
    }
}