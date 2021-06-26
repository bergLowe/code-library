class Solution {
public:
    int countSubstrings(string s) {
        int size = s.size();
        vector<vector<int>> dp (size, vector<int> (size , 0));
        int countNumOne = 0, strLen;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= j; i++) {
                strLen = (j - i) + 1;
                if (strLen > 2) {
                    dp[i][j] = s[i] == s[j] ? dp[i + 1][j - 1] : 0;
                } else {
                    dp[i][j] = s[i] == s[j] ? 1 : 0;
                }
                if (dp[i][j] == 1) countNumOne++;
            }
        }
        return countNumOne;
    }
};