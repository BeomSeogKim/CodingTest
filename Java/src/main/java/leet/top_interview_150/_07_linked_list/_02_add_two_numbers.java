package leet.top_interview_150._07_linked_list;

/*
 * https://leetcode.com/problems/add-two-numbers/?envType=study-plan-v2&envId=top-interview-150
 */
public class _02_add_two_numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while(l1 != null || l2 != null || carry != 0){
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }

}
