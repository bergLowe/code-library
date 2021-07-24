import java.util.HashMap;
import java.util.Map;

class Node {
    public Node front;
    public Node back;
    public int key;
    public int value;
    Node (int key, int value) { 
        this.key = key;
        this.value = value;
        this.front = null;
        this.back = null;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private int size;
    private int capacity;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.head = null;
        this.tail = null;
        this.size = 0;
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        // Update the linked list after accessing the key.
        Node node = map.get(key);
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateNode(node);
        } else {
            Node node = new Node(key, value);
            if (isFull()) {
                removeLRUCache();
            }
            map.put(key, node);
            addToList(node);
        }
    }

    private void updateNode (Node node) {
        // If the accessed node is already the most recently used 
        // we do not change anything in the linked list.
        if (head == node) return ;

        Node prev = node.back;
        Node next = node.front;
        
        if (tail == node) tail = prev;
        
        if (prev != null) {
            prev.front = next;
        }
        
        if (next != null) {
            next.back = prev;
        }
        
        node.front = node.back = null;
        size -= 1;
        addToList(node);
    }

    private void addToList (Node node) {
        if (isEmpty()) {
            head = tail = node;
        } else {
            node.front = head;
            head.back = node;
            head = node;
        }
        size += 1;
    }

    private void removeLRUCache () {
        size -= 1;
        map.remove(tail.key);
        tail = tail.back;
        if (tail != null) {
            tail.front = null;
        }
        if (size == 0) {
            head = tail = null;
        }
    }

    private boolean isFull () {
        return size == capacity;
    }

    public boolean isEmpty () {
        return size == 0;
    }
}