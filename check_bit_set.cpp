#include <bits/stdc++.h>

using namespace std;

bool checkBit(int num, int j) {
    return num & (1 << (j - 1));
}

int main() {
    // 89 -> 1011001
    for (int i = 0; i < 7; i++) {
        cout << checkBit(89, (i + 1));
    }
    return 0;
}