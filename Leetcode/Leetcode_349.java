// https://leetcode.com/problems/intersection-of-two-arrays/
import java.util.Arrays;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        int size = nums1.length >= nums2.length ? nums1.length : nums2.length;
        int[] arr = new int[size];
        Arrays.fill(arr, -1);
        int index = 0;
        for (int num : nums1) {
            if (Arrays.binarySearch(nums2, num) >= 0 && !(hasDuplicate(arr, num))) {
                arr[index++] = num;
            }
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private boolean hasDuplicate(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return true;
        }
        return false;
    }
}