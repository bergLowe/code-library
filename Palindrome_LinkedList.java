import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

class Solution {
    boolean isPalindrome(Node head) {
        Node fast = head;
        Node slow = head;
        Deque<Integer> stack = new ArrayDeque<>();

        while (fast != null && fast.next != null) {
            stack.offerFirst(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            System.out.println(slow.data);
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.data != stack.pollFirst()) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}