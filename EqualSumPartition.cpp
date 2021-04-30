#include <bits/stdc++.h>

using namespace std;

bool isSubsetSum(vector<int> arr, int n, int sum) {

    bool subset[n + 1][sum + 1];

    for(int i = 0; i <= n; i++) {
        subset[i][0] = true;
    }

    for (int i = 1; i <= sum; i++) {
        subset[0][i] = false;
    }

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= sum; j++) {
            if (arr[i - 1] <= j) {
                subset[i][j] = subset[i - 1][j] || subset[i - 1][j - arr[i - 1]];
            } else {
                subset[i][j] = subset[i - 1][j];
            }
        }
    }

    return subset[n][sum];
}

bool canPartition(vector<int>& nums) {
    int sum = 0;
    for(int i = 0; i < nums.size(); i++) {
        sum += nums[i];
    }
    if (sum % 2 == 0) {
        return isSubsetSum(nums, nums.size(), sum / 2);
    } else {
        return false;
    }
}

int main() {
    
    vector<int> arr = {1, 5, 11, 5}; // true
    // vector<int> arr = {1, 2, 3, 5}; // false
    cout << canPartition(arr) << endl;
    
    return 0;
}