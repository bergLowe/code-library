/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * class MountainArray {
 *   public:
 *     int get(int index);
 *     int length();
 * };
 */

class Solution {
public:
    int findInMountainArray(int target, MountainArray &mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);
        int lowIndex = ascBS(mountainArr, 0, peakIndex - 1, target);
        if (lowIndex != -1) {
            return lowIndex;
        }
        int highIndex = dscBS(mountainArr, peakIndex, mountainArr.length() - 1, target);
        if (highIndex != -1) {
            return highIndex;
        }
        
        return -1;
    }
    
    int ascBS(MountainArray arr, int start, int end, int target) {
        
        long long int mid, tempM;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            tempM = arr.get(mid);
            
            if (tempM == target) {
                return mid;
            }
            
            if (tempM > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return -1;
    }
    
    int dscBS(MountainArray arr, int start, int end, int target) {
        
        long long int mid, tempM;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            tempM = arr.get(mid);
            
            if (tempM == target) {
                return mid;
            }
            
            if (tempM > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
    
    int peakIndexInMountainArray(MountainArray &arr) {
        if (arr.length() == 1) {
            return 0;
        }
        
        long long int start = 0;
        long long int end = arr.length() - 1;
        long long int mid;
        long long int tempL, tempH, tempM;
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            
            if (mid > 0 && mid < arr.length() - 1) {
                tempL = arr.get(mid - 1);
                tempH = arr.get(mid + 1);
                tempM = arr.get(mid);
                if (tempM > tempL && tempM > tempH) {
                    return mid;
                } else if (tempL > tempM) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr.get(0) > arr.get(1)) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                if (arr.get(arr.length() - 1) > arr.get(arr.length() - 2)) {
                    return arr.length() - 1;
                } else {
                    return arr.length() - 2;
                }
            }
        }
        return -1;
    }
};