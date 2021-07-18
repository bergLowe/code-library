/*
Input:
    first:  4 -> 5
    second: 3 -> 4 -> 5
Output:
    result: 3 -> 9 -> 0 // 345 + 45 = 390
*/

class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }
}

// LinkedListSumHandler keeps track of the final Linked List and carry.
class LinkedListSumHandler {
    public Node sumNodes;
    public int carry;

    public LinkedListSumHandler () {
        this.sumNodes = null;
        this.carry = 0;
    }
}

class Solution {
    static Node addTwoLists(Node first, Node second) {
        int len1 = length(first);
        int len2 = length(second);

        // Adds padding if the length is not same.
        if (len1 < len2) {
            first = addPadding (first, len2 - len1);
        } else {
            second = addPadding (second, len1 - len2);
        }

        LinkedListSumHandler listSumHandler = addTwoListsHelper(first, second);

        // In the end if there are no carry leftover, we return sumNodes from handler,
        // otherwise we return new node by adding carry node in front of head.
        if (listSumHandler.carry == 0) {
            return listSumHandler.sumNodes;
        } else {
            Node head = addBefore(listSumHandler.sumNodes, listSumHandler.carry);
            return head;
        }
    }

    private static LinkedListSumHandler addTwoListsHelper (Node first, Node second) {
        if (first == null && second == null) {
            LinkedListSumHandler sum = new LinkedListSumHandler();
            return sum;
        }

        LinkedListSumHandler listSumHandler = addTwoListsHelper(first.next, second.next);

        int value = listSumHandler.carry + first.data + second.data;

        // Updates the sumNodes with next new result.
        Node result = addBefore(listSumHandler.sumNodes, value % 10);

        // LinkedListSumHandler instances are updated.
        listSumHandler.sumNodes = result;
        listSumHandler.carry = value / 10;
        return listSumHandler;
    }

    // Adds padding to the Linked List.
    // For example: (head => 5 -> 4, number of padding => 2),
    //              returns => 0 -> 0 -> 5 -> 4
    private static Node addPadding (Node head, int numPads) {
        for (int i = 0; i < numPads; i++) {
            head = addBefore(head, 0);
        }
        return head;
    }

    // Creates a new node with given data and add it in front of head.
    private static Node addBefore (Node head, int data) {
        Node node = new Node(data);
        if (head != null) {
            node.next = head;
        }
        return node;
    }

    private static int length (Node head) {
        int len = 0;
        while (head != null) { 
            len++;
            head = head.next;
        }
        return len;
    }
}