class Solution {
public:
    bool isPerfectSquare(int num) {
        long long int start = 0;
        long long int end = num - 1;
        long long int mid;
        if (num == 0 || num == 1) {
            return num;
        }
        while (start <= end) {
            mid = start + (end - start) / 2;
            cout << mid << endl;
            if (mid * mid == num) {
                return true;
            }
            if (mid * mid < num) {
                cout << "If: " << mid * mid << " < " << num << endl;
                start = mid + 1;
            } else {
                cout << "Else: " << mid * mid << " > " << num << endl;
                end = mid - 1;
            }
        }
        return false;
    }
};