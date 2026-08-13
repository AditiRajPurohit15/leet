class Solution {

    // Check whether digits of val are unique and not already present in mask
    private boolean isGood(int val, int mask){
        while(val>0){
            int rem=val%10;

            if((mask & (1<<rem))!=0)return false;

            mask |= (1<<rem);
            val/=10;
        }
        return true;
    }

    // DP: get maximum sum with unique digits
    private int getMax(int idx, List<Integer> arr, int mask, int[][] dp) {
        if(idx>=arr.size()){
            return 0;
        }

        if(dp[idx][mask]!=-1)return dp[idx][mask];

        int notTake=getMax(idx+1,arr,mask,dp);

        int take=0;
        if(isGood(arr.get(idx),mask)){
            int x=arr.get(idx);
            int newMask=mask;

            while(x>0){
                int rem=x%10;
                newMask |= (1<<rem);
                x/=10;
            }
        take=arr.get(idx)+getMax(idx+1,arr,newMask,dp);
        }

        return dp[idx][mask]=Math.max(take,notTake);
    }

    // Collect all nodes in the subtree rooted at 'node'
    private void dfs(int node, boolean[] visited,Map<Integer, List<Integer>> adj,int[] vals,List<Integer> ans){
        visited[node]=true;
        ans.add(vals[node]);

        for(int child:adj.getOrDefault(node,new ArrayList<>())){
            if(!visited[child]){
                dfs(child,visited,adj,vals,ans);
            }
        }
    }
    public int goodSubtreeSum(int[] vals, int[] par) {
        int n=vals.length;
        Map<Integer,List<Integer>> adj=new HashMap<>();

        //build tree
        for(int i=0;i<n;i++){
            if(par[i]!=-1){
                adj.computeIfAbsent(par[i],k->new ArrayList<>()).add(i);
            }
        }

        long ans=0;
        int MOD = 1_000_000_007;

        for(int i=0;i<n;i++){
            boolean[] visited=new boolean[n];
            List<Integer> subTree=new ArrayList<>();

            dfs(i,visited,adj,vals,subTree);

            int[][] dp=new int[subTree.size()][1024];

            for(int[] row:dp){
                Arrays.fill(row,-1);
            }

            ans=(ans + getMax(0,subTree,0,dp))%MOD;
        }

        return (int)ans;

    }
}