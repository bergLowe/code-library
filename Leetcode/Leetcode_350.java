import java.util.Arrays;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int size = nums1.length >= nums2.length ? nums2.length : nums1.length;
        int[] arr = new int[size];
        int pnt1 = 0, pnt2 = 0, index = 0;

        while (pnt1 < nums1.length && pnt2 < nums2.length) {
            if (nums1[pnt1] > nums2[pnt2]) {
                pnt2++;
            } else if (nums1[pnt1] < nums2[pnt2]) {
                pnt1++;
            } else {
                arr[index++] = nums1[pnt1];
                pnt1++;
                pnt2++;
            }
        }

        return Arrays.copyOf(arr, index);
    }
}