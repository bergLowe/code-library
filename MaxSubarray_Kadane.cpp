#include <bits/stdc++.h>
using namespace std;

// Using Kadane's Algorithm
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

// Extra:
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

int main() {
    vector<int> arr {-2,1,-3,4,-1,2,1,-5,4};
    cout << maxSubArray(arr) << endl;

    vector<int> arr1 {2,3,-2,4};
    cout << maxProduct(arr1) << endl;

    return 0;
}