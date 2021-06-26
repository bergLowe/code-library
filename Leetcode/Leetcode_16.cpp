class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        int start, end, sum, resSum;
        for (int i = 0; i < nums.size() - 2; i++) {
            start = i + 1;
            end = nums.size() - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                if (sum <= target) {
                    start++;
                } else if (sum > target) {
                    end--;
                }
                if (abs(sum - target) < abs(resSum - target)) {
                    resSum = sum;
                }
            }
        }
        return resSum;
    }
};