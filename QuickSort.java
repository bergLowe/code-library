import java.util.Arrays;

// Time Complexity: O(n * log n) <- Average
// Space Complexity: O(n * log n)
public class QuickSort {

    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int pivot = partition(arr, begin, end);
            
            quickSort(arr, begin, pivot - 1);
            quickSort(arr, pivot, end);
        }
    }

    static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int storeIndex = begin - 1;

        for (int i = begin; i < end; i++) {
            if (arr[i] < pivot) {
                storeIndex++;
                swap(arr, i, storeIndex);
            }
        }
        swap(arr, storeIndex + 1, end);

        return storeIndex + 1;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{89, 12, 73, 5, 0, -15, 28, 51, -10, 92};
        quickSort   (arr, 0, 9);
        Arrays.stream(arr).forEach(System.out::println);
    }
}