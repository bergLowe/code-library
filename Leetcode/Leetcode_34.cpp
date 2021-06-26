class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> index;
        index.push_back(firstOccurence(nums, target));
        index.push_back(lastOccurence(nums, target));
        return index;
    }
    
    int firstOccurence(vector<int> nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
    
    int lastOccurence(vector<int> nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                index = mid;
                start = mid + 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
};