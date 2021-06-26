class Solution {
public:
    int countGoodSubstrings(string str) {
        if (str.length() < 3) return 0;
        int i, j, cnt = 0;
        for (i = 0; i < str.length() - 2; i++) {
            set<char> s;
            for (j = i; j < (i + 3); j++) {
                s.insert(str[j]);
            }
            if (s.size() == 3) cnt++;
        }
        return cnt;
    }
};