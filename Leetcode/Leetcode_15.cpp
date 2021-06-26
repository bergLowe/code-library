class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> arr;
		if (nums.size() <= 2) {
			return arr;
		}
		sort(nums.begin(), nums.end());
		vector<int> temp;
		int select, start, end, sum;
		for (int i = 0; i < nums.size() - 2; i++) {
			select = nums[i];
			start = i + 1;
			end = nums.size() - 1;
			while (start < end) {
				sum = select + nums[start] + nums[end];
				if (sum < 0) start++;
				else if (sum > 0) end--;
				else {
					temp = {nums[i], nums[start], nums[end]};
					arr.push_back(temp);
					while (start < end && nums[start] == temp[1]) start++;
					while (start < end && nums[end] == temp[2]) end--;
				}
			}
			while (i + 1 < nums.size() && nums[i] == nums[i + 1]) i++;
		}

        return arr;
    }
};