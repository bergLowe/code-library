// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int result = 0;
        int start = Integer.MIN_VALUE;
        int end = 0;

        for (int i = 0; i < weights.length; i++) {
            if (start < weights[i]) {
                start = weights[i];
            }
            end += weights[i];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(weights, days, mid)) {
                result = mid;
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private boolean isValid (int[] weights, int numDays, int maxWeight) {
        int days = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > maxWeight) {
                days += 1;
                sum = weights[i];
            }
            if (days > numDays) return false;
        }
        return true;
    }
}