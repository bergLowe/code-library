#include <bits/stdc++.h>

using namespace std;

// Time: O(nk)
// Space: O(nk)
// For space optimized algorithm, check: BinomialCoeff_DP_SpaceOpt.cpp
int bin_coeff (int n, int k) {
    int i, j;
    vector<vector<int>> C (n + 1, vector<int>(k + 1, 0));

    for (i = 0; i <= n; i++) {
        for (j = 0; j <= min(i, k); j++) {
            if (j == 0 || j == i) {
                C[i][j] = 1;
            } else {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
    }

    return C[n][k];
}

int main() {

    // To find 4C3

    cout << bin_coeff(4, 3);

    return 0;
}