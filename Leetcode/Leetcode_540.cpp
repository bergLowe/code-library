class Solution {
public:
    int singleNonDuplicate(vector<int>& nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        for (int i = 0; i < nums.size(); i += 1) {
            if (nums[i + 1] - nums[i] != 0) {
                return nums[i];
            }
            i += 1;
        }
        return -1;
    }
};