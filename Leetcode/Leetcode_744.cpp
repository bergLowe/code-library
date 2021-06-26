class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        int start = 0;
        int end = letters.size() - 1;
        
        if (letters[end] <= target || target == 'z') {
            return letters[0];
        }
        
        int mid;
        char res = '#';
        
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                res = letters[mid];
                end = mid - 1;
            }
        }
        return res;
    }
};