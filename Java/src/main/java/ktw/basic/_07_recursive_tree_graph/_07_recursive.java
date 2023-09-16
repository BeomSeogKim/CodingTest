package ktw.basic._07_recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

public class _07_recursive {

    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        _07_recursive recursive = new _07_recursive();
        recursive.root = new Node(1);
        recursive.root.lt = new Node(2);
        recursive.root.rt = new Node(3);
        recursive.root.lt.lt = new Node(4);
        recursive.root.lt.rt = new Node(5);
        recursive.root.rt.lt = new Node(6);
        recursive.root.rt.rt = new Node(7);

        recursive.BFS(recursive.root);
    }
}
