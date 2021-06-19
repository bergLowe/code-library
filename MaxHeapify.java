public class MaxHeapify {
    
    public void buildMaxHeapify (int[] arr) {
        int size = arr.length - 1;

        for (int i = size / 2; i >= 0; i--) {
            maxHeapify(arr, i, size);
        }
    }

    private void maxHeapify (int[] arr, int index, int size) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        int largest = index;

        if (left <= size && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right <= size && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap (arr, index, largest);
            maxHeapify(arr, largest, size);
        }
    }

    private void swap (int[] arr, int indexOne, int indexTwo) {
        if (indexOne == indexTwo) return ;

        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}
