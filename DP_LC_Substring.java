class Solution {
    int longestCommonSubstr(String str1, String str2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int longestCommonSubstr = 0;

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > longestCommonSubstr) {
                    longestCommonSubstr = dp[i][j];
                }
            }
        }

        return longestCommonSubstr;
    }
}