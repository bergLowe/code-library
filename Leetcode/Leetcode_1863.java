class Solution {
    public int subsetXORSum(int[] nums) {
        int res = 0;
        for (int i = 1; i < (1 << nums.length); i++) {
            int xorTemp = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    xorTemp ^= nums[j];
                }
            }
            res += xorTemp;
        }
        return res;
    }
}