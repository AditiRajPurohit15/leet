class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k){
            String temp = "";
             for(int i=0;i<s.length();i+=k){
                String s1;
            if(i+k<=s.length())s1 = s.substring(i,i+k);
            else s1 = s.substring(i);

            int sum=0;
            for(char ch: s1.toCharArray()){
                sum += ch-'0';
            }
            
            temp = temp + sum;
            
        }
        s=temp;
        }
        return s;
    }
}