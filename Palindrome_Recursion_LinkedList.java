// Result class keeps track of isPalindrome and next half of the list after the middle.
class Result {
    public Node nextHalfList;
    public boolean isPalindrome;

    public Result (Node head, boolean isPalindrome) {
        this.isPalindrome = isPalindrome;
        this.nextHalfList = head;
    }
}

class Solution {
    boolean isPalindrome(Node head) {
        int len = length(head);
        Result res = isPalindromeHelper(head, len);
        return res.isPalindrome;
    }

    private Result isPalindromeHelper (Node head, int length) {
        if (head == null || length <= 0) {
            // This is for the even number of nodes in the list.
            return new Result(head, true);
        } else if (length == 1) {
            // This is for the odd number of nodes in the list.
            // The middle element will be skipped here.
            return new Result(head.next, true);
        }

        Result res = isPalindromeHelper(head.next, length - 2);

        if (!res.isPalindrome || res.nextHalfList == null) {
            return res;
        }

        res.isPalindrome = head.data == res.nextHalfList.data;
        res.nextHalfList = res.nextHalfList.next;
        return res;
    }

    private int length (Node head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}