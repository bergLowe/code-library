class Solution {
public:
    int hammingWeight(uint32_t n) {
        long count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count += 1;
        }
        return count;
    }
};