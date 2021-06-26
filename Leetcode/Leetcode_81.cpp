class Solution {
public:
    bool search(vector<int> nums, int target)
    {
        int start = 0;
        int end = nums.size() - 1;
        int mid;

        while (start <= end)
        {
            mid = start + (end - start) / 2;

            if (nums[mid] == target)
            {
                return true;
            } 

            if (nums[start] < nums[mid] || nums[mid] > nums[end])
            {
                if (nums[start] <= target && target < nums[mid])
                {
                    end = mid - 1;
                }
                else
                {
                    start = mid + 1;
                }
            }
            else if (nums[end] > nums[mid] || nums[start] > nums[mid])
            {
                if (nums[end] >= target && nums[mid] < target)
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
            else
            {
                start += 1;
            }
        }
        return false;
    }
};