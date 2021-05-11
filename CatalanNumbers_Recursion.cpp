#include <bits/stdc++.h>

using namespace std;

unsigned long long int catalan(unsigned int n) {
    if (n <= 1) {
        return 1;
    }
    unsigned long long int res = 0;
    for (int i = 0; i < n; i++) {
        res += catalan(i) * catalan(n - i - 1);
    }
    return res;
}

int main() {

    for (int i = 0; i < 10; i++) {
        cout << catalan(i) << endl;
    }

    return 0;
}