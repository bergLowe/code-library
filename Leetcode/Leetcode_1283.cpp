// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    
    bool isValid(vector<int> nums, int thres, long long int mid) {
        long long int sum = 0, temp;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] < mid) {
                sum += 1;
            } else {
                temp = ceil((1.0 * nums[i]) / mid);
                sum += temp;
            }
            if (sum > thres) {
                return false;
            }
        }
        return true;
    }
    
    int smallestDivisor(vector<int>& nums, int threshold) {
        if (nums.size() == 1) {
            return ceil((1.0 * nums[0]) / threshold);    
        }
        
        long long int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
        }
        if (threshold > sum) {
            return 1;
        }
        long long int start = 1;
        long long int end = 1000000;
        long long int mid, result = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (isValid(nums, threshold, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    } 
};