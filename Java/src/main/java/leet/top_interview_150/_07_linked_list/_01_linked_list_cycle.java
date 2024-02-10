package leet.top_interview_150._07_linked_list;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 */
public class _01_linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();

        ListNode current = head;
        while(current != null){
            if(nodesSeen.contains(current)){
                return true;
            }
            nodesSeen.add(current);
            current = current.next;
        }
        return false;
    }
}
 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
