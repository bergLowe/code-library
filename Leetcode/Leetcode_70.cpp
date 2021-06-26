class Solution {
public:
    int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        int f1 = 2, f2 = 1, total = 0;
        for (int i = 2; i < n; i++) {
            total = f1 + f2;
            f2 = f1;
            f1 = total;
        }
        return total;
    }
};