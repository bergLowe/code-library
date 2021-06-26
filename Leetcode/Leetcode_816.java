import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        int i, n = s.length();
        List<String> res = new ArrayList<>();
        for (i = 1; i < n - 2; i++) {
            List<String> listLeft = getSubstringList(s.substring(1, i + 1)), 
                            listRight = getSubstringList(s.substring(i + 1, n - 1));
            for (String a : listLeft) {
                for (String b : listRight) {
                    res.add("(" + a + ", " + b + ")");
                }
            }
        }
        return res;
    }

    private List<String> getSubstringList(String str) {
        int n = str.length();
        List<String> list = new ArrayList<>();

        if (n == 0 || (n > 1 && str.charAt(0) == '0' && str.charAt(n - 1) == '0')) {
            // If the length of string is 0 or the string starts and ends with 0.
            return list;
        }

        if (n > 1 && str.charAt(0) == '0') {
            // If the string starts with 0 and doesn't end with 0, then we can show it as
            // decimal. Eg: 012 -> 0.12.
            list.add("0." + str.substring(1));
            return list;
        }

        // If string is simply a number,
        // then simply add it to list as it will be used.
        list.add(str);

        if (n == 1 || str.charAt(n - 1) == '0') {
            // If the string length is 1, that is 1 digit number,
            // then it has been added in list and we then simply send it back.
            return list;
        }

        for (int i = 1; i < n; i++) {
            // If it is a number, then decimal will be added.
            // Eg: 123 -> 1.23 -> 12.3
            list.add(str.substring(0, i) + "." + str.substring(i));
        }

        return list;
    }
}