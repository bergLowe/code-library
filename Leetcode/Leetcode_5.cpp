class Solution {
public:
    int beginIndex;
    int length;
    Solution() {
        beginIndex = 0;
        length = 0;
    }
    
    string longestPalindrome(string s) {
        int size = s.length();
        if (size < 2) return s;
        
        for (int i = 0; i < size - 1; i++) {
            expandRange(s, i, i, size);
            expandRange(s, i, i + 1, size);
        }
        // cout << beginIndex << " " << length << endl;
        return s.substr(beginIndex, length);
    }
    
    void expandRange(string s, int begin, int end, int size) {
        while (begin >= 0 && end < size && s[begin] == s[end]) {
            begin--;
            end++;
        }
        int len = end - begin - 1;
        if (length < len) {
            beginIndex = begin + 1;
            length = len;
        }
    }
};