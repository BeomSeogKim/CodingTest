package programmers.book.chap05;

public class Example {
    /*
     * n의 m승 구하는 solution
     */
    private int power(int n, int m) {
        if (m == 0) return 1;
        if (n == 1) return 1;
        if (n == 0) return 1;

        return power(n, m - 1);
    }
}
