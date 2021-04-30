#include <bits/stdc++.h>
using namespace std;

void backtrackToPrint(vector<vector<int>> dp, vector<int> wt, vector<int> val, int n, int W) {
    int res = dp[n][W];
    int col = W, i;
    cout << "Printing selected weights: \n";
    for (i = n; i > 0; i--) {
        // If value is taken from table[i - 1][j],
        // then it signifies that it is not selected.
        // Otherwise if taken from table[i - 1][j - wt[i - 1]],
        // it is selected.
        if (res == dp[i - 1][col]) {
            continue;
        } else {
            cout << "Index: " << i << " | " << wt[i - 1] << endl;
            res = res - val[i - 1];
            col = col - wt[i - 1];
        }
    }
}

//Bottom-Up Approach
int knapsack(vector<int> wt, vector<int> val, int n, int capacity) {
    vector<vector<int>> table (n + 1, vector<int>(capacity + 1));
    int i, j;
    for (i = 0; i < n + 1; i++) {
        table[i][0] = 0;
    }
    for (i = 1; i <= capacity; i++) {
        table[0][i] = 0;
    }

    for (i = 1; i <= n; i++)
    {
        for (j = 1; j <= capacity; j++)
        {
            if (wt[i - 1] <= j) {
                table[i][j] = max(val[i - 1] + table[i - 1][j - wt[i - 1]], table[i - 1][j]);
            } else {
                table[i][j] = table[i - 1][j];
            }
        }
        
    }

    // Printing table.
    for (i = 0; i <= n; i++)
    {
        for (j = 0; j <= capacity; j++)
        {
            cout << table[i][j] << " ";
        }
        cout << endl;
    }
    
    backtrackToPrint(table, wt, val, n, capacity);
    
    return table[n][capacity];
}

int main() {
    cout << knapsack({2,1,3,2}, {12,10,20,15}, 4, 5) << endl;
    return 0;
}