class Solution {
    boolean canFindTwo(int k, int[][] prefix, int m, int n) {

    int minRow = Integer.MAX_VALUE;
    int maxRow = Integer.MIN_VALUE;

    int minCol = Integer.MAX_VALUE;
    int maxCol = Integer.MIN_VALUE;

    for (int r = 0; r + k <= m; r++) {

        for (int c = 0; c + k <= n; c++) {

            // Sum of current k x k square
            int sum = prefix[r + k][c + k]
                    - prefix[r][c + k]
                    - prefix[r + k][c]
                    + prefix[r][c];

            // Not a valid square
            if (sum != k * k)
                continue;

            // Some previous square is completely ABOVE
            if (minRow <= r - k)
                return true;

            // Some previous square is completely BELOW
            if (maxRow >= r + k)
                return true;

            // Some previous square is completely LEFT
            if (minCol <= c - k)
                return true;

            // Some previous square is completely RIGHT
            if (maxCol >= c + k)
                return true;

            // Store this valid square
            minRow = Math.min(minRow, r);
            maxRow = Math.max(maxRow, r);

            minCol = Math.min(minCol, c);
            maxCol = Math.max(maxCol, c);
        }
    }

    return false;
}
    public int maxArea(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int low=1;
        int high=Math.min(m,n);

        int[][] prefix = new int[m + 1][n + 1];

for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
        prefix[i + 1][j + 1] =
            mat[i][j]
            + prefix[i][j + 1]
            + prefix[i + 1][j]
            - prefix[i][j];
    }
}

        int ans=0;

        while(low<=high){
            int k=(low+high)/2;

            if(canFindTwo(k,prefix,m,n)){
                ans=k;
                low=k+1;
            }else{
                high=k-1;
            }
        }

        return ans*ans;
    }
}