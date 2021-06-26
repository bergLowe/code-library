// https://leetcode.com/problems/split-array-largest-sum/

class Solution {
    public int splitArray(int[] nums, int m) {
        int start = Integer.MIN_VALUE;
        int end = 0;
        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (start < nums[i]) {
                start = nums[i];
            }
            end += nums[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int temp = getMaxSumOfSubarray(nums, m, mid);
            if (temp != -1) {
                if (minSum > temp) {
                    minSum = temp;
                }
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minSum;
    }

    private int getMaxSumOfSubarray (int[] nums, int m, int max) {
        int maxSum = Integer.MIN_VALUE;
        int parts = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                if (maxSum < (sum - nums[i])) {
                    maxSum = sum - nums[i];
                }
                parts += 1;
                sum = nums[i];
            }
            if (parts > m) return -1;
        }
        if (maxSum < sum) {
            maxSum = sum;
        }
        return maxSum;
    }
}