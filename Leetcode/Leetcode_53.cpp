class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int curr_max = 0, max = INT_MIN;

        for (int i = 0; i < nums.size(); i++) {
            curr_max += nums[i];
            if (max < curr_max) {
                max = curr_max;
            }
            if (curr_max < 0) {
                curr_max = 0;
            }
        }

        return max;
    }
};