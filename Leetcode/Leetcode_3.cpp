class Solution {
public:
    int lengthOfLongestSubstring(string str) {
        deque<char> s;
        int length = 0;
        if (str.size() == 1) {
            return 1;
        }
        for (int i = 0; i < str.size(); i += 1)
        {
            if (!(find(s.begin(), s.end(), str[i]) != s.end()))
            {
                s.push_back(str[i]);
            }
            else
            {
                while (find(s.begin(), s.end(), str[i]) != s.end()) {
                    s.pop_front();
                }
                s.push_back(str[i]);
            }
            if (s.size() > length)
            {
                length = s.size();
            }
        }
        return length;
    }
};