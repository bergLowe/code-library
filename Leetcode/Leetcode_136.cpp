class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int man = 0;
        for (int i : nums) {
            man ^= i;
        }
        return man;
    }
};