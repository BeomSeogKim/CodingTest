package ktw.basic._07_recursive_tree_graph;

/*
이진 트리 순회 배우기
 */
public class _05_recursive {
    Node root;

    public void DFS(Node root) {
        if (root == null) {
            return;
        } else {
            // 전위 순회
            // System.out.println(root.data);
            DFS(root.lt);
            // 중위 순회
            // System.out.println(root.data);
            DFS(root.rt);
            // 후위 순회
            System.out.println(root.data);
        }
    }

    public static void main(String[] args) {
        _05_recursive recursive = new _05_recursive();
        recursive.root = new Node(1);
        recursive.root.lt = new Node(2);
        recursive.root.rt = new Node(3);
        recursive.root.lt.lt = new Node(4);
        recursive.root.lt.rt = new Node(5);
        recursive.root.rt.lt = new Node(6);
        recursive.root.rt.rt = new Node(7);

        recursive.DFS(recursive.root);
    }
}

class Node {
    int data;
    Node lt, rt;

    public Node(int val){
        data = val;
        lt = rt = null;
    }

}
