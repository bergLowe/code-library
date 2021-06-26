class Solution {
public:
    bool judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        long long int start = 0;
        long long int end = sqrt(c);
        long long int mid;
        
        while (start <= end) {
            if (start * start + end * end == c) {
                return true;
            } else if (start * start + end * end > c) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        return false;
    }
};