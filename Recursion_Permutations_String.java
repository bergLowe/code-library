public class Recursion_Permutations_String {

    static void swap (char[] str, int indexOne, int indexTwo) { 
        char temp = str[indexOne];
        str[indexOne] = str[indexTwo];
        str[indexTwo] = temp;
    }

    static void permutation (char[] str, int start, int end) {
        if (start == end) {
            System.out.println(String.valueOf(str));
        }
        for (int i = start; i <= end; i++) {
            swap(str, start, i);

            permutation(str, start + 1, end);

            swap(str, start, i);
        }
    }

    public static void main(String[] args) {
        String str = "ABCD";
        char[] strArr = str.toCharArray();
        permutation(strArr, 0, strArr.length - 1);
    }
}