package ktw.basic._07_recursive_tree_graph;

/**
 * 재귀함수는 스택프레임을 사용한다.
 *
 * 스택 프레임에는 매개변수, 지역변수, 복귀 주소 등이 저장된다.
 *
 * DFS(3) => DFS(2) => DFS(1)
 */
public class _01_recursive {

    public void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        _01_recursive _01_recursive = new _01_recursive();
        _01_recursive.DFS(3);
    }
}
