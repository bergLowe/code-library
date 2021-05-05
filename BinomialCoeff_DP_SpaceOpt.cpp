#include <bits/stdc++.h>

using namespace std;

// Time: O(nk)
// Space: O(k)
// Use this algorithm only if you need one row of Pascal Triangle.
int bin_coeff (int n, int k) {
    int i, j;
    vector<int> C (k + 1, 0);
    C[0] = 1;

    for (i = 1; i <= n; i++) {
        for (j = min(i, k); j > 0; j--) {
            C[j] = C[j] + C[j - 1];
        }
    }

    return C[k];
}

int main() {

    // To find 4C3

    cout << bin_coeff(4, 3);

    return 0;
}