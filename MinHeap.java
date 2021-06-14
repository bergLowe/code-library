import java.util.Arrays;
import java.util.Random;

public class MinHeap {
    private int capacity;
    private int size;
    private int[] items;

    public MinHeap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[this.capacity];
    }

    private int getLeftChildIndex (int parentIndex) { return (2 * parentIndex) + 1; }
    private int getRightChildIndex (int parentIndex) { return (2 * parentIndex) + 2; }
    private int getParentIndex (int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild (int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild (int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent (int index) { return getParentIndex(index) >= 0; }

    private int leftChild (int index) { return items[getLeftChildIndex(index)]; }
    private int rightChild (int index) { return items[getRightChildIndex(index)]; }
    private int parent (int index) { return items[getParentIndex(index)]; }

    private void swap (int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity () {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyUp () {
        int index = this.size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            // Re-assigning the index, after swapping with the parent.
            index = getParentIndex(index);
        }
    }

    private void heapifyDown () {
        int index = 0;
        // We only check for left child, becuause if there is no left child,
        // there won't be any right child.
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            // If the right child value is less than left child, then smallerChildIndex will
            // be re-assigned with right child index.
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                // If the element at index is even lesser then both the child,
                // then everything is alright.  
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public int peek () {
        if (this.size == 0) throw new IllegalStateException();
        return items[0];
    }

    public int poll () {
        if (this.size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[this.size - 1];
        this.size -= 1;
        heapifyDown();
        return item;
    }

    public void add (int item) {
        ensureCapacity();
        items[this.size] = item;
        this.size += 1;
        heapifyUp();
    }

    public int getSize() {
        return this.size;
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        for (int i = 0; i < 20; i++) {
            heap.add(new Random().nextInt(100) + 1);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(heap.poll() + " ");
        }
    }
}