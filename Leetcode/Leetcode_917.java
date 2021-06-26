class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while ((start < end) && !isLetter(s.charAt(start))) {
                start++;
            }
            while ((start < end) && !isLetter(s.charAt(end))) {
                end--;
            }
            s = swapChars(s, start, end);
            start++;
            end--;
        }
        return s;
    }

    private String swapChars (String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    private boolean isLetter (char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}