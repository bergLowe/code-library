// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

class Solution {
    public int minPartitions(String n) {
        int value = -1;
        for (int i = 0; i < n.length(); i++) {
            if (value < (n.charAt(i) - '0')) {
                value = n.charAt(i) - '0';
                if (value == 9) return 9;
            }
        }
        return value;
    }
}