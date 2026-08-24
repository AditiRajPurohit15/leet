class NumArray {
    int n;
    int[] segTree;
    public NumArray(int[] nums) {
        n=nums.length;
        segTree=new int[4*n];
        buildTree(0,0,n-1,segTree,nums);
    }
    
    public void update(int index, int val) {
        update(index,val,0,0,n-1);
    }
    
    public int sumRange(int left, int right) {
        return query(left,right,0,0,n-1);
    }
    public void buildTree(int i,int l,int r,int[] segTree,int[] nums){
        if(l==r){
            segTree[i]=nums[l];
            return;
        }
        int mid=l + (r-l)/2;
        buildTree(2*i+1,l,mid,segTree,nums);
        buildTree(2*i+2,mid+1,r,segTree,nums);

        segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
    public void update(int idx,int val,int i,int l,int r){
        if(l==r){
            segTree[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid){
            update(idx,val,2*i+1,l,mid);
        }else
            update(idx,val,2*i+2,mid+1,r);
            segTree[i]=segTree[2*i+1]+segTree[2*i+2];
    }
    public int query(int start,int end,int i,int l,int r){
        if(l>end || r<start)return 0;
        if(l>=start && r<=end)return segTree[i];
        int mid=l+(r-l)/2;
        return query(start,end,2*i+1,l,mid)+query(start,end,2*i+2,mid+1,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */