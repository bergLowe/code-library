class Solution {
public:
    int peakIndexInMountainArray(vector<int>& nums) {
        if (nums.size() == 1) {
            return 0;
        }
        
        long long int start = 0;
        long long int end = nums.size() - 1;
        long long int mid;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            if (mid > 0 && mid < nums.size() - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (nums[0] > nums[1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (nums[nums.size() - 1] > nums[nums.size() - 2]) {
                    return nums.size() - 1;
                } else {
                    return nums.size() - 2;
                }
            }
        }
        return -1;
    }
};