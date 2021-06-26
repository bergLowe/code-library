// https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int result = 0;
        int start = 1;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < piles.length; i++) {
            if (end < piles[i]) {
                end = piles[i];
            }
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isValid(piles, h, mid)) {
                result = mid;
                end = mid - 1; 
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    private boolean isValid (int[] piles, int numHours, int maxBananas) {
        int hours = 0;

        for (int i = 0; i < piles.length; i++) {

            if (piles[i] > maxBananas) {
                hours += (piles[i] / maxBananas) + (piles[i] % maxBananas == 0 ? 0 : 1);
            } else {
                hours++;
            }

            if (hours > numHours) return false;
        }

        return true;
    }
}