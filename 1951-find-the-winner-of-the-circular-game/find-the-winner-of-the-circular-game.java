class Solution {
    public int alive(List<Integer> people,int k,int i){
        if(people.size()==1){
            return people.get(0);
        }

        int kill=(i+k-1)%people.size();
        people.remove(kill);
        return alive(people,k,kill);
    }
    public int findTheWinner(int n, int k) {
        List<Integer> people=new ArrayList<>();
        for(int i=1;i<=n;i++){
            people.add(i);
        }
        return alive(people,k,0);
    }
}