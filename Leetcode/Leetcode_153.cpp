class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0;
        int end = nums.size() - 1;
        int size = nums.size();


        int mid, next, prev;

        while (start <= end) {
            if (nums[start] <= nums[end]) {
                return nums[start];
            }
            mid = start + (end - start) / 2;
            next = (mid + 1) % size;
            prev = (mid + size - 1) % size;
            if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
};