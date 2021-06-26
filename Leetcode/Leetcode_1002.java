import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();
        int[] countAlpha = new int[26];
        Arrays.fill(countAlpha, Integer.MAX_VALUE);
        Arrays.stream(words).forEach(el -> {
            int[] cntChar = new int[26];
            el.chars().forEach(e -> ++cntChar[e - 'a']);
            for (int i = 0; i < 26; i++) {
                countAlpha[i] = Math.min(cntChar[i], countAlpha[i]);
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            while (countAlpha[c - 'a']-- > 0) {
                list.add("" + c);
            }
        }
        return list;
    }
}