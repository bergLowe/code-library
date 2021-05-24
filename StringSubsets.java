// Time Complexity: O(n * 2^n)

public class StringSubsets {
    public static void main(String[] args) {
        subsets("REMUS");
    }

    static void subsets(String str) {
        int N = str.length();
        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
