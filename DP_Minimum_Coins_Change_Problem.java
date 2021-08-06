class Solution {
    long INF = Long.MAX_VALUE - 1;
    public int coinChange(int[] coins, int amount) {
        long dp[][] = new long[coins.length + 1][amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = INF;
        }

        for (int i = 1; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[1][i] = i / coins[0];
            } else {
                dp[1][i] = INF;
            }
        }

        for (int i = 2; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][amount] < 0 || dp[coins.length][amount] >= INF ? -1 : (int) dp[coins.length][amount];
    }
}