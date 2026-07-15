class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;

        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        double[][] dp = new double[n][k + 1];

        
        for (int i = 0; i < n; i++) {
            dp[i][1] = (prefix[n] - prefix[i]) / (n - i);
        }

        for (int p = 2; p <= k; p++) {
            for (int i = 0; i <= n - p; i++) {

                for (int j = i; j <= n - p; j++) {

                    double avg = (prefix[j + 1] - prefix[i]) / (j - i + 1);

                    dp[i][p] = Math.max(dp[i][p],
                                        avg + dp[j + 1][p - 1]);
                }
            }
        }

        return dp[0][k];
    }
}