class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int cmax = 0, gmax = 0;
        for (int i = 1; i < prices.size(); i++) {
            cmax += prices[i] - prices[i - 1];
            cmax = cmax < 0 ? 0 : cmax;
            gmax = max(gmax, cmax);
        }
        return gmax;
    }
};