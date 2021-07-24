class Detect_Loop_LinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) return true;
        }
        return false;
    }
}