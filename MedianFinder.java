// https://medium.com/@eranda/running-median-with-heaps-829522330e8a
/*
    min_heap is used to store values greater than median.
    At root of min_heap, value which is just next to median or is smallest,
    among those large value is stored.

    Whereas, max_heap is used to store values less than median.
    At root of max_heap, value which is just less than median or is
    largest among those small values is stored.
*/
import java.util.Arrays;

public class MedianFinder {
    private int[] minHeap;
    private int[] maxHeap;
    private int minHeapCapacity;
    private int maxHeapCapacity;
    private int minHeapSize;
    private int maxHeapSize;
    private double median;

    public MedianFinder() {
        this.minHeapCapacity = 50000;
        this.maxHeapCapacity = 50000;
        this.minHeapSize = 0;
        this.maxHeapSize = 0;
        this.minHeap = new int[minHeapCapacity];
        this.maxHeap = new int[maxHeapCapacity];
        this.median = 0;
    }
    
    public void addNum (int num) {
        ensureCapacity();

        if (num < median) {
            // Storing values less than median in max_heap.
            maxHeap[maxHeapSize++] = num;

            // As the heap conditions will be valid in max_heap, so if
            // value stored is greater then root, we swap them.
            if (maxHeap[maxHeapSize - 1] > maxHeap[0]) {
                swap(maxHeap, maxHeapSize - 1, 0);
            }
        } else {
            // Storing values greater than median in min_heap.
            minHeap[minHeapSize++] = num;

            // As the heap conditions will be valid in min_heap, so if
            // value stored is less than root, we swap them.
            if (minHeap[minHeapSize - 1] < minHeap[0]) {
                swap(minHeap, minHeapSize - 1, 0);
            }
        }

        if (Math.abs(maxHeapSize - minHeapSize) > 1) {
            /*
            Shift one element from larger tree to smaller one.
            If max_heap size is greater we take root value from min_heap,
            and vice-versa. And re-adjust the tree according to heap conditions.

            We take root value from min_heap for max_heap because it is the smallest 
            among largest in min_heap and it will be the root of max_heap and vice-versa.

            The elements are shifted because the median has to be maintained, that is if even
            number of elements, then roots of both tree are median and if one is greater than other,
            greater one root is the median.
            */
            if (maxHeapSize > minHeapSize) {
                swap(maxHeap, maxHeapSize - 1, 0);
                minHeap[minHeapSize++] = maxHeap[--maxHeapSize];
                swap(minHeap, 0, minHeapSize - 1);
                buildMaxHeapify(maxHeap, maxHeapSize);
            } else {
                swap(minHeap, minHeapSize - 1, 0);
                maxHeap[maxHeapSize++] = minHeap[--minHeapSize];
                swap(maxHeap, 0, maxHeapSize - 1);
                buildMinHeapify(minHeap, minHeapSize);
            }
        }

        if (maxHeapSize == minHeapSize) {
            this.median = (minHeap[0] + maxHeap[0]) / 2.0;
        } else if (maxHeapSize > minHeapSize) {
            this.median = maxHeap[0];
        } else {
            this.median = minHeap[0];
        }
    }
    
    public double findMedian () {
        return this.median;
    }

    private void ensureCapacity () {
        if (minHeapSize == minHeapCapacity) {
            minHeap = Arrays.copyOf(minHeap, minHeapCapacity * 2);
            minHeapCapacity *= 2;
        }

        if (maxHeapSize == maxHeapCapacity) {
            maxHeap = Arrays.copyOf(maxHeap, maxHeapCapacity * 2);
            maxHeapCapacity *= 2;
        }
    }

    private void swap (int[] arr, int indexOne, int indexTwo) {
        if (indexOne == indexTwo) return ;

        int temp = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = temp;
    }

    private void buildMaxHeapify (int[] arr, int heapSize) {
        int size = heapSize - 1;

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

    private void buildMinHeapify(int[] arr, int heapSize) {
        int size = heapSize - 1;
        
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
}

class TempMain {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(3);
        mf.addNum(1);
        mf.addNum(16);
        mf.addNum(5);

        System.out.println(mf.findMedian());
    }
}