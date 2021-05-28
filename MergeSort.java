import java.util.Arrays;

// Time Complexity: O(n * log n)
// Space Complexity: O (n)
public class MergeSort {

    static void merge (int[] arr, int begin, int mid, int end) {
        // Calculating the length 
        int aSize = mid - begin + 1;
        int bSize = end - mid;

        int[] A = new int[aSize];
        int[] B = new int[bSize];

        // Creating temporary array and 
        // copying elements into it.
        for (int i = 0; i < aSize; i++) {
            A[i] = arr[begin + i];
        }
        for (int i = 0; i < bSize; i++) {
            B[i] = arr[mid + 1 + i];
        }

        // Three important pointers.
        int aIndex = 0,
            bIndex = 0,
            arrIndex = begin;

        while (aIndex < aSize && bIndex < bSize) {
            if (A[aIndex] <= B[bIndex]) {
                arr[arrIndex] = A[aIndex];
                aIndex++;
            } else {
                arr[arrIndex] = B[bIndex];
                bIndex++;
            }
            arrIndex++;
        }

        while (aIndex < aSize) {
            arr[arrIndex] = A[aIndex];
            aIndex++;
            arrIndex++;
        }

        while (bIndex < bSize) {
            arr[arrIndex] = B[bIndex];
            bIndex++;
            arrIndex++;
        }
    }

    static void mergeSort (int[] arr, int begin, int end) {
        if (begin < end) {
            // Dividing the array
            int mid = begin + (end - begin) / 2;

            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, begin, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{89, 12, 73, 5, 0, -15, 28, 51, -10, 92};
        mergeSort(arr, 0, 9);
        Arrays.stream(arr).forEach(System.out::println);
    }
}