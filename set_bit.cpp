#include <bits/stdc++.h>

using namespace std;

int setBit(int num, int index) {
    return num | (1 << (index - 1));
}

int main() {
    // 10 -> 1010
    // 3rd position set bit
    // 14 -> 1110
    cout << setBit(10, 3) << endl;
    // 89 -> 1011001
    // 6th position set bit
    // 121 -> 1111001
    cout << setBit(89, 6) << endl;
    return 0;
}