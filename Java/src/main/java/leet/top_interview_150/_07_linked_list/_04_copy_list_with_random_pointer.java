package leet.top_interview_150._07_linked_list;


import java.util.HashMap;
import java.util.Map;

public class _04_copy_list_with_random_pointer {
    Map<Node2, Node2> visited = new HashMap<>();

    public Node2 copyRandomList(Node2 head) {
        if(head == null){
            return null;
        }

        if(visited.containsKey(head)){
            return visited.get(head);
        }

        Node2 node = new Node2(head.val);
        visited.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}

class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
