class Solution {
public:
    int maxArea(vector<int>& height) {
        int first = 1;
		int last = height.size();
		long long int area = INT_MIN, product;
		while (first < last) {
			product = (last - first) * (height[first - 1] > height[last - 1] ? height[last - 1] : height[first - 1]);
			if (product > area) {
				area = product;
			}
			height[first - 1] > height[last - 1] ? last-- : first++;
		}
		return area;
    }
};