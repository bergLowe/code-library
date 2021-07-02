class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        
        while (start < end) {
            mid = start + (end - start) / 2;
            
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end -= 1;
            }
        }
        return nums[start];
    }
};