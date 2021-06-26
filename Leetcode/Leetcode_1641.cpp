class Solution {
public:
    int countVowelStrings(int n) {
        // Using Combination formula for repetition. 
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }
};