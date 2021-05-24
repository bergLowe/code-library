// Prints Power of 2 between [1, n]
// Time Complexity: O(log n)
public class Num_PowerOf2 {

    static int powersOf2(int n) {
        if (n < 1) return 0;
        else if (n == 1) {
            System.out.println(1);
            return 1;   
        }
        else {
            int prev = powersOf2(n / 2);
            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }
    }

    public static void main(String[] args) {
        System.out.println("Maximum number which is power of 2 and lies in [1, n]: " + powersOf2(200));
    }
}
