class Solution {
public:
    int mySqrt(int x) {
        long long int start = 1; 
        long long int end = x;
        long long int index = -1;
        long long int mid;
        if (x == 0 || x == 1) {
            return x;
        }
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid == x) {
                index = mid;
                break;
            }
            if (mid * mid < x) {
                start = mid + 1;
                index = mid;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }
};