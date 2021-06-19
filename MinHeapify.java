public class MinHeapify {

    public void buildMinHeapify(int[] arr) {
        int size = arr.length - 1;
        
        for (int i = size; i >= 0; i--) {
            minHeapify(arr, i, size);
        }
    }
    
    private void minHeapify (int[] arr, int index, int size) {
        int left = (2 * index) + 1;
        int right = (2 * index) + 2;
        int smallest = index;

        if (left <= size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        
        if (right <= size && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(arr, index, smallest);
            minHeapify(arr, smallest, size);
        }
    }

    private void swap (int[] arr, int indexOne, int indexTwo) {
        if (indexOne == indexTwo) return ;

        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }
}