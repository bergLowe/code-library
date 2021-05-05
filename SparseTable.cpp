#include <bits/stdc++.h>
#define MAX 100

using namespace std;

vector<vector<int>> lookup(MAX, vector<int>(MAX));

void preprocess (vector<int> arr) {
    // Preprocessing for finding Minimum number between ranges of array.
    int i, j;

    for (i = 0; i < arr.size(); i++) {
        lookup[i][0] = i;
    }

    for (j = 1; (1 << j) <= arr.size(); j++) {
//        cout << "J value: " << j << " | Condition: " << (1 << j) << endl;
        for (i = 0; (i + (1 << j) - 1) < arr.size(); i++) {
//            cout << "I value: " << i << " | Condition: " << (i + (1 << j) - 1) << endl;
            if (arr[lookup[i][j - 1]] < arr[lookup[i + (1 << (j - 1))][j - 1]]) {
//                cout << "IF\n" << lookup[i][j - 1] << " < " << lookup[i + (1 << (j - 1))][j - 1] << endl;
                lookup[i][j] = lookup[i][j - 1];
            } else {
//                cout << "ELSE\n" << lookup[i][j - 1] << " < " << lookup[i + (1 << (j - 1))][j - 1] << endl;
                lookup[i][j] = lookup[i + (1 << (j - 1))][j - 1];
            }
        }
    }

//    cout << endl << endl;
    for (i = 0; i < arr.size(); i++) {
        for (j = 0; j < arr.size(); j++) {
            cout << lookup[i][j] << " ";
        }
        cout << endl;
    }
}

int main() {
    preprocess({7, 2, 3, 0, 5, 10, 3, 12, 18});
    return 0;
}