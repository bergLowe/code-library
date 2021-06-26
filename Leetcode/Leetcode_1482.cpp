// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
#include <bits/stdc++.h>

using namespace std;

class Solution {
public:
    bool isValid(vector<int > arr, int m, int k, long long int maxDays) {
        int cnt = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] <= maxDays) {
                ++cnt;
                if (cnt == k) {
                    --m;
                    cnt = 0;
                }
            } else {
                cnt = 0;
            }
            if (m == 0) {
                return true;
            }
        }
        return false;
    }

    int minDays(vector<int> &bloomDay, int m, int k)
    {
        if (bloomDay.size() < (m * k))
        {
            return -1;
        }
        long long int start = *min_element(bloomDay.begin(), bloomDay.end());
        long long int end = *max_element(bloomDay.begin(), bloomDay.end());
        long long int mid, result;
        while (start <= end)
        {
            mid = start + (end - start) / 2;
            if (isValid(bloomDay, m, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
};