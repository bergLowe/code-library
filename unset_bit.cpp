#include <bits/stdc++.h>

using namespace std;

int unsetBit(int num, int index) {
    return (num & (~(1 << (index - 1))));
}

int main() {
    // 89 - 1011001
    // Unset 7th bit
    // 25 - 0011001
    cout << unsetBit(89, 7) << endl;
    return 0;
}