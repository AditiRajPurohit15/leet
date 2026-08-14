class Solution {
    public long maxWeight(int[] pizzas) {
        int cnt=pizzas.length/4;
        Arrays.sort(pizzas);
        int i=pizzas.length-1;
        long sum=0;
        int oddDays = (cnt + 1) / 2;
        int evenDays = cnt / 2;
        while(--oddDays>=0){
            System.out.println(pizzas[i]);
            sum+=pizzas[i--];
        }
        while(--evenDays>=0){
            System.out.println(pizzas[i-1]);
            sum+=pizzas[i-1];
            i-=2;
        }
        return sum;
    }
}