class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> res;
        for (int a : nums) {
            auto it = lower_bound(res.begin(), res.end(), a);
            if (it == res.end()) res.push_back(a);
            else *it = a;
        }
        return res.size();
    }
};