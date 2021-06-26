class Solution {
public:
   int maxProduct(vector<int>& nums) {
        if (nums.size() == 0) {
            return INT_MIN;
        }
        int local_min, local_max, global_max, temp;
        local_min = local_max = global_max = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            temp = local_max;
            local_max = max(nums[i], max(nums[i] * local_max, nums[i] * local_min));
            local_min = min(nums[i], min(nums[i] * local_min, nums[i] * temp));
            global_max = max(local_max, global_max);
        }

        return global_max;
    }
};