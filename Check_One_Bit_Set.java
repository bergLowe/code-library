public class Check_One_Bit_Set {

    private static boolean checkExactlyOneBitSet (int bitArray) {
        return (bitArray & (bitArray - 1)) == 0;
    }

    public static void main(String[] args) {
        int a = 2;  // 010
        int b = 32; // 100000
        int c = 35; // 100011

        System.out.println(checkExactlyOneBitSet(a));
        System.out.println(checkExactlyOneBitSet(b));
        System.out.println(checkExactlyOneBitSet(c));
    }
}
