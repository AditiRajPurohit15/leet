class Solution {
    public int maxPalindromes(String s, int k) {
         int n = s.length();

        // pal[i][j] = true if s[i...j] is a palindrome
        boolean[][] pal = new boolean[n][n];

        // Build palindrome DP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    // Length 1 or 2, OR inner substring is palindrome
                    if (j - i <= 2 || pal[i + 1][j - 1]) {
                        pal[i][j] = true;
                    }
                }
            }
        }

        // dp[i] = maximum number of valid palindromes
        // that can be selected from s[0...i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {

            // Option 1: Don't select a palindrome ending at i
            dp[i] = (i > 0) ? dp[i - 1] : 0;

            // Try every palindrome ending at i
            for (int j = 0; j <= i - k + 1; j++) {

                if (pal[j][i]) {

                    // If we select s[j...i]
                    int before = (j > 0) ? dp[j - 1] : 0;

                    dp[i] = Math.max(dp[i], before + 1);
                }
            }
        }

        return dp[n - 1];
    }
}