#include <bits/stdc++.h>

using namespace std;

int main() {
    int size, input;
    cin >> size;
    vector<int> arr;
    for (int i = 0; i < size; i++) {
        cin >> input;
        arr.push_back(input);
    }

    vector<int> lis(size, 1);
    for (int i = 1; i < size; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                lis[i] = max(lis[i], lis[j] + 1);
            }
        }
    }

    cout << *max_element(lis.begin(), lis.end()) << "\n";
    return 0;
}