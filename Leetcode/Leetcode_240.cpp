class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int numRows = matrix.size();
        int numCols = matrix[0].size() - 1;
        bool ans = false;
        for (int i = 0; i < numRows;) {
            if (target < matrix[i][numCols]) {
                numCols -= 1;
            } else if (target > matrix[i][numCols]) {
                i += 1;
            } else {
                return true;
            }
            if (i == numRows) {
                break;
            }
            if (numCols == -1) {
                break;
            }
        }
        return false;
    }
};