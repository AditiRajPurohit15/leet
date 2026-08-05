class Solution {
    public void dfs(int node,List<List<Integer>> adj,boolean[] isVis){
        isVis[node]=true;
        for(int neighbor:adj.get(node)){
            if(!isVis[neighbor]){
                dfs(neighbor,adj,isVis);
            }
        }
    }
    
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:invocations){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
        }
        boolean[] isVis=new boolean[n];
        dfs(k,adj,isVis);

        for(int[] e:invocations){
            int u=e[0];
            int v=e[1];

            if(!isVis[u] && isVis[v]){
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
                return ans;
            }
        }

        for(int i=0;i<n;i++){
            if(!isVis[i])ans.add(i);
        }
        return ans;
    }
}