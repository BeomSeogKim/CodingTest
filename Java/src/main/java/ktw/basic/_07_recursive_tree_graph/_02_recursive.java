package ktw.basic._07_recursive_tree_graph;

/**
 * 재귀 함수를 이용한 이진수 출력
 *
 * 10진수 N이 입력되었을 때 2진수로 변환하여 출력하는 프로그램을 작성하세요
 */
public class _02_recursive {

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            System.out.print(n % 2 + " ");
        }
    }
    public static void main(String[] args) {
        _02_recursive recursive = new _02_recursive();
        recursive.DFS(11);
    }
}
