class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = (long)cost1*need1 + (long)cost2*need2;
        long m=Math.min(need1,need2);
        long c2=m*costBoth;
        c2+=(need1-m)*(long)cost1 + (need2-m)*(long)cost2;
        long c3=(long)Math.max(need1,need2)*costBoth;

        return Math.min(c1,Math.min(c2,c3));
    }
}