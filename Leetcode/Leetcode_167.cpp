class Solution {
public:
    vector<int> twoSum(vector<int>& num, int target) {
        vector<int> a;
        int start = 0; 
        int end = num.size() - 1;
        int temp;
        while (start <= end) {
            temp = num[start] + num[end];
            if (temp == target) {
                a.push_back(start + 1);
                a.push_back(end + 1);
                return a;
            } else if (temp < target) {
                start += 1;
            } else {
                end -= 1;
            }
        }
        return a;
    }
};