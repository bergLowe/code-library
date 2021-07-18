/*
Input:
    l1: 2 -> 4 -> 3
    l2: 5 -> 6 -> 4
Output:
    result: 7 -> 0 -> 8 // 342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private ListNode addTwoNumbersHelper (ListNode l1, ListNode l2, int carry) {
        // If there is no value to be added, there shouldn't be any initialisation of node.
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        ListNode result = new ListNode();
        int value = carry;
        
        if (l1 != null) {
            value += l1.val;
        }

        if (l2 != null) {
            value += l2.val;
        }

        result.val = value % 10;

        if (l1 != null || l2 != null) {
            ListNode nextNode = addTwoNumbersHelper(l1 == null ? null : l1.next, 
                                                    l2 == null ? null : l2.next, 
                                                    value >= 10 ? 1 : 0);
            // Adding values in front.
            result.next = nextNode;
        }
        return result;
    }
}