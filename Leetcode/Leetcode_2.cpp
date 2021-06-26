class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode * result = new ListNode();
        ListNode * head = result;
        ListNode * tempor;
        
        int sum, carry = 0, temp;
        
        while (l1 != NULL or l2 != NULL) {
            if (l1 != NULL && l2 != NULL) {
                sum = l1->val + l2->val;
                
                l1 = l1->next;
                l2 = l2->next;
            } else if (l1 != NULL) {
                sum = l1->val;
                l1 = l1->next;
            } else if (l2 != NULL) {
                sum = l2->val;
                l2 = l2->next;
            }
            if (carry > 0) {
                sum += carry;
                carry = 0;
            }
            if (sum > 9) {
                temp = sum;
                temp = temp % 10;
                carry = sum / 10;
                sum = temp;
            }
            tempor = new ListNode();
            tempor->val = sum;
            result->next = tempor;
            result=result->next;
        }
        if (carry > 0) {
            tempor = new ListNode();
            tempor->val = carry;
            result->next = tempor;
            result=result->next;
        }
        return head->next;
    }
};