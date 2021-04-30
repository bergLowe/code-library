#include <bits/stdc++.h>
using namespace std;

// Recursion Method
int count(vector<int> coins, int m, int N) {
    // When we reach when N becomes 0.
    if (N == 0) return 1;
    // When larger number is subtracted from required N.
    if (N < 0) return 0;
    // When we don't have any coins to reach required N.
    if (m <= 0 && N > 0) return 0;
    return count(coins, m - 1, N) + count(coins, m, N - coins[m - 1]);
}

// Bottom-Up Method
int countNumWays(vector<int> coins, int N) {
    int m = coins.size(), i, j;
    int table[m + 1][N + 1];
    
    // If the N required is 0,
    // then number of ways will be 1, that is 0 itself.
    for (i = 0; i <= m; i++) {
        table[i][0] = 1;
    }
    // If there are N required is more than 1,
    // then number of ways will be 0.
    for (i = 1; i <= N; i++) {
        table[0][i] = 0;
    }

    for (i = 1; i <= m; i++) {
        for (j = 1; j <= N; j++) {
            if (coins[i - 1] <= j) {
                table[i][j] = table[i][j - coins[i - 1]] + table[i - 1][j];
            } else {
                table[i][j] = table[i - 1][j];
            }
        }
    }
    return table[m][N];
}

int main() {
    int N = 4;
    vector<int> arr {1,2,3};
    cout << countNumWays(arr, N) << endl;
    cout << count(arr, arr.size(), N) << endl;
    return 0;
}