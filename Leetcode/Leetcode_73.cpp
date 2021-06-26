class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        // vector<vector<int>> res(m, vector<int> (n));
        vector<pair<int, int>> indexes;
        pair<int, int> index;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] ==  0) {
                    indexes.push_back({i , j});
                }
            }
        }

        for (int k = 0; k < indexes.size(); k++) {
            index = indexes[k];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (index.first == i || index.second == j) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
};