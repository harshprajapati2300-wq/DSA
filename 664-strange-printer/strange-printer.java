class Solution {
    int[][] dp;

    public int strangePrinter(String s) {
        int n = s.length();

        dp = new int[n][n];

        return solve(s, 0, n - 1);
    }

    int solve(String s, int i, int j) {

    
        if (i > j) {
            return 0;
        }

        
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

    
        int ans = 1 + solve(s, i + 1, j);

        
        for (int k = i + 1; k <= j; k++) {

            if (s.charAt(i) == s.charAt(k)) {

                int turns = solve(s, i + 1, k - 1)
                          + solve(s, k, j);

                ans = Math.min(ans, turns);
            }
        }

        dp[i][j] = ans;

        return ans;
    }
}