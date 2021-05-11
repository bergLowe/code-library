#include <bits/stdc++.h>
#define MAX 100

using namespace std;

unsigned long long int catalan (int N) {
    unsigned long long int dp[N + 1];
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= N; i++) {
        dp[i] = 0;
        for (int j = 0; j < i; j++) {
            dp[i] += dp[j] * dp[i - j - 1];
        }
    }

    return dp[N];
}

int main() {

    for (int i = 0; i < 10; i++) {
        cout << catalan(i) << endl;
    }

    return 0;
}