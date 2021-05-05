#include <bits/stdc++.h>

using namespace std;

int countSetBits(int mask) {
    if (mask == 0) {
        return 0;
    }
    return 1 + countSetBits(mask & (mask - 1));
}

int main() {
    cout << countSetBits(6) << endl;
    return 0;
}