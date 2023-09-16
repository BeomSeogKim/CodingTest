package ktw.basic._07_recursive_tree_graph;

/**
 * 자연수 N이 입력되었을 때 N!을 구하는 프로그램을 작성하세요
 */
public class _03_recursive {

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }
    public static void main(String[] args) {
        _03_recursive recursive = new _03_recursive();
        System.out.println(recursive.DFS(5));
    }
}
