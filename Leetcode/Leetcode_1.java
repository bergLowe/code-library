// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i, j;
        int[] ab = new int[2];
        for(i=0; i<nums.length; i++) {
            for(j=0; j<nums.length; j++) {
                if((nums[i] + nums[j]) == target && i != j) {
                    ab[0] = j;
                    ab[1] = i;
                    break;
                }
            }
        }
        return ab;
    }
}