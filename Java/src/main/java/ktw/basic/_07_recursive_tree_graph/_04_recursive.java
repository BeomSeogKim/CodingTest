package ktw.basic._07_recursive_tree_graph;

/**
 * 피보나치 재귀로 작성하는 함수 구현 (메모제이션)
 */
public class _04_recursive {

    /*
    일반적으로 짜는 코드
     */
    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return DFS(n - 2) + DFS(n - 1);
        }
    }

    /*
    일반적으로 짜는 코드 + 약간의 성능 향상
     */

    static int[] fibo;  // 메모이제이션을 위한 int 배열

    public int DFS_ADVANCE(int n) {
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = DFS_ADVANCE(n - 2) + DFS_ADVANCE(n - 1);
        }
    }

    /*
    메모이제이션
     */
    static int[] memo;
    public int DFS_MEMO(int n) {
        if (memo[n] > 0) {
            return memo[n];
        }
        if (n == 1) {
            return memo[n] = 1;
        } else if (n == 2) {
            return memo[n] = 1;
        } else {
            return memo[n] = DFS_MEMO(n - 2) + DFS_MEMO(n - 1);
        }
    }
    public static void main(String[] args) {
        _04_recursive recursive = new _04_recursive();
        int n = 45;


        // sol 1
//        for (int i = 1; i < n; i++) {
//            System.out.println(recursive.DFS(i) + " ");
//        }

        // sol 2
//        fibo = new int[n + 1];
//
//        recursive.DFS_ADVANCE(n);
//        for (int i = 1; i < n; i++) {
//            System.out.println(fibo[i] + " ");
//        }

        // sol 3
        memo = new int[n + 1];

        recursive.DFS_MEMO(n);
        for (int i = 1; i < n; i++) {
            System.out.println(memo[i] + " ");
        }

    }
}
