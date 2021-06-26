class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int numRows = matrix.size();
        int numCols = matrix[0].size();
        bool ans = false;
        for (int i = 0; i < numRows; i++) {
            ans = searchEachRow(matrix[i], target);
            if (ans) {
                return true;
            }
        }
        return ans;
    }
    
    bool searchEachRow(vector<int> nums, int target) {
        int start = 0; 
        int end = nums.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            // cout << "Mid: " << mid << endl;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
};