#include <bits/stdc++.h>
using namespace std;

// Recursion Method
int lcs(string s, string t, int sLen, int tLen) {
    if (sLen <= 0 || tLen <= 0) {
        return 0;
    }

    if (s[sLen - 1] == t[tLen - 1]) {
        return 1 + lcs(s, t, sLen - 1, tLen - 1);
    } else {
        return max(lcs(s, t, sLen - 1, tLen), lcs(s, t, sLen, tLen - 1));
    }
}

int main() {
    string s = "abc";
    string t = "ahbgdc";
    int length = lcs(s, t, s.size(), t.size());
    cout << length << endl;
    return 0;
}