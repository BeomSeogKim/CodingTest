package leet.top_interview_150._07_linked_list;

/*
 * https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan-v2&envId=top-interview-150
 */
public class _03_merge_two_sorted_lists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode();

        ListNode curr = dummyNode;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                curr.next = new ListNode(list2.val);
                curr = curr.next;
                list2 = list2.next;
            } else if (list2 == null) {
                curr.next = new ListNode(list1.val);
                curr = curr.next;
                list1 = list1.next;
            } else {
                if (list1.val >= list2.val) {
                    curr.next = new ListNode(list2.val);
                    curr = curr.next;
                    list2 = list2.next;
                } else {
                    curr.next = new ListNode(list1.val);
                    curr = curr.next;
                    list1 = list1.next;
                }
            }
        }
        return dummyNode.next;
    }
}


