package ktw.basic._07_recursive_tree_graph;

/*
부분 집합 구하기 (DFS)
 */
public class _06_recursive {
    static int n;
    static int[] ch;

    public void DFS(int L) {
        if (L == n + 1) {
            String temp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    temp += (i + " ");
                }
            }
            System.out.println(temp);
        } else {
            ch[L] = 1;  // 사용
            DFS(L + 1);
            ch[L] = 0;  // 사용하지 않음
            DFS(L + 1);
        }
    }
    public static void main(String[] args) {
        _06_recursive recursive = new _06_recursive();
        n = 3;
        ch = new int[n + 1];    // index 번호를 원소로 생각함.
        recursive.DFS(1);
    }
}
