import java.util.Arrays;
import java.util.Random;

public class MaxHeap {
    private int capacity;
    private int size;
    private int[] items;

    public MaxHeap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[this.capacity];
    }

    private int getParentIndex (int childIndex) { return (childIndex - 1) / 2; }
    private int getLeftChildIndex (int parentIndex) { return (2 * parentIndex) + 1; }
    private int getRightChildIndex (int parentIndex) { return (2 * parentIndex) + 2; }

    private boolean hasParent (int index) { return getParentIndex(index) >= 0; }
    private boolean hasLeftChild (int index) { return getLeftChildIndex(index) < this.size; }
    private boolean hasRightChild (int index) { return getRightChildIndex(index) < this.size; }

    private int getParent (int index) { return this.items[getParentIndex(index)]; }
    private int getLeftChild (int index) { return this.items[getLeftChildIndex(index)]; }
    private int getRightChild (int index) { return this.items[getRightChildIndex(index)]; }

    private void swap (int indexOne, int indexTwo) {
        int temp = this.items[indexOne];
        this.items[indexOne] = this.items[indexTwo];
        this.items[indexTwo] = temp;
    }

    private void ensureCapacity () {
        if (this.size == this.capacity) {
            this.items = Arrays.copyOf(items, this.capacity * 2);
            this.capacity *= 2;
        }
    }

    private void heapifyUp () {
        int index = this.size - 1;
        while (hasParent(index) && getParent(index) < this.items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown () {
        int index = 0;
        while (hasLeftChild(index)) {
            int largerChildIndex = getLeftChildIndex(index);
            
            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
                largerChildIndex = getRightChildIndex(index);
            }
            
            if (this.items[index] > this.items[largerChildIndex]) {
                break;
            } else {
                swap(index, largerChildIndex);
            }
            index = largerChildIndex;
        }
    }

    public int getSize () { return this.size; }

    public void add (int item) {
        ensureCapacity();
        this.items[this.size] = item;
        this.size += 1;
        heapifyUp();
    }

    public int peek () { 
        if (size == 0) throw new IllegalStateException();
        return this.items[0];
    }

    public int poll () {
        if (this.size == 0) throw new IllegalStateException();
        int item = this.items[0];
        this.items[0] = this.items[this.size - 1];
        this.size -= 1;
        heapifyDown();
        return item;
    }
    
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap();
        for (int i = 0; i < 20; i++) {
            heap.add(new Random().nextInt(100) + 1);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(heap.poll() + " ");
        }
    }
}
