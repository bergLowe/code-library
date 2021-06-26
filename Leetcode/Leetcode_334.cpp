class Solution {
public:
    bool increasingTriplet(vector<int>& nums) {
        vector<int> lis(nums.size(), 1);
        int cnt = 1;
        int temp = lis[0];
        for (int i = 1; i < nums.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    lis[i] = max(lis[i], lis[j] + 1);
                }
            }
            // cout << temp << " < " << lis[i] << endl;
            if (temp < lis[i]) {
                temp = lis[i];
                ++cnt;
            }
            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
};