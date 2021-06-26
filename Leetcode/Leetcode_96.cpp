class Solution {
    public int numTrees(int n) {
        int i, j;
        int []dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (i = 2; i <= n; i++) {
            for (j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        // for (int a : dp) {
        //     System.out.print(a + " ");
        // }
        return dp[n];
    }
}