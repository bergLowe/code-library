#include <bits/stdc++.h>

using namespace std;

int bin_coeff (int n, int k) {
    if (k == 0 || k == n) {
        return 1;
    }
    return bin_coeff(n - 1, k - 1) + bin_coeff(n - 1, k);
}

int main() {

    // To find 4C3

    cout << bin_coeff(12, 10);

    return 0;
}