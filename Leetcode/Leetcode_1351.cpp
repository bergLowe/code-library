// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            count += countNegativeNum(grid[i]);
        }
        return count;
    }
    
    int countNegativeNum(vector<int> arr) {
        int cntLast = findLastOccurence(arr);
        if (cntLast == -1) {
            return 0;
        }
        return (cntLast - findFirstOccurence(arr)) + 1;
    }
    
    int findFirstOccurence(vector<int> arr) {
        int index = -1;
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            // cout << "FIRST mid: " << arr[mid] << endl;
            if (arr[mid] < 0) {
                // cout << "FIRST in: " << arr[mid] << mid << endl;
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // cout << "END\n";
        return index;
    }   
    
    int findLastOccurence(vector<int> arr) {
        int index = -1;
        int start = 0;
        int end = arr.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + ((end - start) / 2);
            // cout << "LAST mid: " << arr[mid] << endl;
            if (arr[mid] < 0) {
                // cout << "LAST in: " << arr[mid] << mid << endl;
                index = mid;
                start = mid + 1;
            } else {
                start = mid + 1;
            }
        }
        // cout << "END\n";
        return index;
    }
};