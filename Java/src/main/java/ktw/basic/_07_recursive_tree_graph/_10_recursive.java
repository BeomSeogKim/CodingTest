package ktw.basic._07_recursive_tree_graph;

import java.util.LinkedList;
import java.util.Queue;

/*
Tree 말단 노드까지의 가장 짧은 경로 구하기 (BFS)
 */
public class _10_recursive {
    Node root;

    public int BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0; // level
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Node node = Q.poll();
                if (node.lt == null && node.rt == null) {
                    return L;
                }
                if (node.lt != null) {
                    Q.offer(node.lt);
                }
                if (node.rt != null) {
                    Q.offer(node.rt);
                }
            }
            L++;
        }
        return 0;
    }
    public static void main(String[] args) {
        _10_recursive tree = new _10_recursive();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
