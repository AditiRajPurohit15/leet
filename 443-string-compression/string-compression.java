class Solution {
    public int compress(char[] chars) {
        int read=0;
        int n=chars.length;
        int write=0;
        while(read<n){
            char curr=chars[read];
            int count=0;
            while(read<n && chars[read]==curr){
                count++;
                read++;
            }
            if(count==1){
                chars[write++]=curr;
            }else{
                chars[write++]=curr;
                String cnt=String.valueOf(count);
                for(char c:cnt.toCharArray()){
                    chars[write++]=c;
                }
            }
            
        }
        return write;
    }
}